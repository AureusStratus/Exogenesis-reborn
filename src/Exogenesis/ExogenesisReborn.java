package Exogenesis;

import Exogenesis.content.ExoBlocks;
import Exogenesis.content.ExoUnitTypes;
import mindustry.mod.Mod;

public class ExogenesisReborn extends Mod {
    public void loadContent(){
        ExoBlocks.load();
        ExoUnitTypes.load();
    }
}
