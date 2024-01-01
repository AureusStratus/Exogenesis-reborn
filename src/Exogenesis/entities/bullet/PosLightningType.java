package Exogenesis.entities.bullet;

import Exogenesis.type.DamageType;
import arc.Events;
import arc.util.Tmp;
import mindustry.content.Fx;
import mindustry.entities.Damage;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BulletType;
import mindustry.game.EventType;
import mindustry.gen.*;
import Exogenesis.type.*;
import Exogenesis.content.ExoFx;
import Exogenesis.util.feature.PositionLightning;

public class PosLightningType extends BulletType{
	public int boltNum = 2;
	public DamageType damageType = DamageType.energy;
	public float hitEffectRotation = 12f;
	
	public PosLightningType(float damage){
		super(0.0001f, damage);
		scaleLife = true;
		hitShake = 2f;
		hitSound = Sounds.spark;
		absorbable = keepVelocity = false;
		instantDisappear = true;
		collides = false;
		collidesAir = collidesGround = true;
		lightningDamage = damage;
		hitEffect = shootEffect = smokeEffect = Fx.none;
		despawnEffect = Fx.none;
	}
	@Override
	public void hitEntity(Bullet b, Hitboxc entity, float health){
		boolean wasDead = entity instanceof Unit u && u.dead;

		if(entity instanceof Unit unit){
			float mul = 1f;
			if(unit.type instanceof ExoUnitType exoType) mul = exoType.multipliers[damageType.index];

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

	@Override
	public void init(){
		super.init();
		drawSize = Math.max(drawSize, maxRange * 2);
		if(smokeEffect == Fx.none)smokeEffect = Fx.shootBigSmoke;
	}
	
	public float range(){
		return maxRange;
	}
	
	@Override
	public void init(Bullet b){
		float length = b.lifetime * range() / lifetime;
		
		Healthc target = Damage.linecast(b, b.x, b.y, b.rotation(), length + 4f);
		b.data = target;
		
		if(target instanceof Hitboxc){
			Hitboxc hit = (Hitboxc)target;
			hit.collision(b, hit.x(), hit.y());
			b.collision(hit, hit.x(), hit.y());
		}else if(target instanceof Building){
			Building tile = (Building)target;
			if(tile.collide(b)){
				tile.collision(b);
				hit(b, tile.x, tile.y);
			}
		}
		
		PositionLightning.createLength(b, b.team, b, length, b.rotation(), lightningColor, true, 0, 0, PositionLightning.WIDTH, boltNum, p -> {
			hitEffect.at(p.getX(), p.getY(), hitEffectRotation, hitColor);
			Effect.shake(hitShake, hitShake, p);
		});
		super.init(b);
	}
	
	@Override
	public void despawned(Bullet b){
		despawnEffect.at(b.x, b.y, b.rotation(), lightningColor);
	}
	
	@Override
	public void hit(Bullet b){}
	
	@Override
	public void hit(Bullet b, float x, float y){}
	
	@Override
	public void draw(Bullet b){}
	
	@Override
	public void drawLight(Bullet b){}
}
