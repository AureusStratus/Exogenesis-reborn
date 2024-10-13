package Exogenesis;

import Exogenesis.util.util.Utils;
import Exogenesis.content.ExoBlocks;
import Exogenesis.content.ExoVanstarBlocks;
import Exogenesis.content.ExoUnitTypes;
import Exogenesis.content.ExoStatusEffects;
import Exogenesis.content.*;
import mindustry.mod.Mod;
import mindustry.mod.Mods;
import Exogenesis.gen.*;

import static arc.Core.*;
public class Exogenesis extends Mod {
    public static Mods.LoadedMod modInfo;
    @Override
    public void loadContent() {
        EntityRegistry.register();
        Utils.init();
        ExoStatusEffects.load();
        ExoAttribute.load();
        ExoSounds.load();
        ExoUnitTypes.load();
        ExoLiquids.load();
        ExoItems.load();
        ExoEnvironmentBlocks.load();
        ExoBlocks.load();
        ExoVanstarBlocks.load();
        TypeMultipliers.load();
        ExoPlanets.load();
        ExoVanstarTechTree.load();
    }
}