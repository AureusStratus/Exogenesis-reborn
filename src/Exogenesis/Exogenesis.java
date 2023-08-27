package Exogenesis;

import arc.files.*;
import arc.util.*;
import mindustry.*;
import Exogenesis.content.ExoBlocks;
import Exogenesis.content.ExoUnitTypes;
import Exogenesis.content.*;
import mindustry.mod.Mod;

public class Exogenesis extends Mod {
    public static void print(Exception e) {
    }

    @Override
    public void loadContent() {
        ExoSounds.load();
        ExoUnitTypes.load();
        ExoItems.load();
        ExoBlocks.load();
    }
}