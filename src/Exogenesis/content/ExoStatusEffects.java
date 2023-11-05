package Exogenesis.content;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import mindustry.game.EventType.*;
import mindustry.game.*;
import Exogenesis.graphics.ExoPal;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.entities.effect.*;

import static mindustry.Vars.*;

public class ExoStatusEffects{
    public static StatusEffect RheaBuff, CronusBuff;

    public static void load(){
        CronusBuff = new StatusEffect("rhea-buff"){{
            color = ExoPal.erekirRed;
            damageMultiplier = 1.25f;
            effectChance = 0.07f;
            effect = new WaveEffect(){{
                colorFrom = ExoPal.erekirRedlight;
                colorTo = ExoPal.erekirPink;
                sides = 4;
                sizeFrom = 0;
                sizeTo = 2f;
                lifetime = 9f;
                strokeTo = 1;
                strokeFrom = 0f;
            }};
        }};
        RheaBuff = new StatusEffect("rhea-buff"){{
            color = ExoPal.erekirPink;
            reloadMultiplier = 1.25f;
            damage = -0.2f;
            effectChance = 0.07f;
            effect = new WaveEffect(){{
                colorFrom = Color.valueOf("ffcbdd");
                colorTo = ExoPal.erekirPink;
                sizeFrom = 0;
                sizeTo = 3f;
                lifetime = 15f;
                strokeTo = 1;
                strokeFrom = 0f;
            }};
        }};
    }
}

