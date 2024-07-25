package Exogenesis.type.bullet;
import Exogenesis.type.DamageType;
import Exogenesis.type.bullet.vanilla.ExoLaserBulletType;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.util.Tmp;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.gen.Bullet;
import mindustry.graphics.Drawf;
import Exogenesis.util.feature.PositionLightning;

public class FancyLaserBulletType extends ExoLaserBulletType {
    public boolean drawLine = false;
    public int boltNum = 2;
    public float liWidth = PositionLightning.WIDTH - 1f;

    public FancyLaserBulletType(float damage){
        super(damage);
    }

    public FancyLaserBulletType(){
        this(1f);
    }

    @Override
    public void init(Bullet b){
        super.init(b);
        PositionLightning.createEffect(b, b.fdata * 0.95f, b.rotation(), hitColor, boltNum, liWidth);
    }

    @Override
    public void draw(Bullet b){
        float realLength = b.fdata;

        float f = Mathf.curve(b.fin(), 0f, 0.2f);
        float baseLen = realLength * f;
        float cwidth = width;
        float compound = 1f;

        if(drawLine)Lines.lineAngle(b.x, b.y, b.rotation(), baseLen);
        for(Color color : colors){
            Draw.color(color);
            Lines.stroke((cwidth *= lengthFalloff) * b.fout());
            Lines.lineAngle(b.x, b.y, b.rotation(), baseLen, false);
            Tmp.v1.trns(b.rotation(), baseLen);
            Drawf.tri(b.x + Tmp.v1.x, b.y + Tmp.v1.y, Lines.getStroke() * 1.22f, cwidth * 2f + width / 2f, b.rotation());

            Fill.circle(b.x, b.y, 1f * cwidth * b.fout());
            for(int i : Mathf.signs){
                Drawf.tri(b.x, b.y, sideWidth * b.fout() * cwidth, sideLength * compound, b.rotation() + sideAngle * i);
            }

            compound *= lengthFalloff;
        }
        Draw.reset();

        Tmp.v1.trns(b.rotation(), baseLen * 1.1f);
        Drawf.light(b.x, b.y, b.x + Tmp.v1.x, b.y + Tmp.v1.y, width * 1.4f * b.fout(), colors[0], 0.6f);
    }
}














