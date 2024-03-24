package Exogenesis;

import Exogenesis.entities.effect.*;
import Exogenesis.graphics.*;
import mindustry.entities.*;
import mindustry.graphics.*;
import mindustry.mod.*;

import static arc.Core.*;
import static mindustry.Vars.*;

public class BlackHoleMod extends Mod{
    public static Effect defaultSwirlEffect = new SwirlEffect(90f, 8, 3f, 120f, 480f, true).layer(Layer.effect + 0.005f);

    public BlackHoleMod(){
        ClassMap.classes.put("BlackHoleAbility", Exogenesis.type.abilities.BlackHoleAbility.class);
        ClassMap.classes.put("BlackHoleBulletType", Exogenesis.type.bullet.BlackHoleBulletType.class);
        ClassMap.classes.put("BlackHolePart", Exogenesis.entities.part.BlackHolePart.class);
        ClassMap.classes.put("DrawBlackHole", Exogenesis.world.draw.DrawBlackHole.class);
        ClassMap.classes.put("SwirlEffect", SwirlEffect.class);
    }

    @Override
    public void init(){
        BlackHoleRenderer.init(settings.getBool("advanced-black-hole-rendering", true));

        ui.settings.graphics.checkPref("advanced-black-hole-rendering", true, BlackHoleRenderer::toggleAdvanced);
    }
}
