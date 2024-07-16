package Exogenesis.type.bullet.vanilla;

import Exogenesis.type.DamageType;
import Exogenesis.type.bullet.TypedBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.gen.Bullet;
import mindustry.gen.Hitboxc;

public class ExoLaserBulletType extends LaserBulletType implements TypedBulletType{
    public DamageType damageType;

    public ExoLaserBulletType(float damage){
        super(damage);
    }
    public ExoLaserBulletType(){
        this(1f);
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
