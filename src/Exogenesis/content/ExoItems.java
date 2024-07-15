package Exogenesis.content;

import arc.graphics.*;
import mindustry.type.*;
public class ExoItems{
    public static Item
            //multi-faction items
            osmium, gold, leadZinc, uranimite,
            //Vanstar items
            oltuxium, rustyCopper, cobolt, iron, quartz, empyreanPlating, magnetite, litusiumAlloy,
            neodymium, lightningStone, urkaStone, viliotStone, luxiteStone, vousarStone,
            radCore, eternionCore, positeCore, negesiteCore, thermoCore, chronophite, vastanium, vanstariumAlloy, lumeonEnergyCell,

            //hadrox items
            volcanite, nickel, denseGraphite, primordiumAlloy, hadroxanDiamond, terminusEnergyCell,
            //Axin items
            astrolite, curtuses, stellarIron, urbium, selfHealingAlloy, axionCell, terrilium, axidamite, lanosium, thermkronxite, axinDiamond, axinvaxaAlloy, axionEnergyCell;
    public static void load(){
        //multi-faction items
        uranimite = new Item("uranimite", Color.valueOf("8cdf64")){{
            cost = 1.1f;
            hardness = 5;
        }};
        osmium = new Item("osmium", Color.valueOf("c9dde3")){{
            cost = 1.1f;
            hardness = 4;
        }};
        gold = new Item("gold", Color.valueOf("ffe642")){{
            cost = 1f;
            hardness = 3;
        }};
        leadZinc = new Item("lead-zinc", Color.valueOf("bfcacd")){{
            cost = 1f;
            hardness = 1;
        }};
        //Vanstar items
        cobolt = new Item("cobolt", Color.valueOf("8aa8ff")){{
            cost = 0.5f;
            hardness = 1;
            alwaysUnlocked = true;
        }};
        rustyCopper = new Item("rusty-copper", Color.valueOf("d99d73")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};
        quartz = new Item("quartz", Color.valueOf("d99d73")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};
        oltuxium = new Item("oltuxium", Color.valueOf("e8d174")){{
            cost = 0.5f;
            hardness = 1;
            charge = 0.25f;
        }};
        iron = new Item("iron", Color.valueOf("9295a3")){{
            cost = 1f;
            hardness = 3;
        }};
        empyreanPlating = new Item("empyrean-plating", Color.valueOf("9295a3")){{
            cost = 1f;
        }};
        magnetite = new Item("magnetite", Color.valueOf("3e404c")){{
            cost = 0.6f;
            hardness = 2;
            charge = 0.25f;
        }};
        litusiumAlloy = new Item("litusium-alloy", Color.valueOf("2d2f38")){{
            cost = 1f;
            charge = 0.25f;
        }};
        viliotStone = new Item("viliot-stone", Color.valueOf("bfb1ff")){{
            cost = 1.1f;
            hardness = 3;
        }};
        lightningStone = new Item("lightning-stone", Color.valueOf("d3ffff")){{
            cost = 1.1f;
            hardness = 3;
            charge = 1.25f;
        }};
        urkaStone = new Item("urka-stone", Color.valueOf("7fd957")){{
            cost = 1.1f;
            hardness = 3;
            radioactivity = 0.5f;
        }};
        luxiteStone = new Item("luxite-stone", Color.valueOf("fcff98")){{
            cost = 1.1f;
            hardness = 3;
        }};
        vousarStone = new Item("vousar-stone", Color.valueOf("ff636a")){{
            cost = 1.1f;
            hardness = 3;
        }};
        eternionCore = new Item("eternion-core", Color.valueOf("9681fb")){{
            cost = 1.2f;
        }};
        radCore = new Item("rad-core", Color.valueOf("50a354")){{
            cost = 1.2f;
        }};
        positeCore = new Item("posite-core", Color.valueOf("6ac4df")){{
            cost = 1.2f;
        }};
        negesiteCore = new Item("negesite-core", Color.valueOf("f5c045")){{
            cost = 1.2f;
        }};
        thermoCore = new Item("thermo-core", Color.valueOf("d3254f")){{
            cost = 1.2f;
        }};
        vastanium = new Item("vastanium", Color.valueOf("cbd97f")){{
            flammability = 0.1f;
            explosiveness = 0.2f;
            cost = 1.3f;
            healthScaling = 0.1f;
        }};
        neodymium = new Item("neodymium", Color.valueOf("b4b9b7")){{
            cost = 1.3f;
            hardness = 5;
        }};
        chronophite = new Item("chronophite", Color.valueOf("efefef")){{
            cost = 1.4f;
            hardness = 5;
        }};
        vanstariumAlloy = new Item("vanstarium-alloy", Color.valueOf("fff451")){{
            cost = 1.4f;
            charge = 6;
        }};
        lumeonEnergyCell = new Item("lumeon-energy-cell", Color.valueOf("fbff89")){{
            cost = 1.6f;
            charge = 10;
        }};
        //hadrox items
        volcanite = new Item("volcanite", Color.valueOf("ff8d54")){{
            cost = 0.5f;
            hardness = 1;
        }};
        nickel = new Item("nickel", Color.valueOf("8bc99e")){{
            cost = 0.5f;
            hardness = 1;
        }};
        denseGraphite = new Item("dense-graphite", Color.valueOf("4e5b71")){{
            cost = 0.8f;
            hardness = 2;
        }};
        primordiumAlloy = new Item("primordium-alloy", Color.valueOf("e35140")){{
            cost = 1.3f;
            charge = 0.25f;
        }};
        hadroxanDiamond = new Item("hadroxan-diamond", Color.valueOf("ff6363")){{
            cost = 1.4f;
        }};
        terminusEnergyCell = new Item("terminus-energy-cell", Color.valueOf("ff4747")){{
            cost = 1.6f;
        }};
        //Axin items
        astrolite = new Item("astrolite", Color.valueOf("99e7ff")){{
            cost = 0.5f;
            hardness = 1;
        }};
        curtuses = new Item("curtuses", Color.valueOf("8deebb")){{
            cost = 0.6f;
            hardness = 1;
        }};
        stellarIron = new Item("stellar-iron", Color.valueOf("77a7be")){{
            cost = 1f;
            hardness = 2;
        }};
        urbium = new Item("urbium", Color.valueOf("5f6f9a")){{
            cost = 1f;
            hardness = 3;
            radioactivity = 0.25f;
        }};
        selfHealingAlloy = new Item("self-healing-alloy", Color.valueOf("5f6f9a")){{
            cost = 1f;
            hardness = 3;
        }};
        axionCell = new Item("axion-cell", Color.valueOf("5f6f9a")){{
            cost = 1f;
        }};
        terrilium = new Item("terrilium", Color.valueOf("dc93ff")){{
            cost = 1.1f;
        }};
        axidamite = new Item("axidamite", Color.valueOf("d3ffe8")){{
            cost = 1.1f;
            hardness = 4;
        }};
        thermkronxite = new Item("thermkronxite", Color.valueOf("ff7163")){{
            cost = 1.1f;
            hardness = 4;
        }};
        lanosium = new Item("lanosium", Color.valueOf("9a6ef3")){{
            cost = 1.2f;
            hardness = 5;
        }};
        axinvaxaAlloy = new Item("axinvaxa-alloy", Color.valueOf("74c2e8")){{
            cost = 1.3f;
            charge = 4;
        }};
        axinDiamond = new Item("axin-diamond", Color.valueOf("c3f1ff")){{
            cost = 1.3f;
        }};
        axionEnergyCell = new Item("axion-energy-cell", Color.valueOf("85d5ff")){{
            cost = 1.5f;
            charge = 15;
        }};
    }
}
