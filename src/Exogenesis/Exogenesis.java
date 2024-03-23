package Exogenesis;

import Exogenesis.util.util.Utils;
import arc.files.*;
import arc.util.*;
import mindustry.*;
import Exogenesis.content.ExoBlocks;
import Exogenesis.content.ExoUnitTypes;
import Exogenesis.content.*;
import Exogenesis.util.*;
import mindustry.mod.Mod;

public class Exogenesis extends Mod {
    @Override
    public void loadContent() {
        Utils.init();
        ExoStatusEffects.load();
        ExoAttribute.load();
        ExoSounds.load();
        ExoUnitTypes.load();
        ExoItems.load();
        ExoBlocks.load();
        TypeMultipliers.load();
    }
}