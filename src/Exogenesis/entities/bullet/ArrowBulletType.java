package Exogenesis.entities.bullet;

import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.entities.bullet.*;
import Exogenesis.entities.bullet.ExoBullet;
import mindustry.game.EventType;
import mindustry.gen.*;
import Exogenesis.type.ExoUnitType;
import arc.Events;
import Exogenesis.type.DamageType;

public class ArrowBulletType extends BasicBulletType implements ExoBullet {

    public DamageType damageType = DamageType.kinetic;
    public ArrowBulletType(float speed, float damage){
        super(speed, damage);
        trailLength = 35;
    }
    @Override
    public void draw(Bullet b){
        drawTrail(b);
        Tmp.v1.trns(b.rotation(), height / 2f);
        for(int s : Mathf.signs){
            Tmp.v2.trns(b.rotation() - 90f, width * s, -height);
            Draw.color(backColor);
            Fill.tri(Tmp.v1.x + b.x, Tmp.v1.y + b.y, -Tmp.v1.x + b.x, -Tmp.v1.y + b.y, Tmp.v2.x + b.x, Tmp.v2.y + b.y);
            Draw.color(frontColor);
            Fill.tri(Tmp.v1.x / 2f + b.x, Tmp.v1.y / 2f + b.y, -Tmp.v1.x / 2f + b.x, -Tmp.v1.y / 2f + b.y, Tmp.v2.x / 2f + b.x, Tmp.v2.y / 2f + b.y);
        }
    }
    @Override
    public DamageType damageType(){
        return damageType;
    }
    @Override
    public void hitEntity(Bullet b, Hitboxc entity, float health){
        boolean wasDead = entity instanceof Unit u && u.dead;

        if(entity instanceof Unit unit){
            float mul = 1f;
            if(unit.type instanceof ExoUnitType exoType) mul = exoType.multipliers[Structs.indexOf(DamageType.values(), damageType)];

            if(pierceArmor){
                unit.damagePierce(b.damage * mul);
            }else{
                unit.damage(b.damage * mul);
            }

            Tmp.v3.set(unit).sub(b).nor().scl(knockback * 80f);
            if(impact) Tmp.v3.setAngle(b.rotation() + (knockback < 0 ? 180f : 0f));
            unit.impulse(Tmp.v3);
            unit.apply(status, statusDuration);

            Events.fire(new EventType.UnitDamageEvent().set(unit, b));
        } else if(entity instanceof Healthc h){
            if(pierceArmor){
                h.damagePierce(b.damage);
            }else{
                h.damage(b.damage);
            }
        }

        if(!wasDead && entity instanceof Unit unit && unit.dead){
            Events.fire(new EventType.UnitBulletDestroyEvent(unit, b));
        }

        handlePierce(b, health, entity.x(), entity.y());
    }
}