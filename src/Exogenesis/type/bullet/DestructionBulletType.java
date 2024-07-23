package Exogenesis.type.bullet;

import Exogenesis.content.ExoFx;
import Exogenesis.type.bullet.vanilla.ExoBasicBulletType;
import arc.audio.Sound;
import arc.func.Cons;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.math.geom.Position;
import arc.math.geom.Vec2;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.entities.Damage;
import mindustry.entities.Effect;
import mindustry.entities.Lightning;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Building;
import mindustry.gen.Bullet;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import Exogenesis.util.feature.PositionLightning;

import static arc.graphics.g2d.Draw.color;
import static arc.math.Angles.randLenVectors;

public class DestructionBulletType extends ExoBasicBulletType{
    public float hitSpacing = 10f;
    public float size = 30f;
    public float linkRange = 240f;
    public float boltWidth = PositionLightning.WIDTH;

    public float randomGenerateRange = -1f;
    public float randomGenerateChance = 0.03f;
    public float randomLightningChance = 0.1f;
    public int randomLightningNum = 4;
    public Sound randomGenerateSound = Sounds.blaster;

    public Cons<Position> hitModifier = p -> {};

    public float range = -1;

    public int maxHit = 20;
    public int boltNum = 1;

    public int  effectLingtning = 2;
    public float effectLightningChance = 0.35f;
    public float effectLightningLength = -1;
    public float effectLightningLengthRand = -1;

    public float trueHitChance = 0.66f;

    public boolean drawCircle = true;

    public Effect slopeEffect, liHitEffect, spreadEffect;

    public static final Vec2 randVec = new Vec2();

    public DestructionBulletType(float speed, float damage){
        super(speed, damage);
        collidesGround = collidesAir = true;
        collides = false;
        scaleLife = despawnHit = true;
        hitShake = 3.0F;
        hitSound = Sounds.explosion;
        shootEffect = Fx.shootBig;
        lightning = 4;
        lightningLength = 3;
        lightningLengthRand = 12;
        lightningCone = 360f;

        trailWidth = -1;

        liHitEffect = ExoFx.hitMeltColor;
    }

    public DestructionBulletType(){
        this(1f, 1f);
    }

    @Override
    public boolean testCollision(Bullet bullet, Building tile){
        return super.testCollision(bullet, tile);
    }

    @Override
    public float estimateDPS(){
        return lightningDamage * maxHit * 0.75f * 60 / hitSpacing;
    }

    @Override
    public void init(){
        super.init();
        if(slopeEffect == null)slopeEffect = new Effect(25, e -> {
            if(!(e.data instanceof Integer))return;
            int i = e.data();
            Draw.color(backColor);
            Angles.randLenVectors(e.id, (int)(size / 8f), size / 4f + size * 2f * e.fin(), (x, y) -> Fill.circle(e.x + x, e.y + y, e.fout() * size / 1.65f));
            Lines.stroke((i < 0 ? e.fin() : e.fout()) * 3f);
            Lines.circle(e.x, e.y, (i > 0 ? e.fin() : e.fout()) * size * 1.1f);
        });
        if(spreadEffect == null)spreadEffect = new Effect(32f, e -> randLenVectors(e.id, 2, 6 + 45 * e.fin(), (x, y) -> {
            color(backColor);
            Fill.circle(e.x + x, e.y + y, e.fout() * size / 2f);
            color(frontColor);
            Fill.circle(e.x + x, e.y + y, e.fout() * (size / 3f - 1f));
        })).layer(Layer.effect + 0.00001f);

        if(trailWidth < 0)trailWidth = size * 0.75f;
        if(trailLength < 0)trailLength = 12;

        drawSize = Math.max(drawSize, size * 2f);

        if(effectLightningLength < 0)effectLightningLength = size * 1.5f;
        if(effectLightningLengthRand < 0)effectLightningLengthRand = size * 2f;
    }

    @Override
    public void update(Bullet b) {
        super.update(b);

        Effect.shake(hitShake, hitShake, b);
        if (b.timer(4, hitSpacing)) {
            for(int i : Mathf.signs)slopeEffect.at(b.x + Mathf.range(size / 4f), b.y + Mathf.range(size / 4f), b.rotation(), i);
            spreadEffect.at(b);
            PositionLightning.setHitChance(trueHitChance);
            PositionLightning.createRange(b, collidesAir, collidesGround, b, b.team, linkRange, maxHit, backColor, Mathf.chanceDelta(randomLightningChance), lightningDamage, lightningLength, PositionLightning.WIDTH, boltNum, p -> {
                liHitEffect.at(p.getX(), p.getY(), hitColor);
            });
            PositionLightning.setHitChanceDef();
        }

        if(randomGenerateRange > 0f && Mathf.chance(Time.delta * randomGenerateChance) && b.lifetime - b.time > PositionLightning.lifetime)PositionLightning.createRandomRange(b, b.team, b, randomGenerateRange, backColor, Mathf.chanceDelta(randomLightningChance), 0, 0, boltWidth, boltNum, randomLightningNum, hitPos -> {
            randomGenerateSound.at(hitPos, Mathf.random(0.9f, 1.1f));
            Damage.damage(b.team, hitPos.getX(), hitPos.getY(), splashDamageRadius / 8, splashDamage * b.damageMultiplier() / 8, collidesAir, collidesGround);
            ExoFx.empyreanStarHitSmall.at(hitPos.getX(), hitPos.getY(), lightningColor);

            hitModifier.get(hitPos);
        });
    }

    @Override
    public void init(Bullet b) {
        super.init(b);

        b.vel.scl(1 + b.lifetime * drag * 28 / lifetime);
    }

    @Override
    public void draw(Bullet b) {
        drawTrail(b);

        if(drawCircle){
            color(backColor);
            Fill.circle(b.x, b.y, size);
            color(frontColor);
            Fill.circle(b.x, b.y, size / 7f + size / 3 * Mathf.curve(b.fout(), 0.1f, 0.35f));
        }else{
            super.draw(b);
        }

        Drawf.light(b.x, b.y, size * 1.85f, backColor, 0.7f);
    }

    @Override
    public void despawned(Bullet b) {
        PositionLightning.createRandomRange(b, b.team, b, randomGenerateRange, backColor, Mathf.chanceDelta(randomLightningChance), 0, 0, boltWidth, boltNum, randomLightningNum, hitPos -> {
            Damage.damage(b.team, hitPos.getX(), hitPos.getY(), splashDamageRadius, splashDamage * b.damageMultiplier(), collidesAir, collidesGround);
            ExoFx.colorBombSmaller.at(hitPos.getX(), hitPos.getY(), lightningColor);
            liHitEffect.at(hitPos);
            for (int j = 0; j < lightning; j++) {
                Lightning.create(b, lightningColor, lightningDamage < 0.0F ? damage : lightningDamage, b.x, b.y, b.rotation() + Mathf.range(lightningCone / 2.0F) + lightningAngle, lightningLength + Mathf.random(lightningLengthRand));
            }
            hitSound.at(hitPos, Mathf.random(0.9f, 1.1f));

            hitModifier.get(hitPos);
        });

        super.despawned(b);
    }
}