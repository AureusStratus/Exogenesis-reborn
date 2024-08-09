package Exogenesis.type.bullet.vanilla;

import Exogenesis.type.DamageType;
import Exogenesis.type.bullet.TypedBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.gen.Bullet;
import mindustry.gen.Hitboxc;

public class ExoBombBulletType extends BombBulletType implements TypedBulletType {
    public DamageType damageType;

    public ExoBombBulletType(float damage, float radius){
        super(0.7f, 0);
        splashDamageRadius = radius;
        splashDamage = damage;
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