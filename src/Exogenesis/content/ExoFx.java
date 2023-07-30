package Exogenesis.content;
import Exogenesis.graphics.ExoPal;
import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.units.UnitAssembler.*;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class ExoFx{
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();

    public static final Effect
        empyreanExplosion = new Effect(30f, 160f, e -> {
        color(e.color);
        stroke(e.fout() * 5f);
        float circleRad = 6f + e.finpow() * 60f;
        Lines.circle(e.x, e.y, circleRad);
        stroke(e.fout());
        randLenVectors(e.id + 1, 8, 5f + 60f * e.finpow(), (x, y) -> lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 3f + e.fout() * 3f));
        rand.setSeed(e.id);
        for(int i = 0; i < 16; i++){
            float angle = rand.random(360f);
            float lenRand = rand.random(0.5f, 1f);
            Tmp.v1.trns(angle, circleRad);

            for(int s : Mathf.signs){
                Drawf.tri(e.x + Tmp.v1.x, e.y + Tmp.v1.y, e.foutpow() * 30f, e.fout() * 20f * lenRand + 6f, angle + 90f + s * 90f);
            }
        }
        color(e.color);
        for(int i = 0; i < 7; i++){
            Drawf.tri(e.x, e.y, 6f, 70f * e.fout(), i*90);
        }
        color();
        for(int i = 0; i < 7; i++){
            Drawf.tri(e.x, e.y, 3f, 35f * e.fout(), i*90);
        }
    }),
    colorBomb = new Effect(40f, 100f, e -> {
        color(e.color);
        stroke(e.fout() * 2f);
        float circleRad = 4f + e.finpow() * 45f;
        Lines.circle(e.x, e.y, circleRad);

        color(e.color);
        for(int i = 0; i < 4; i++){
            Drawf.tri(e.x, e.y, 4f, 50f * e.fout(), i*90);
        }

        color();
        for(int i = 0; i < 4; i++){
            Drawf.tri(e.x, e.y, 2f, 15f * e.fout(), i*90);
        }

        Drawf.light(e.x, e.y, circleRad * 1.6f, e.color, e.fout());
    }),
            Empyreancharge = new Effect(100f, 100f, e -> {
                color(ExoPal.empyrean);
                stroke(e.fout() * 5f);
                float circleRad = 6f + e.finpow() * 65f;
                Lines.circle(e.x, e.y, circleRad);

                color(ExoPal.empyrean);
                for(int i = 0; i < 4; i++){
                    Drawf.tri(e.x, e.y, 5f, 70f * e.fin(), i*90);
                }
                color();
                for(int i = 0; i < 4; i++){
                    Drawf.tri(e.x, e.y, 3f, 35f * e.fin(), i*90);
                }
                Drawf.light(e.x, e.y, circleRad * 1.6f, ExoPal.empyrean, e.fin());
            }),
            lightErnExplosion = new Effect(40, e -> {
                color(ExoPal.empyrean);
                e.scaled(20, i -> {
                    stroke(3f * i.fout());
                    circle(e.x, e.y, 3f + i.fin() * 100f);
                });

                stroke(e.fout());
                randLenVectors(e.id + 1, 8, 1f + 60f * e.finpow(), (x, y) -> lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 3f));

                color(Color.white);

                randLenVectors(e.id, 5, 2f + 70 * e.finpow(), (x, y) -> Fill.circle(e.x + x, e.y + y, e.fout() * 4f + 0.5f));

                Drawf.light(e.x, e.y, e.fout(Interp.pow2Out) * 100f, ExoPal.empyrean, 0.7f);
            }),
            lightEnrCircleSplash = new Effect(26f, e -> {
                color(e.color);
                randLenVectors(e.id, 4, 3 + 23 * e.fin(), (x, y) -> {
                    Fill.circle(e.x + x, e.y + y, e.fout() * 4.5f);
                    Drawf.light(e.x + x, e.y + y, e.fout() * 5f, e.color, 0.7f);
                });
            }),
    colorBombSmall = new Effect(40f, 100f, e -> {
        color(e.color);
        stroke(e.fout() * 1f);
        float circleRad = 4f + e.finpow() * 30f;
        Lines.circle(e.x, e.y, circleRad);

        color(e.color);
        for(int i = 0; i < 4; i++){
            Drawf.tri(e.x, e.y, 3f, 30f * e.fout(), i*90);
        }

        color();
        for(int i = 0; i < 4; i++){
            Drawf.tri(e.x, e.y, 1.3f, 10f * e.fout(), i*90);
        }

        Drawf.light(e.x, e.y, circleRad * 1.6f, e.color, e.fout());
    });
}
