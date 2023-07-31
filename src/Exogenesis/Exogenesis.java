package Exogenesis;

import arc.files.*;
import arc.util.*;
import mindustry.*;
import Exogenesis.content.ExoBlocks;
import Exogenesis.content.ExoUnitTypes;
import Exogenesis.content.*;
import mindustry.mod.Mod;

public class Exogenesis extends Mod {
    @Override
    public void loadContent() {
        ExoUnitTypes.load();
        ExoItems.load();
        ExoBlocks.load();
    }
}