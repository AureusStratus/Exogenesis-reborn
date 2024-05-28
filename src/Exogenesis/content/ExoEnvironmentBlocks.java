package Exogenesis.content;

import Exogenesis.graphics.ExoPal;
import Exogenesis.world.blocks.ExoPowerProp;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.Attribute;

public class ExoEnvironmentBlocks {
    public static Block
    //mic
    oreOsmium, stellarIron,
    //Empyrean
    //env tiles
    powerCrystal,
    //vanstar
    deepVansterWater, vansterWater, shallowVansterWater, vansterSandyWater, yellowIce, yellowGrass, lightningStoneCharged, lightningStoneDim, skystonegrey, skystone, vanstarock, vanstarockRound, skystonebright, redLightningStone, blackSand,
    lightningStoneChargedWall, lightningStoneDimWall, redLightningStoneWall,
    //Axin
    axinCrystal, poolAxinPlasma , axinIce, axinPurpleStone, axinPurpleStoneMineral,  axinStone, axincarbonStone, axinRock, axinStoneWall,
    thenmialPlasma, thenmialPlasmaShallow, thenmialPlasmaDeep, thenmialPlasmaAbyssal, axinCyanSlate, axinSlate, axinCrystalStone, axinPurpleRock, axinPurpleSlate,
    axinStoneMinerals, alignPlating, axinCrystalBlue, axinCrystalPurple, axinCrystalTile, colossalAxinMonolith, largeAxinMonolith, mediumAxinMonolith, smallAxinMonolith, diamondGrowth, diamondTile,
    diamondWall, axinPurpleWall, axinCrystalStoneWall, axinCarvakStone, axinSlate2, axinCrystalRockBoulder, curtusesGeode, axinBoulder, axinCarvakStoneWall, axinCrystalRock, thermakronxCrystal, axinCrystalRock1,
    //ore
    oreOltuxium, oreChronophite, oreGold, oreAxiradamite, oreUrbium, oreLanosium, ferricIronWall, magnetiteOreWall, magnetiteCrystal, lightningCrystal, nickelGeode, nickelGeodeGiant, curtusesOre;
    public static void load() {
        oreOsmium = new OreBlock(ExoItems.osmium) {{
            variants = 5;
            wallOre = true;
        }};
        stellarIron = new OreBlock("stellar-iron",ExoItems.stellarIron) {{
            variants = 3;
        }};
        oreAxiradamite = new OreBlock("ore-siradamite",ExoItems.axidamite) {{
            variants = 3;
        }};
        oreUrbium = new OreBlock("ore-urbium",ExoItems.urbium) {{
            variants = 3;
        }};
        oreLanosium = new OreBlock("oreLanosium",ExoItems.lanosium) {{
            variants = 3;
        }};
        curtusesOre = new TallBlock("curtusesOre-boulder") {{
            variants = 3;
            itemDrop = ExoItems.curtuses;
            clipSize = 128f;
        }};
        nickelGeode = new StaticWall("nickel-geode") {{
            itemDrop = ExoItems.nickel;
            variants = 2;
        }};
        curtusesGeode = new StaticWall("curtuses-geode") {{
            itemDrop = ExoItems.curtuses;
            variants = 3;
        }};
        oreOltuxium = new OreBlock(ExoItems.oltuxium);
        oreChronophite = new OreBlock(ExoItems.chronophite);
        oreGold = new OreBlock(ExoItems.gold);
        ferricIronWall = new StaticWall("ferric-iron-wall") {{
            itemDrop = ExoItems.iron;
            variants = 3;
        }};
        magnetiteOreWall = new StaticWall("magnetite-ore-wall") {{
            itemDrop = ExoItems.magnetite;
            variants = 3;
        }};
        magnetiteCrystal = new TallBlock("magnetite-crystal-blocks") {{
            variants = 3;
            itemDrop = ExoItems.magnetite;
            clipSize = 128f;
        }};
        //Vanstar Tiles
        deepVansterWater = new Floor("deep-vanster-water") {{
            speedMultiplier = 0.2f;
            variants = 0;
            liquidDrop = Liquids.water;
            liquidMultiplier = 1.5f;
            isLiquid = true;
            status = StatusEffects.wet;
            statusDuration = 120f;
            drownTime = 200f;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        vansterWater = new Floor("vanster-water") {{
            speedMultiplier = 0.5f;
            variants = 0;
            status = StatusEffects.wet;
            statusDuration = 90f;
            liquidDrop = Liquids.water;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        shallowVansterWater = new Floor("shallow-vanster-water") {{
            speedMultiplier = 0.65f;
            status = StatusEffects.wet;
            liquidDrop = Liquids.water;
            statusDuration = 50f;
            cacheLayer = CacheLayer.water;
            isLiquid = true;
            albedo = 0.9f;
        }};
        vansterSandyWater = new Floor("vanster-sandy-water") {{
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            liquidDrop = Liquids.water;
            isLiquid = true;
            albedo = 0.9f;
        }};
        yellowIce = new Floor("yellow-ice") {{
            dragMultiplier = 0.35f;
            variants = 2;
            speedMultiplier = 0.9f;
            attributes.set(Attribute.water, 0.4f);
            albedo = 0.65f;
        }};
        yellowGrass = new Floor("yellow-grass") {{
            variants = 4;
        }};
        redLightningStone = new Floor("red-lightning-stone") {{
            variants = 4;
        }};
        lightningStoneCharged = new Floor("lightning-stone-charged") {{
            variants = 4;
        }};
        lightningStoneDim = new Floor("lightning-stone-dim") {{
            variants = 4;
        }};
        vanstarock = new Floor("vanstarock") {{
            variants = 7;
        }};
        vanstarockRound = new Floor("vanstarockRound") {{
            variants = 4;
        }};
        skystonegrey = new Floor("skystonegrey") {{
            variants = 5;
        }};
        skystone = new Floor("skystone") {{
            variants = 4;
        }};
        skystonebright = new Floor("skystonebright") {{
            variants = 4;
        }};
        blackSand = new Floor("blacksand") {{
            itemDrop = Items.sand;
            playerUnmineable = true;
        }};
        lightningStoneChargedWall = new StaticWall("lightning-stone-wall-charged") {{
            lightningStoneCharged.asFloor().wall = this;
        }};
        lightningStoneDimWall = new StaticWall("lightning-stone-wall-dim") {{
            lightningStoneDim.asFloor().wall = this;
        }};
        redLightningStoneWall = new StaticWall("red-lightning-stone-wall") {{
            redLightningStone.asFloor().wall = this;
        }};

        //Axin Tiles
        thenmialPlasmaAbyssal = new Floor("thenmial-plasma-abyssal") {{
            speedMultiplier = 0.2f;
            variants = 0;
            liquidDrop = ExoLiquids.coldPlasma;
            liquidMultiplier = 1.5f;
            isLiquid = true;
            status = StatusEffects.freezing;
            statusDuration = 120f;
            drownTime = 200f;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        thenmialPlasmaDeep = new Floor("thenmial-plasma-deep") {{
            speedMultiplier = 0.5f;
            variants = 0;
            status = StatusEffects.freezing;
            statusDuration = 90f;
            liquidDrop = ExoLiquids.coldPlasma;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        thenmialPlasma = new Floor("thenmial-plasma") {{
            speedMultiplier = 0.65f;
            status = StatusEffects.freezing;
            liquidDrop = ExoLiquids.coldPlasma;
            statusDuration = 50f;
            cacheLayer = CacheLayer.water;
            isLiquid = true;
            albedo = 0.9f;
        }};
        thenmialPlasmaShallow = new Floor("thenmial-plasma-shallow") {{
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            liquidDrop = ExoLiquids.coldPlasma;
            isLiquid = true;
            albedo = 0.9f;
        }};
        axincarbonStone = new Floor("axincarbon-stone") {{
            variants = 6;
            blendGroup = Blocks.carbonStone;
        }};
        axinCyanSlate = new Floor("axinCyan-slate") {{
            variants = 3;
        }};
        axinSlate = new Floor("axin1-slate") {{
            variants = 3;
            blendGroup = axinCyanSlate;
        }};
        axinCarvakStone = new Floor("axincarvak-stone") {{
            variants = 5;
        }};
        axinCarvakStoneWall = new StaticWall("axincarvak-stone-wall") {{
            axinCarvakStone.asFloor().wall = this;
        }};
        axinCrystalStone = new Floor("axin-crystalStone") {{
            variants = 7;
        }};
        axinCrystalRock = new Floor("axincrystalrock") {{
            variants = 6;
        }};
        axinCrystalRock1 = new Floor("axin-crystalrock") {{
            variants = 6;
        }};
        axinCrystalStoneWall = new StaticWall("axin-crystalStone-wall") {{
            axinCrystalStone.asFloor().wall = this;
        }};

        axinStone = new Floor("axin-stone") {{
            variants = 6;
        }};
        axinRock = new Floor("axin-rock") {{
            variants = 5;
        }};
        axinSlate2 = new Floor("axin-slate") {{
            variants = 9;
        }};
        axinStoneWall = new StaticWall("axin-stone-wall") {{
            variants = 2;
            axinStone.asFloor().wall = this;
        }};
        axinStoneMinerals = new Floor("axin-stoneMinerals") {{
            variants = 6;
            blendGroup = axinStone;
        }};

        axinPurpleStone = new Floor("axinpurple-stone") {{
            variants = 6;
        }};
        axinPurpleWall = new StaticWall("axin-purple-wall") {{
            axinPurpleStone.asFloor().wall = this;
        }};
        axinPurpleSlate = new Floor("axinpurple-slate") {{
            variants = 3;
        }};
        axinPurpleRock = new Floor("axinpurple-rock") {{
            variants = 5;
        }};
        axinPurpleStoneMineral = new Floor("axinpurpleMineral-stone") {{
            variants = 6;
            blendGroup = axinPurpleStone;
        }};

        axinCrystalTile = new Floor("axin-crystaltile") {{
            variants = 4;
        }};
        axinCrystalBlue = new Floor("axin-crystalblue") {{
            variants = 4;
        }};
        axinCrystalPurple = new Floor("axin-crystalPurple") {{
            variants = 4;
        }};
        thermakronxCrystal = new Floor("Thermakronx-crystal"){{
            itemDrop = ExoItems.thermkronxite;
            variants = 0;
            playerUnmineable = true;
        }};

        diamondTile = new Floor("axin-diamondTile") {{
            variants = 4;
        }};
        diamondWall = new StaticWall("axin-diamond-wall") {{
            diamondTile.asFloor().wall = this;
        }};
        diamondGrowth = new TallBlock("axin-diamond-growths") {{
            clipSize = 88f;
            itemDrop = ExoItems.axinDiamond;
            variants = 3;
        }};
        alignPlating = new StaticWall("align-plating") {{
            variants = 14;
        }};
        axinIce = new Floor("axin-ice") {{
            dragMultiplier = 0.4f;
            speedMultiplier = 0.9f;
            variants = 3;
        }};
        poolAxinPlasma = new Floor("pooled-axinPlasma") {{
            drownTime = 150f;
            status = StatusEffects.freezing;
            statusDuration = 240f;
            speedMultiplier = 0.5f;
            variants = 0;
            liquidDrop = ExoLiquids.axinian;
            liquidMultiplier = 0.5f;
            isLiquid = true;
            cacheLayer = CacheLayer.water;

            emitLight = true;
            lightRadius = 25f;
            lightColor = ExoPal.genesisDark.cpy().a(0.19f);
        }};
        axinCrystal = new Prop("axin-crystal") {{
            variants = 2;
        }};
        axinCrystalRockBoulder = new Prop("axincrystalrock-boulder") {{
            variants = 6;
            axinCrystalStone.asFloor().decoration = axinStoneMinerals.asFloor().decoration = this;
        }};
        axinBoulder = new Prop("axin-boulder") {{
            variants = 6;
            axinStone.asFloor().decoration = axinRock.asFloor().decoration = axinSlate2.asFloor().decoration = this;
        }};
        colossalAxinMonolith = new TallBlock("colossal-AxinMonolith") {{
            clipSize = 228f;
            layer = 77;
            shadowOffset = -25f;
        }};
        largeAxinMonolith = new TallBlock("large-AxinMonolith") {{
            clipSize = 228f;
            layer = 76;
            shadowOffset = -25f;
        }};
        mediumAxinMonolith = new TallBlock("medium-AxinMonolith") {{
            clipSize = 148f;
            shadowOffset = -13f;
        }};
        smallAxinMonolith = new TallBlock("small-AxinMonolith") {{
            clipSize = 88f;
        }};
        // Empyrean ores
        lightningCrystal = new ExoPowerProp("lightning-crystal") {{
            variants = 3;
            attributes.set(ExoAttribute.power, 1f);
            clipSize = 128f;
        }};
    }
}
