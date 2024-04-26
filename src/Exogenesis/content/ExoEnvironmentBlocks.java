package Exogenesis.content;

import Exogenesis.graphics.ExoPal;
import Exogenesis.world.blocks.ExoPowerProp;
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
    axinStoneMinerals, alignPlating, axinCrystalBlue, axinCrystalTile, axinCrystalBlend, largeAxinMonolith, mediumAxinMonolith, smallAxinMonolith,
    //ore
    oreOltuxium, oreChronophite, oreGold, oreAxiradamite, oreUrbium, oreLanosium, ferricIronWall, magnetiteOreWall, magnetiteCrystal, lightningCrystal, nickelGeode, nickelGeodeGiant;
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
        oreLanosium = new OreBlock(ExoItems.lanosium) {{
            variants = 3;
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
        thenmialPlasmaAbyssal = new Floor("Thenmial-plasma-abyssal") {{
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
        thenmialPlasmaDeep = new Floor("Thenmial-plasma-deep") {{
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
        thenmialPlasma = new Floor("Thenmial-plasma") {{
            speedMultiplier = 0.65f;
            status = StatusEffects.freezing;
            liquidDrop = ExoLiquids.coldPlasma;
            statusDuration = 50f;
            cacheLayer = CacheLayer.water;
            isLiquid = true;
            albedo = 0.9f;
        }};
        thenmialPlasmaShallow = new Floor("Thenmial-plasma-shallow") {{
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            liquidDrop = ExoLiquids.coldPlasma;
            isLiquid = true;
            albedo = 0.9f;
        }};
        nickelGeode = new StaticWall("nickel-geode") {{
            itemDrop = ExoItems.nickel;
            variants = 3;
        }};
        nickelGeodeGiant = new StaticWall("nickel-geode-giant") {{
            itemDrop = ExoItems.nickel;
            size = 4;
            variants = 0;
        }};
        axincarbonStone = new Floor("axincarbon-stone") {{
            variants = 6;
        }};
        axinCyanSlate = new Floor("axinCyan-slate") {{
            variants = 3;
        }};
        axinPurpleSlate = new Floor("axinCyan-slate") {{
            variants = 3;
        }};
        axinPurpleRock = new Floor("axinCyan-slate") {{
            variants = 5;
        }};
        axinSlate = new Floor("axin-slate") {{
            variants = 3;
        }};
        axinCrystalStone = new Floor("axin-crystalStone") {{
            variants = 4;
        }};
        axinStone = new Floor("axin-stone") {{
            variants = 6;
        }};
        axinRock = new Floor("axin-rock") {{
            variants = 5;
        }};
        axinStoneWall = new StaticWall("axin-stone-wall") {{
            variants = 2;
        }};
        axinStoneMinerals = new Floor("axin-stoneMinerals") {{
            variants = 6;
        }};
        axinPurpleStone = new Floor("axinpurple-stone") {{
            variants = 6;
        }};
        axinPurpleStoneMineral = new Floor("axinpurpleMineral-stone") {{
            variants = 6;
        }};
        axinCrystalTile = new Floor("axin-crystaltile") {{
            variants = 4;
        }};
        axinCrystalBlend = new Floor("axin-crystalblend") {{
            variants = 4;
        }};
        axinCrystalBlue = new Floor("axin-crystalblue") {{
            variants = 4;
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
            axinStone.asFloor().decoration = axinStoneMinerals.asFloor().decoration = this;
        }};
        largeAxinMonolith = new TallBlock("large-AxinMonolith") {{
            clipSize = 228f;
            size = 7;
            layer = 77;
            shadowOffset = -25f;
        }};
        largeAxinMonolith = new TallBlock("large-AxinMonolith") {{
            clipSize = 228f;
            size = 5;
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
        lightningCrystal = new ExoPowerProp("lightning-crystal") {{
            variants = 3;
            attributes.set(ExoAttribute.power, 1f);
            clipSize = 128f;
        }};
    }
}
