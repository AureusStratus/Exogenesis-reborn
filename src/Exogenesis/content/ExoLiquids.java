package Exogenesis.content;
import arc.graphics.*;
import mindustry.content.StatusEffects;
import mindustry.type.*;

public class ExoLiquids {
    public static Liquid coldPlasma, axinian, urgas, pyrothiul,
            scalvaur, krypton;

    public static void load(){
        coldPlasma = new Liquid("cold-plasma", Color.valueOf("596ab8")){{
            effect = StatusEffects.freezing;
            boilPoint = 0.5f;
            gasColor = Color.grays(0.9f);
        }};
        axinian = new Liquid("axinian", Color.valueOf("596ab8")){{
            effect = StatusEffects.freezing;
            boilPoint = 0.5f;
            gasColor = Color.grays(0.9f);
        }};
    }
}
