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
    public static StatusEffect RheaBuff;

    public static void load(){
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
