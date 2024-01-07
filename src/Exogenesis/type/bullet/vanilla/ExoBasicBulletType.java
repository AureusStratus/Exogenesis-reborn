package Exogenesis.type.bullet.vanilla;

import Exogenesis.type.bullet.TypedBulletType;
import arc.Events;
import arc.util.*;
import mindustry.entities.bullet.*;
import mindustry.game.EventType;
import mindustry.gen.*;
import Exogenesis.type.*;

public class ExoBasicBulletType extends BasicBulletType implements TypedBulletType{
    public DamageType damageType;

    public ExoBasicBulletType(float speed, float damage){
        super(speed, damage);
    }

    @Override
    public DamageType damageType(){
        return damageType;
    }

    @Override
    public void hitEntity(Bullet b, Hitboxc entity, float health){
        typedHitEntity(this, b, entity, health);
    }
}