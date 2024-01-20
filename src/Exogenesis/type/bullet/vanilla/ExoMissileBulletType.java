package Exogenesis.type.bullet.vanilla;

import mindustry.entities.bullet.MissileBulletType;
import Exogenesis.type.DamageType;
import Exogenesis.type.bullet.TypedBulletType;
import mindustry.gen.Bullet;
import mindustry.gen.Hitboxc;
public class ExoMissileBulletType extends MissileBulletType implements TypedBulletType{
    public DamageType damageType;
    @Override
    public DamageType damageType(){
        return damageType;
    }

    @Override
    public void hitEntity(Bullet b, Hitboxc entity, float health){
        typedHitEntity(this, b, entity, health);
    }
}
