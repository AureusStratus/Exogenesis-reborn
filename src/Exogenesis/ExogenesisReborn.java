package Exogenesis;

import Exogenesis.content.ExoBlocks;
import Exogenesis.content.ExoUnitTypes;
import mindustry.mod.Mod;

public class ExogenesisReborn extends Mod {
    @Override
    public void loadContent(){
        ExoBlocks.load();
        ExoUnitTypes.load();
    }
}
