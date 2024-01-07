package Exogenesis.entities.bullet.vanillabullets;

import Exogenesis.type.DamageType;
import Exogenesis.type.ExoUnitType;
import Exogenesis.entities.bullet.ExoBullet;
import arc.Events;
import arc.util.Structs;
import arc.util.Tmp;
import mindustry.entities.bullet.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;

import static Exogenesis.type.DamageType.*;

public class ExoArtilleryBulletType extends ArtilleryBulletType implements ExoBullet{
    public DamageType damageType = explosive;

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

            Events.fire(new UnitDamageEvent().set(unit, b));
        } else if(entity instanceof Healthc h){
            if(pierceArmor){
                h.damagePierce(b.damage);
            }else{
                h.damage(b.damage);
            }
        }

        if(!wasDead && entity instanceof Unit unit && unit.dead){
            Events.fire(new UnitBulletDestroyEvent(unit, b));
        }

        handlePierce(b, health, entity.x(), entity.y());
    }
}