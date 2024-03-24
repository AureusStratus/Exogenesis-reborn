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
        ClassMap.classes.put("BlackHoleAbility", Exogenesis.entities.abilities.BlackHoleAbility.class);
        ClassMap.classes.put("BlackHoleBulletType", Exogenesis.type.bullet.SingularityBulletType.class);
        ClassMap.classes.put("BlackHolePart", Exogenesis.entities.part.SingularityPart.class);
        ClassMap.classes.put("DrawBlackHole", Exogenesis.world.draw.DrawSingularity.class);
        ClassMap.classes.put("SwirlEffect", SwirlEffect.class);
    }

    @Override
    public void init(){
        SingularityRenderer.init(settings.getBool("advanced-black-hole-rendering", true));

        ui.settings.graphics.checkPref("advanced-black-hole-rendering", true, SingularityRenderer::toggleAdvanced);
    }
}
