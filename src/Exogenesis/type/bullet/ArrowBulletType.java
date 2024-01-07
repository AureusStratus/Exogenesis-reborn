package Exogenesis.type.bullet;
import Exogenesis.type.bullet.vanilla.ExoBasicBulletType;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.gen.*;

public class ArrowBulletType extends ExoBasicBulletType{
    public ArrowBulletType(float speed, float damage){
        this.speed = speed;
        this.damage = damage;
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
}