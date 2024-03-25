package Exogenesis;

import Exogenesis.entities.effect.*;
import Exogenesis.graphics.*;
import mindustry.entities.*;
import mindustry.graphics.*;
import mindustry.mod.*;
import Exogenesis.type.abilities.BlackHoleAbility;
import Exogenesis.type.bullet.BlackHoleBulletType;


import static arc.Core.*;
import static mindustry.Vars.*;

public class BlackHoleMod extends Mod{
    public static Effect defaultSwirlEffect = new SwirlEffect(90f, 8, 3f, 120f, 480f, true).layer(Layer.effect + 0.005f);

    @Override
    public void init(){
        BlackHoleRenderer.init(settings.getBool("advanced-black-hole-rendering", true));

        ui.settings.graphics.checkPref("advanced-black-hole-rendering", true, BlackHoleRenderer::toggleAdvanced);
    }
}
