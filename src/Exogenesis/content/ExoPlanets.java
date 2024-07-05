package Exogenesis.content;
import Exogenesis.graphics.ExoPal;
import Exogenesis.maps.ColorPass.*;
import Exogenesis.maps.HeightPass;
import Exogenesis.maps.HeightPass.*;
import Exogenesis.maps.planets.AxinPlanetGenerator;
import Exogenesis.maps.planets.HadroxaPlanetGenerator;
import Exogenesis.maps.planets.TauTiamasPlanetGenerator;
import Exogenesis.maps.planets.VanstarPlanetGenerator;
import arc.graphics.Color;
import arc.math.Interp;
import arc.math.geom.Vec3;
import mindustry.content.*;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.type.Planet;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;

public class ExoPlanets{
    public static Planet hadroxa, tauTiamas, vanstar, axin;
    public static void load(){
        hadroxa = new Planet("hadroxa", Planets.sun, 1f, 2){{
            generator = new HadroxaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
                cloudMeshLoader = () -> new MultiMesh(
                        new HexSkyMesh(this, 2, 0.10f, 0.14f, 5, Color.valueOf("eba768").a(0.75f), 2, 0.42f, 1f, 0.23f),
                        new HexSkyMesh(this, 3, 0.2f, 0.15f, 5, Color.valueOf("eea293").a(0.75f), 2, 0.42f, 1.2f, 0.25f)
                );
            alwaysUnlocked = true;
            landCloudColor = Color.valueOf("ed6542");
            atmosphereColor = Color.valueOf("f01822");
            defaultEnv = Env.scorching | Env.terrestrial;
            startSector = 10;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            tidalLock = true;
            orbitRadius = 11f;
            lightSrcTo = 0.5f;
            lightDstFrom = 0.2f;
            clearSectorOnLose = true;
            defaultCore = Blocks.coreBastion;
            iconColor = Color.valueOf("ff1010");
            hiddenItems.addAll (Items.serpuloItems).removeAll(Items.erekirItems);
            enemyBuildSpeedMultiplier = 0.4f;

            allowLaunchToNumbered = false;
            updateLighting = false;

            defaultAttributes.set(Attribute.heat, 1f);

            ruleSetter = r -> {
                r.waveTeam = Team.malis;
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
        vanstar = new Planet("vanstar", Planets.sun, 1f, 3){{
            generator = new VanstarPlanetGenerator() {{
                baseHeight = -1f;
                baseColor = Color.valueOf("242833");
                heights.addAll(
                        new HeightPass.AngleInterpHeight() {{
                            interp = new Interp.ExpIn(2, 4);
                            dir.set(9f, 0f, 0f);
                            magnitude = 1.5f;
                        }},
                        new AngleInterpHeight() {{
                            interp = new Interp.ExpIn(2, 4);
                            dir.set(0f, 0f, 0.2f);
                            magnitude = 1.7f;
                        }},
                        new AngleInterpHeight() {{
                            interp = new Interp.ExpIn(2, 4);
                            dir.set(0f, 0f, -0.6f);
                            magnitude = 2;
                        }},
                        new ClampHeight(0f, 0.8f),

                        new NoiseHeight() {{
                            scale = 5;
                            persistence = 0.5;
                            octaves = 1;
                            magnitude = 1f;
                            heightOffset = -1f;
                            offset.set(0f, 0f, -500f);
                        }},
                        new ClampHeight(-0.2f, 0.8f),
                        new CraterHeight(new Vec3(-3.5f, 0.25f, 1.8f), 0.3f, -0.3f),
                        new CraterHeight(new Vec3(5.3f, 0.5f, 1f), 0.13f, 0.2f) {{
                            set = true;
                        }},
                        new CraterHeight(new Vec3(8f, 0f, 1.5f), 0.13f, 0.1f) {{
                            set = true;
                        }},
                        new CraterHeight(new Vec3(-81f, 0f, 0f), 0.13f, -0.2f)
                );

                colors.addAll(
                        new NoiseColorPass() {{
                            scale = 1.5;
                            persistence = 0.5;
                            octaves = 3;
                            magnitude = 1.2f;
                            min = 0.3f;
                            max = 0.6f;
                            out = Color.valueOf("675b53");
                            offset.set(1500f, 300f, -500f);
                        }},
                        new NoiseColorPass() {{
                            seed = 6;
                            scale = 1.5;
                            persistence = 0.2;
                            octaves = 5;
                            magnitude = 1.2f;
                            min = 0.1f;
                            max = 0.4f;
                            out = Color.valueOf("d29232");
                            offset.set(1500f, 300f, -500f);
                        }},
                        new NoiseColorPass() {{
                            seed = 2;
                            scale = 1.5;
                            persistence = 0.2;
                            octaves = 7;
                            magnitude = 1.8f;
                            min = 0.1f;
                            max = 0.4f;
                            out = Color.valueOf("b26d1f");
                            offset.set(1500f, 300f, -500f);
                        }},
                        new FlatColorPass() {{
                            min = -1f;
                            max = -0.19f;
                            out = Color.valueOf("36bcdb");
                        }},
                        new CraterColorPass(new Vec3(-0.5f, 0.25f, 1f), 0.4f, Color.valueOf("2b2f3b")),
                        new CraterColorPass(new Vec3(-0.3f, 0.8f, 0.8f), 0.1f, Color.valueOf("717482")),
                        new CraterColorPass(new Vec3(1f, 0f, 0.6f), 0.2f, Color.valueOf("bda34a")),
                        new CraterColorPass(new Vec3(1f, 0f, 0f), 0.25f, Color.valueOf("5b6567"))
                );
            }};
            meshLoader = () -> new HexMesh(this, 6);
//            cloudMeshLoader = () -> new MultiMesh(
//                    new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.spore).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
//                    new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.spore, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
//            );

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            orbitRadius = 40;
            orbitSpacing = 0.7f;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            //doesn't play well with configs
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
            };
            iconColor = Color.valueOf("ffc63c");
            atmosphereColor = Color.valueOf("0e5fa0");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            alwaysUnlocked = true;
            landCloudColor = Pal.spore.cpy().a(0.5f);
            hiddenItems.addAll(Items.erekirItems).removeAll(Items.serpuloItems);
        }};
        tauTiamas = new Planet("tauTiamas", Planets.sun, 1f ,2){{
            generator = new TauTiamasPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 4);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.95f, 0.11f, 5, new Color().set(ExoPal.genesisLight).mul(0.9f).a(0.75f), 8, 0.45f, 1.6f, 0.5f),
                    new HexSkyMesh(this, 1, 1.3f, 0.15f, 6, Color.white.cpy().lerp(ExoPal.genesisLight, 0.55f).a(0.75f), 6, 0.45f, 0.6f, 0.21f)
            );
            atmosphereColor = Color.valueOf("021042");
            iconColor = Color.valueOf("1a1f73");
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            orbitRadius = 60;
            orbitSpacing = 1f;
            startSector = 10;
            totalRadius = 5.9f;
            atmosphereRadIn = -0.01f;
            atmosphereRadOut = 0.3f;
            defaultEnv = Env.underwater | Env.terrestrial;
            alwaysUnlocked = true;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
            };
        }};
        axin = new Planet("axin", Planets.sun, 1f, 2){{
            generator = new AxinPlanetGenerator() {{
                baseHeight = -1f;
                baseColor = Color.valueOf("242833");
                heights.addAll(
                        new HeightPass.AngleInterpHeight() {{
                            interp = new Interp.ExpIn(2, 4);
                            dir.set(5f, 0f, 0f);
                            magnitude = 1.5f;
                        }},
                        new AngleInterpHeight() {{
                            interp = new Interp.ExpIn(2, 4);
                            dir.set(-0.5f, 0.5f, 0.2f);
                            magnitude = 2;
                        }},
                        new AngleInterpHeight() {{
                            interp = new Interp.ExpIn(2, 4);
                            dir.set(-0.3f, -1f, -0.6f);
                            magnitude = 2;
                        }},
                        new ClampHeight(0f, 0.8f),

                        new NoiseHeight() {{
                            scale = 2;
                            persistence = 0.5;
                            octaves = 5;
                            magnitude = 1.2f;
                            heightOffset = -1f;
                            offset.set(1500f, 300f, -500f);
                        }},
                        new ClampHeight(-0.2f, 0.8f),
                        new CraterHeight(new Vec3(-0.5f, 0.25f, 1.8f), 0.3f, -0.3f),
                        new CraterHeight(new Vec3(-0.3f, 0.5f, 1f), 0.13f, 0.2f) {{
                            set = true;
                        }},
                        new CraterHeight(new Vec3(1f, 0f, 1.5f), 0.13f, 0.1f) {{
                            set = true;
                        }},
                        new CraterHeight(new Vec3(1f, 0f, 0f), 0.13f, -0.2f)
                );

                colors.addAll(
                        new NoiseColorPass() {{
                            scale = 1.5;
                            persistence = 0.5;
                            octaves = 3;
                            magnitude = 1.2f;
                            min = 0.3f;
                            max = 0.6f;
                            out = Color.valueOf("121733");
                            offset.set(1500f, 300f, -500f);
                        }},
                        new NoiseColorPass() {{
                            seed = 5;
                            scale = 1.5;
                            persistence = 0.2;
                            octaves = 5;
                            magnitude = 1.2f;
                            min = 0.1f;
                            max = 0.4f;
                            out = Color.valueOf("314860");
                            offset.set(1500f, 300f, -500f);
                        }},
                        new NoiseColorPass() {{
                            seed = 8;
                            scale = 1.5;
                            persistence = 0.2;
                            octaves = 7;
                            magnitude = 0.8f;
                            min = 0.1f;
                            max = 0.4f;
                            out = Color.valueOf("314860");
                            offset.set(1500f, 300f, -500f);
                        }},
                        new FlatColorPass() {{
                            min = -1f;
                            max = -0.19f;
                            out = Color.valueOf("c5d7f0");
                        }},
                        new CraterColorPass(new Vec3(-0.5f, 0.25f, 1f), 0.4f, Color.valueOf("252142")),
                        new CraterColorPass(new Vec3(-0.3f, 0.8f, 0.8f), 0.1f, Color.valueOf("3c5acc")),
                        new CraterColorPass(new Vec3(1f, 0f, 0.6f), 0.2f, Color.valueOf("3c4448")),
                        new CraterColorPass(new Vec3(1f, 0f, 0f), 0.25f, Color.valueOf("282b34"))
                );
            }};
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                   new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Color.blue).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                   new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Color.blue, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.61f)
            );
            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            orbitRadius = 150;
            orbitSpacing = 30;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            //doesn't play well with configs
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
            };
            iconColor = Color.valueOf("0044ff");
            atmosphereColor = Color.valueOf("1c037c");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            alwaysUnlocked = true;
            landCloudColor = Color.blue.cpy().a(0.5f);
            hiddenItems.addAll(Items.erekirItems).removeAll(Items.serpuloItems);
        }};
    }

}
