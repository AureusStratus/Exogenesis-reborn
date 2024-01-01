package Exogenesis.entities.bullet;

import arc.Events;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.game.EventType;
import mindustry.gen.*;
import Exogenesis.type.*;
import mindustry.graphics.*;

public class ExoBasicBullet extends BasicBulletType {
    public DamageType damageType = DamageType.kinetic;

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
}