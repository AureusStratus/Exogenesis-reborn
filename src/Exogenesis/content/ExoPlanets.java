package Exogenesis.content;

import arc.func.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import Exogenesis.game.ExoTeams;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.graphics.g3d.PlanetGrid.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.content.Planets;
import mindustry.world.*;
import mindustry.world.meta.*;
public class ExoPlanets {
    public static Planet
    vanstar;
    public static void load() {
        vanstar = new Planet("vanstar", Planets.sun, 1f, 2) {{
            generator = new ErekirPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 2, 1.2f, 0.13f, 5, Color.valueOf("eba768").a(0.75f), 2, 0.42f, 1.2f, 0.63f),
                    new HexSkyMesh(this, 3, 0.8f, 0.15f, 6, Color.valueOf("eea293").a(0.75f), 2, 0.42f, 0.9f, 0.45f)
            );
            alwaysUnlocked = true;
            landCloudColor = Color.valueOf("ed6542");
            atmosphereColor = Color.valueOf("f07218");
            defaultEnv = Env.terrestrial;
            startSector = 10;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            orbitSpacing = 2f;
            totalRadius += 3.6f;
            lightSrcTo = 0.5f;
            lightDstFrom = 0.2f;
            clearSectorOnLose = true;
            defaultCore = Blocks.coreBastion;
            iconColor = Color.valueOf("fee761");
            hiddenItems.addAll(Items.serpuloItems).addAll(Items.erekirItems);
            enemyBuildSpeedMultiplier = 0.7f;
            updateLighting = true;


            ruleSetter = r -> {
                r.waveTeam = ExoTeams.theEmpyrean;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = true;
                r.staticFog = true;
                r.lighting = false;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
            };

            unlockedOnLand.add(Blocks.coreBastion);
        }};
    }
}
