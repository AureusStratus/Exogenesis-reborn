package Exogenesis;

import Exogenesis.util.util.Utils;
import Exogenesis.content.ExoBlocks;
import Exogenesis.content.ExoUnitTypes;
import Exogenesis.content.ExoStatusEffects;
import Exogenesis.content.*;
import mindustry.mod.Mod;
import mindustry.mod.Mods;

import static arc.Core.*;
public class Exogenesis extends Mod {
    @Override
    public void loadContent() {
        Utils.init();
        ExoStatusEffects.load();
        ExoAttribute.load();
        ExoSounds.load();
        ExoUnitTypes.load();
        ExoLiquids.load();
        ExoItems.load();
        ExoEnvironmentBlocks.load();
        ExoBlocks.load();
        TypeMultipliers.load();
        ExoPlanets.load();
    }
}