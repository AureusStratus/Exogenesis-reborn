package Exogenesis;

import arc.files.*;
import arc.util.*;
import mindustry.*;
import Exogenesis.content.ExoBlocks;
import Exogenesis.content.ExoUnitTypes;
import mindustry.mod.Mod;

public class Exogenesis extends Mod {
    @Override
    public void loadContent() {
        ExoBlocks.load();
        ExoUnitTypes.load();
    }
}