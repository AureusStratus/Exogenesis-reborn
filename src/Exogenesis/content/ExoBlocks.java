package Exogenesis.content;

import Exogenesis.entities.part.EffectSpawnPart;
import Exogenesis.type.DamageType;
import Exogenesis.type.bullet.*;
import Exogenesis.type.bullet.vanilla.*;
import Exogenesis.world.blocks.ExoPowerProp;
import Exogenesis.world.blocks.PowerHarvester;
import Exogenesis.world.blocks.environment.Crystal;
import Exogenesis.world.turrets.SpeedupTurret;
import Exogenesis.graphics.ExoPal;
import Exogenesis.entities.effect.RepeatEffect;

import arc.util.Tmp;
import blackhole.entities.bullet.BlackHoleBulletType;
import blackhole.entities.effect.SwirlEffect;
import mindustry.entities.abilities.MoveEffectAbility;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.Seq;
import mindustry.entities.effect.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.blocks.distribution.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static Exogenesis.type.DamageType.*;
import static mindustry.type.ItemStack.*;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;

public class ExoBlocks{
    public static Block
    //mic
    oreOsmium,
    //Empyrean
    //env tiles
    powerCrystal,
    //vanstar
    deepVansterWater, vansterWater, shallowVansterWater, vansterSandyWater, yellowIce, yellowGrass, lightningStoneCharged, lightningStoneDim, skystonegrey, skystone, vanstarock, vanstarockRound, skystonebright, redLightningStone, blackSand,
    lightningStoneChargedWall, lightningStoneDimWall, redLightningStoneWall,
    //Axin
    axinCrystal, poolAxinPlasma , axinIce, axinPurpleStone, axinPurpleStoneMineral,  axinStone, axinStoneMinerals,
    //ore
    oreOltuxium, oreChronophite, oreGold, ferricIronWall, magnetiteOreWall, magnetiteCrystal, lightningCrystal,
    //env tile end ^^^
    //blocks
    ductEmpyrean, harvesterSmall, harvesterMedium,
    //turrets
    focalPoint, gale, light, bliss, prism, tanons, wrath, glory, essence, purger,
    excalibur, aspect, godsent, eminence, aeon, grandeur, aether, profane, agios, arbiter, phoss,
    //genesis align
    astral, starFleet, cosmos, armada, astrology, stellar, coldPlasmaThrower, sagittarius, nebula, halley, magnetar, neutronMortar,
            supernova, thuban, polaris, theia, constellation, tesseract, hypernovaBurst,
            genesisFactory, empyreanFactory;

    public static void load(){
        oreOsmium = new OreBlock(ExoItems.osmium){{
            variants = 5;
            wallOre = true;
        }};

        //Vanstar Tiles
        deepVansterWater = new Floor("deep-vanster-water"){{
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
        vansterWater = new Floor("vanster-water"){{
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
        shallowVansterWater = new Floor("shallow-vanster-water"){{
            speedMultiplier = 0.65f;
            status = StatusEffects.wet;
            liquidDrop = Liquids.water;
            statusDuration = 50f;
            cacheLayer = CacheLayer.water;
            isLiquid = true;
            albedo = 0.9f;
        }};
        vansterSandyWater = new Floor("vanster-sandy-water"){{
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            liquidDrop = Liquids.water;
            isLiquid = true;
            albedo = 0.9f;
        }};
        yellowIce = new Floor("yellow-ice"){{
            dragMultiplier = 0.35f;
            variants = 2;
            speedMultiplier = 0.9f;
            attributes.set(Attribute.water, 0.4f);
            albedo = 0.65f;
        }};
        yellowGrass = new Floor("yellow-grass"){{
            variants = 4;
        }};
        redLightningStone = new Floor("red-lightning-stone"){{
            variants = 4;
        }};
        lightningStoneCharged = new Floor("lightning-stone-charged"){{
            variants = 4;
        }};
        lightningStoneDim = new Floor("lightning-stone-dim"){{
            variants = 4;
        }};
        vanstarock = new Floor("vanstarock"){{
            variants = 7;
        }};
        vanstarockRound = new Floor("vanstarockRound"){{
            variants = 4;
        }};
        skystonegrey = new Floor("skystonegrey"){{
            variants = 5;
        }};
        skystone = new Floor("skystone"){{
            variants = 4;
        }};
        skystonebright = new Floor("skystonebright"){{
            variants = 4;
        }};
        blackSand = new Floor("blacksand"){{
            itemDrop = Items.sand;
            playerUnmineable = true;
        }};
        lightningStoneChargedWall = new StaticWall("lightning-stone-wall-charged"){{
            lightningStoneCharged.asFloor().wall = this;
        }};
        lightningStoneDimWall = new StaticWall("lightning-stone-wall-dim"){{
            lightningStoneDim.asFloor().wall = this;
        }};
        redLightningStoneWall = new StaticWall("red-lightning-stone-wall"){{
            redLightningStone.asFloor().wall = this;
        }};

        //Axin Tiles
        axinStone = new Floor("axin-stone"){{
            variants = 6;
        }};
        axinStoneMinerals = new Floor("axin-stoneMinerals"){{
            variants = 6;
        }};
        axinPurpleStone = new Floor("axinpurple-stone"){{
            variants = 6;
        }};
        axinPurpleStoneMineral = new Floor("axinpurpleMineral-stone"){{
            variants = 6;
        }};
        axinIce = new Floor("axin-ice"){{
            dragMultiplier = 0.4f;
            speedMultiplier = 0.9f;
            variants = 3;
            liquidDrop = Liquids.hydrogen;
        }};
        poolAxinPlasma = new Floor("pooled-axinPlasma"){{
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
        axinCrystal = new Prop("axin-crystal"){{
            variants = 3;
            axinStone.asFloor().decoration = axinStoneMinerals.asFloor().decoration = this;
        }};
        // Empyrean ores
        oreOltuxium = new OreBlock(ExoItems.oltuxium);
        oreChronophite = new OreBlock(ExoItems.chronophite);
        oreGold = new OreBlock(ExoItems.gold);
        ferricIronWall = new StaticWall("ferric-iron-wall"){{
            itemDrop = ExoItems.iron;
            variants = 3;
        }};
        magnetiteOreWall = new StaticWall("magnetite-ore-wall"){{
            itemDrop = ExoItems.magnetite;
            variants = 3;
        }};
        magnetiteCrystal = new TallBlock("magnetite-crystal-blocks"){{
            variants = 3;
            itemDrop = ExoItems.magnetite;
            clipSize = 128f;
        }};
        lightningCrystal = new ExoPowerProp("lightning-crystal"){{
            variants = 3;
            attributes.set(ExoAttribute.power, 1f);
            clipSize = 128f;
        }};
        //Empyrean blocks
        ductEmpyrean = new Duct("duct-empyrean"){{
            requirements(Category.distribution, with(Items.beryllium, 1));
            health = 90;
            speed = 4f;
            researchCost = with(Items.beryllium, 5);
        }};
        harvesterSmall = new PowerHarvester("harvester-small"){{
            requirements(Category.distribution, with(Items.beryllium, 1));
            size = 2;
            health = 90;
            researchCost = with(Items.beryllium, 5);
        }};
        harvesterMedium = new PowerHarvester("harvester-medium"){{
            requirements(Category.distribution, with(Items.beryllium, 1));
            size = 3;
            health = 90;
            researchCost = with(Items.beryllium, 5);
        }};
        //turrets Empyrean
        //tier 1
        focalPoint = new ContinuousTurret("focal-point"){{
            requirements(Category.turret, with(ExoItems.oltuxium, 15, ExoItems.cobolt, 20, ExoItems.quartz, 20));
            range = 100f;
            recoil = 0f;
            shootEffect = ExoFx.colorBombSmaller;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            shootY = 4;
            size = 2;
            scaledHealth = 280;
            shootSound = Sounds.none;
            loopSoundVolume = 1f;
            loopSound = Sounds.laserbeam;

            shootWarmupSpeed = 0.08f;
            shootCone = 360f;

            rotateSpeed = 2.5f;
            coolant = consumeCoolant(0.2f);

            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new RegionPart("-front"){{
                            progress = PartProgress.warmup;
                            moveRot = -12;
                            moveX = 4;
                            mirror = true;
                        }}
                );
            }};
            shootType = new ExoPointLaserBulletType(){{
                hitColor = trailColor = ExoPal.empyreanIndigo;
                color = Color.white;
                damageType = DamageType.energy;
                sprite = "exogenesis-focal-point-laser";
                beamEffect = Fx.none;
                trailLength = 8;
                damage = 10;
                hitEffect = ExoFx.hitMeltColor;
                smokeEffect = Fx.colorSparkBig;
            }};
        }};
        gale = new PowerTurret("gale"){{
            requirements(Category.turret, with(ExoItems.cobolt, 20, ExoItems.oltuxium, 20));
            range = 130f;
            recoil = 2f;
            reload = 50;
            shootEffect = Fx.colorSparkBig;
            smokeEffect = Fx.none;
            outlineColor = ExoPal.empyreanOutline;
            size = 2;
            scaledHealth = 280;
            shootY = 8;
            targetAir = true;
            targetGround = false;
            shootSound = Sounds.bolt;
            inaccuracy = 6;
            shootCone = 30f;
            shoot = new ShootPattern(){{
                shotDelay = 4.7f;
                shots = 3;
            }};
            rotateSpeed = 2.5f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-");
            shootType = new ExoFlakBulletType(){{
                backColor = hitColor = trailColor = ExoPal.empyrean;
                frontColor = Color.white;
                trailWidth = 2f;
                trailLength = 6;
                width = height = 25f;
                shrinkX = shootY = 0;
                damageType = kinetic;
                lifetime = 40;
                speed = 6;
                spin = 4;
                explodeDelay = 1;
                explodeRange = 40;
                splashDamageRadius = 15;
                splashDamage = 6;
                sprite = "large-bomb";
                damage = 15;
                hitEffect = despawnEffect = Fx.flakExplosion;
                fragRandomSpread = 360f;
                fragBullets = 5;
                fragVelocityMin = 1f;

                fragBullet = new ExoBasicBulletType(8, 13){{
                    sprite = "missile";
                    width = 4f;
                    pierce = true;
                    pierceCap = 1;
                    homingRange = 30;
                    homingPower = 0.1f;
                    homingDelay = 2;
                    damageType = kinetic;
                    height = 13f;
                    lifetime = 13f;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    frontColor = Color.white;
                    trailWidth = 1.3f;
                    trailLength = 6;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }};
        }};
        light = new SpeedupTurret("light"){{
            requirements(Category.turret, with(ExoItems.oltuxium, 20, ExoItems.rustyCopper, 25, ExoItems.cobolt, 20));
            range = 160f;
            recoil = 2f;
            reload = 20;
            shootEffect = new Effect(10, e -> {
                color(e.color);
                float w = 1.2f + 7 * e.fout();

                Drawf.tri(e.x, e.y, w, 45f * e.fout(), e.rotation);
                color(e.color);

                for(int i : Mathf.signs){
                    Drawf.tri(e.x, e.y, w * 0.9f, 18f * e.fout(), e.rotation + i * 90f);
                }

                Drawf.tri(e.x, e.y, w, 4f * e.fout(), e.rotation + 180f);
            });
            smokeEffect = Fx.none;
            outlineColor = ExoPal.empyreanOutline;
            size = 2;
            scaledHealth = 280;
            shootSound = Sounds.bolt;
            warmupMaintainTime = 120f;
            maxSpeedupScl = 6f;
            speedupPerShoot = 0.095f;
            overheatTime = 400f;
            shootCone = 30f;
            shoot = new ShootAlternate(){{
                barrels = 2;
                spread = 6;
            }};
            rotateSpeed = 2.5f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-");
            shootType = new ExoRailBulletType(){{
                length = 160f;
                damage = 8f;
                hitColor = ExoPal.empyreanblue;
                hitEffect = endEffect = Fx.hitBulletColor;
                pierceDamageFactor = 0.8f;
                smokeEffect = Fx.colorSpark;
                endEffect = new Effect(14f, e -> {
                    color(e.color);
                    Drawf.tri(e.x, e.y, e.fout() * 1.5f, 5f, e.rotation);
                });
                lineEffect = new Effect(20f, e -> {
                    if(!(e.data instanceof Vec2 v)) return;

                    color(e.color);
                    stroke(e.fout() * 0.9f + 0.6f);

                    Fx.rand.setSeed(e.id);
                    for(int i = 0; i < 7; i++){
                        Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                        Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                    }

                    e.scaled(14f, b -> {
                        stroke(b.fout() * 1.5f);
                        color(e.color);
                        Lines.line(e.x, e.y, v.x, v.y);
                    });
                });
            }};
        }};
        bliss = new PowerTurret("bliss"){{
            requirements(Category.turret, with(ExoItems.oltuxium, 30, Items.graphite, 30));
            range = 200f;
            recoil = 2f;
            reload = 40;
            smokeEffect = Fx.none;
            outlineColor = ExoPal.empyreanOutline;
            size = 2;
            scaledHealth = 280;
            shootSound = Sounds.laser;
            shootCone = 30f;
            shoot = new ShootSpread(){{
                shots = 4;
                spread = 9;
            }};
            rotateSpeed = 2.5f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new FlarePart(){{
                            progress = PartProgress.reload;
                            color1 = ExoPal.empyreanblue;
                            y = 6;
                            radius = 10;
                            radiusTo = 0;
                            stroke = 2.5f;
                        }}
                );
            }};
            shootType = new ExoBasicBulletType(7, 25){{
                homingRange = 100;
                homingPower = 0.075f;
                homingDelay = 6;
                parts.addAll(
                        new FlarePart(){{
                            progress = PartProgress.life;
                            color1 = ExoPal.empyreanblue;
                            radius = 16;
                            radiusTo = 16;
                            stroke = 2.5f;
                        }}
                );
                lifetime = 35;
                damageType = DamageType.energy;
                speed = 7;
                damage = 25;
                hitColor = trailColor = ExoPal.empyreanblue;
                trailWidth = 2f;
                trailLength = 6;
                weaveScale = 6;
                weaveMag = 2;
                shootEffect = ExoFx.square45_6_45;
                hitEffect = despawnEffect = ExoFx.colorBombSmaller;
                smokeEffect = Fx.colorSpark;
            }};
        }};
        prism = new ContinuousTurret("prism"){{
            requirements(Category.turret, with(ExoItems.rustyCopper, 30, Items.silicon, 50, ExoItems.empyreanPlating, 20, ExoItems.oltuxium, 30, ExoItems.iron, 40));
            range = 270f;
            recoil = 0f;
            reload = 10f;
            shootEffect = Fx.colorSparkBig;
            smokeEffect = Fx.none;
            outlineColor = ExoPal.empyreanOutline;
            size = 3;
            shootY = 0;
            rotateSpeed = 3.5f;
            warmupMaintainTime = 25f;
            minWarmup = 0.96f;
            shootWarmupSpeed = 0.04f;
            scaledHealth = 280;
            shootSound = Sounds.none;
            loopSoundVolume = 1f;
            loopSound = Sounds.laserbeam;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new FlarePart(){{
                            progress = PartProgress.warmup;
                            color1 = ExoPal.empyreanIndigo;
                            sides = 3;
                            spinSpeed = 1;
                            radius = 0;
                            radiusTo = 50;
                            stroke = 2.5f;
                        }},
                        new FlarePart(){{
                            progress = PartProgress.warmup;
                            color1 = ExoPal.empyreanIndigo;
                            sides = 2;
                            spinSpeed = 0.7f;
                            radius = 0;
                            radiusTo = 70;
                            stroke = 2.5f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            hollow = true;
                            color = ExoPal.empyreanIndigo;
                            layer = Layer.effect;
                            circle = true;
                            stroke = 0;
                            strokeTo = 1;
                            radius = 6;
                            radiusTo = 6;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            hollow = true;
                            color = ExoPal.empyreanIndigo;
                            layer = Layer.effect;
                            circle = true;
                            stroke = 0;
                            strokeTo = 0.9f;
                            radius = 7.5f;
                            radiusTo = 7.5f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            color = ExoPal.empyreanIndigoLight;
                            layer = Layer.effect;
                            circle = true;
                            radius = 0;
                            radiusTo = 4;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            color = Color.white;
                            layer = Layer.effect;
                            circle = true;
                            radius = 0;
                            radiusTo = 2f;
                        }}
                );
            }};
            shootType = new ExoPointLaserBulletType(){{
                hitColor = trailColor = ExoPal.empyreanIndigo;
                color = Color.white;
                damageType = DamageType.energy;
                sprite = "exogenesis-prism-laser";
                beamEffect = ExoFx.hitMeltColor;
                oscMag = 0.1f;
                trailWidth = 3;
                trailLength = 8;
                damage = 35;
                hitEffect = ExoFx.hitMeltColor;
                smokeEffect = Fx.colorSparkBig;
            }};
        }};
        tanons = new PowerTurret("tanons"){{
            requirements(Category.turret, with(Items.silicon, 50, ExoItems.cobolt, 30, ExoItems.magnetite, 40, ExoItems.empyreanPlating, 20, ExoItems.rustyCopper, 30));
            range = 250f;
            recoil = 0;
            reload = 8f;
            shake = 2f;
            shootEffect = Fx.colorSparkBig;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 3;
            scaledHealth = 280;
            shootSound = Sounds.spark;
            coolant = consumeCoolant(0.2f);

            consumePower(6f);
            drawer = new DrawTurret("elecian-");
            shootType = new PosLightningType(50f){{
                lightningColor = hitColor = ExoPal.empyrean;
                damageType = DamageType.energy;
                lightningDamage = 8;
                lightning = 7;
                lightningLength = 3;
                lightningLengthRand = 7;
                maxRange = rangeOverride = 250f;
                hitEffect = Fx.circleColorSpark;
                smokeEffect = Fx.shootBigSmoke2;
            }};
        }};
        glory = new PowerTurret("glory"){{
            requirements(Category.turret, with(ExoItems.cobolt, 80, ExoItems.empyreanPlating, 30, ExoItems.iron, 55, ExoItems.magnetite, 55));
            range = 450f;
            recoil = 2f;
            reload = 100f;
            shake = 2f;
            outlineColor = ExoPal.empyreanOutline;
            size = 3;
            scaledHealth = 280;
            shootSound = Sounds.railgun;
            coolant = consumeCoolant(0.4f);

            consumePower(6f);
            drawer = new DrawTurret("elecian-");
            shootType = new DelayedPointBulletType(){{
                damage = 160f;
                width = 21f;
                delayEffectLifeTime = lifetime = 0f;
                rangeOverride = 450;
                trailEffect = Fx.none;
                lightning = 7;
                lightningLength = 15;
                lightningLengthRand = 35;
                lightningDamage = 50;
                lightColor = hitColor = lightningColor = ExoPal.empyrean;
                hitEffect = despawnEffect = ExoFx.colorBomb;
                healPercent = 25f;
                collidesTeam = true;
                colors = new Color[]{ExoPal.empyreanAlpha.cpy().a(0.4f), ExoPal.empyrean, Color.white};
            }};
        }};
        //tier 2
        essence = new SpeedupTurret("essence"){{
            requirements(Category.turret, with(ExoItems.cobolt, 100, ExoItems.iron, 80, ExoItems.lightningStone, 100, Items.graphite, 80, ExoItems.empyreanPlating, 50, ExoItems.litusiumAlloy, 40));
            range = 230f;
            recoil = 2f;
            reload = 40;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 3;
            scaledHealth = 280;
            shootSound = Sounds.bolt;
            inaccuracy = 3;
            shootY = 9;
            warmupMaintainTime = 120f;
            maxSpeedupScl = 13f;
            inaccuracyUp = 1;
            speedupPerShoot = 0.095f;
            overheatTime = 400f;
            shootCone = 30f;
            xRand = 2;
            velocityRnd = 0.15f;
            shoot = new ShootPattern(){{
                shotDelay = 0;
                shots = 2;
            }};
            rotateSpeed = 2.5f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-");
            shootType = new ExoBasicBulletType(8, 17){{
                lifetime = 30f;
                damageType = kinetic;
                width = 7;
                height = 15;
                sprite = "missile-large";
                pierceArmor = true;
                shootEffect = Fx.shootBigColor;
                backColor = hitColor = trailColor = ExoPal.empyreanblue;
                frontColor = Color.white;
                trailWidth = 2f;
                trailLength = 6;
                hitEffect = despawnEffect = Fx.hitBulletColor;
            }};
        }};
        purger = new PowerTurret("purger"){{
            requirements(Category.turret, with(Items.silicon, 80, ExoItems.cobolt, 120, ExoItems.quartz, 80, ExoItems.viliotStone, 100, ExoItems.empyreanPlating, 60, ExoItems.litusiumAlloy, 80, ExoItems.magnetite, 60));
            range = 210f;
            recoil = 0;
            reload = 25;
            smokeEffect = Fx.none;
            outlineColor = ExoPal.empyreanOutline;
            size = 3;
            scaledHealth = 280;
            heatColor = Color.red;
            recoils = 2;
            shootSound = Sounds.laser;
            inaccuracy = 1;
            shootCone = 30f;
            shootY = 12;
            shoot = new ShootAlternate(){{
                barrels = 2;
                spread = 12;
            }};
            rotateSpeed = 2f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                for(int i = 0; i < 2; i++){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = true;
                        moveY = -3.5f;
                    }});
                }
            }};
            shootType = new ExoLaserBulletType(){{
                damage = 75f;
                damageType = DamageType.energy;
                sideAngle = 40f;
                sideWidth = 1.5f;
                sideLength = 30f;
                width = 25f;
                length = 210f;
                hitColor = ExoPal.empyreanIndigoDark;
                shootEffect = ExoFx.square45_6_45;
                colors = new Color[]{ExoPal.empyreanIndigoDark.cpy().a(.2f), ExoPal.empyreanIndigo, Color.white};
            }};
        }};
        excalibur = new PowerTurret("excalibur"){{
            requirements(Category.turret, with(ExoItems.cobolt, 120, ExoItems.oltuxium, 80, ExoItems.rustyCopper, 160, ExoItems.neodymium, 50, ExoItems.empyreanPlating, 100, ExoItems.viliotStone, 100, ExoItems.litusiumAlloy, 70));
            range = 270f;
            recoil = 2f;
            reload = 80f;
            shake = 2f;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 4;
            shootY = 13;
            scaledHealth = 280;
            targetAir = false;
            shootSound = Sounds.largeCannon;
            shoot = new ShootPattern(){{
                shots = 7;
                shotDelay = 5;
            }};
            velocityRnd = 0.3f;
            inaccuracy = 17f;
            coolant = consumeCoolant(0.2f);

            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new RegionPart("-body"){{
                            progress = PartProgress.recoil;
                            moveY = -6;
                            mirror = false;
                        }},
                        new RegionPart("-plate"){{
                            progress = PartProgress.recoil;
                            moveRot = -8;
                            mirror = true;
                        }}
                );
            }};
            shootType = new ExoArtilleryBulletType(){{
                hitEffect = new MultiEffect(Fx.titanExplosion, ExoFx.empyreanExplosion, Fx.flakExplosionBig);
                despawnEffect = Fx.none;
                damageType = DamageType.explosive;
                speed = 4.5f;
                damage = 150;
                sprite = "shell";
                knockback = 2f;
                lifetime = 140f;
                height = 27f;
                width = 21f;
                splashDamageRadius = 65f;
                splashDamage = 350f;
                scaledSplashDamage = true;
                backColor = hitColor = trailColor = ExoPal.empyreanIndigo;
                frontColor = Color.white;
                hitSound = Sounds.titanExplosion;

                status = StatusEffects.blasted;

                trailLength = 32;
                trailWidth = 3f;
                trailSinScl = 2.5f;
                trailSinMag = 0.5f;
                despawnShake = 7f;

                shootEffect = Fx.shootTitan;
                smokeEffect = Fx.shootSmokeTitan;

                trailInterp = v -> Math.max(Mathf.slope(v), 0.8f);
                shrinkX = 0.2f;
                shrinkY = 0.1f;
                buildingDamageMultiplier = 0.3f;
            }};
        }};
        aspect = new PowerTurret("aspect"){{
            requirements(Category.turret, with(ExoItems.rustyCopper, 160, ExoItems.cobolt, 200, ExoItems.neodymium, 100, ExoItems.iron, 100, ExoItems.viliotStone, 150, ExoItems.litusiumAlloy, 100, ExoItems.quartz, 80));
            range = 270f;
            recoil = 0f;
            reload = 10f;
            shootEffect = Fx.colorSparkBig;
            smokeEffect = Fx.none;
            outlineColor = ExoPal.empyreanOutline;
            size = 4;
            shootY = 0;
            minWarmup = 0.99f;
            scaledHealth = 280;
            shootSound = Sounds.spark;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new HaloPart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            radius = 1.5f;
                            tri = true;
                            color = ExoPal.empyreanIndigo;
                            layer = Layer.effect;
                            haloRotateSpeed = -2.5f;
                            haloRadius = 0;
                            haloRadiusTo = 8;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 4;
                            triLengthTo = 9;
                            triLength = 0f;
                        }},
                        new HaloPart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            radius = 2.5f;
                            tri = true;
                            color = ExoPal.empyreanIndigo;
                            layer = Layer.effect;
                            haloRotateSpeed = -1f;
                            haloRadius = 0;
                            haloRadiusTo = 8;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = 13;
                            triLength = 0f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            color = ExoPal.empyreanIndigoDark;
                            layer = Layer.effect;
                            circle = true;
                            radius = 0;
                            radiusTo = 8;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            color = Color.white;
                            layer = Layer.effect;
                            circle = true;
                            radius = 0;
                            radiusTo = 4;
                        }}
                );
            }};
            shootType = new ChainBulletType(80f){{
                maxHit = 10;
                chainRange = 270f;
                damageType = DamageType.energy;
                length = 270f;
                hitColor = ExoPal.empyreanIndigo;
                hitEffect = despawnEffect = Fx.hitBulletColor;
            }};
        }};
        godsent = new PowerTurret("godsent"){{
            requirements(Category.turret, with(ExoItems.rustyCopper, 200, ExoItems.cobolt, 150, ExoItems.lightningStone, 150, ExoItems.magnetite, 60, ExoItems.empyreanPlating, 100, ExoItems.iron, 160, ExoItems.litusiumAlloy, 90));
            range = 950f;
            recoil = 2f;
            reload = 80f;
            shake = 2f;
            shootEffect = Fx.colorSparkBig;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 4;
            targetGround = false;
            minWarmup = 0.99f;
            scaledHealth = 280;
            shootY = 12;
            velocityRnd = 0.1f;
            shootSound = Sounds.shootSmite;
            coolant = consumeCoolant(0.2f);
            shoot = new ShootMulti(new ShootPattern(){{
                shots = 2;
                shotDelay = 3;
            }}, new ShootAlternate(){{
                barrels = 3;
                shots = 3;
                spread = 6;
            }});
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new RegionPart("-side"){{
                            progress = PartProgress.recoil;
                            moveX = 3;
                            mirror = true;
                        }}
                );
            }};
            shootType = new ArrowBulletType(12f, 185){{
                lifetime = 49f;
                collidesGround = collidesTiles = false;
                damageType = kinetic;
                width = 6;
                height = 16;
                drag = -0.02f;
                weaveMag = 1f;
                weaveScale = 3f;
                shootEffect = Fx.shootBigColor;
                backColor = hitColor = trailColor = ExoPal.empyreanblue;
                trailWidth = 3f;
                trailLength = 6;
                hitEffect = despawnEffect = Fx.hitBulletColor;
            }};
        }};
        eminence = new PowerTurret("eminence"){{
            requirements(Category.turret, with(ExoItems.cobolt, 250, ExoItems.luxiteStone, 150, ExoItems.neodymium, 150, ExoItems.magnetite, 40, ExoItems.iron, 100, ExoItems.empyreanPlating, 80, ExoItems.litusiumAlloy, 100));
            range = 300f;
            recoil = 2f;
            reload = 120f;
            shake = 2f;
            shootEffect = Fx.colorSparkBig;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 4;
            scaledHealth = 280;
            xRand = 8;
            shoot = new ShootPattern(){{
                shotDelay = 3f;
                shots = 15;
            }};
            shootSound = Sounds.bolt;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-");
            shootType = new BasicBulletType(0f, 1){{
                shootEffect = Fx.shootBig;
                hitColor = ExoPal.empyrean;
                smokeEffect = Fx.shootSmokeMissile;
                spawnUnit = new MissileUnitType("eminence-missile"){{
                    speed = 9.6f;
                    maxRange = 6f;
                    lifetime = 45f;
                    outlineColor = ExoPal.empyreanOutline;
                    engineColor = trailColor = ExoPal.empyrean;
                    engineLayer = Layer.effect;
                    engineSize = 1.7f;
                    engineOffset = 6f;
                    rotateSpeed = 0.9f;
                    trailLength = 6;
                    missileAccelTime = 20f;
                    lowAltitude = true;
                    loopSound = Sounds.missileTrail;
                    loopSoundVolume = 0.6f;
                    deathSound = Sounds.explosion;
                    fogRadius = 0f;
                    health = 210;

                    weapons.add(new Weapon(){{
                        shootCone = 360f;
                        mirror = false;
                        reload = 1f;
                        deathExplosionEffect = shootEffect;
                        shootOnDeath = true;
                        shake = 2f;
                        bullet = new ExoExplosionBulletType(35f, 45f){{
                            hitColor = ExoPal.empyrean;
                            damageType = DamageType.explosive;
                            shootEffect = new MultiEffect(ExoFx.coloredHitLarge, ExoFx.colorBombSmall);
                            collidesGround = true;
                            collidesTiles = false;
                            buildingDamageMultiplier = 0.3f;
                        }};
                    }});
                }};
            }};
        }};
        //tier 3
        aeon = new PowerTurret("aeon"){{
            requirements(Category.turret, with(ExoItems.cobolt, 500, Items.silicon, 200, ExoItems.osmium, 200, ExoItems.vastanium, 200, ExoItems.neodymium, 320, ExoItems.urkaStone, 250, ExoItems.vanstariumAlloy, 200, ExoItems.empyreanPlating, 150, ExoItems.litusiumAlloy, 150));
            range = 290f;
            recoil = 2f;
            reload = 3f;
            shake = 2f;
            shootEffect = Fx.shootSmokeSmite;
            heatColor = ExoPal.radGreen;
            outlineColor = ExoPal.empyreanOutline;
            size = 5;
            minWarmup = 0.99f;
            shootY = 7;
            scaledHealth = 280;
            shootSound = Sounds.flame;

            inaccuracy = 4;
            shootCone = 20f;
            shoot.shots = 2;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new RegionPart("-bottom"){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            moveY = -2f;
                            moveRot = -5;
                            mirror = true;
                            under = true;
                        }},
                        new RegionPart("-plate2"){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            moveX = 4.5f;
                            recoilTime = 350;
                            mirror = true;
                        }},
                        new RegionPart("-barrelside"){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            moveY = -2f;
                            moveX = 3f;
                            moveRot = -8;
                            mirror = true;
                            heatProgress = PartProgress.warmup;

                        }},
                        new RegionPart("-barrel"){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            heatProgress = PartProgress.warmup;
                            moveY = -2f;
                            moveX = 3f;
                            moveRot = -5;
                            mirror = true;
                            under = true;
                        }},
                        new RegionPart("-wing"){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            heatProgress = PartProgress.warmup;
                            moveY = -2f;
                            moveX = 2f;
                            mirror = true;
                            under = true;
                        }}
                );
            }};
            shootType = new FireBulletType(6.6f, 75f){{
                lifetime = 42f;
                pierceCap = 6;
                pierceBuilding = true;
                collidesAir = true;
                reflectable = false;
                incendChance = 0.2f;
                incendAmount = 1;
                hitSize = 9f;
                layer = Layer.bullet - 0.001f;
                status = StatusEffects.melting;
            }};
        }};
        grandeur = new ContinuousTurret("grandeur"){{
            requirements(Category.turret, with(ExoItems.cobolt, 350, Items.silicon, 280, ExoItems.osmium, 200, ExoItems.neodymium, 320, ExoItems.viliotStone, 250, ExoItems.iron, 170, ExoItems.empyreanPlating, 200, ExoItems.litusiumAlloy, 150, ExoItems.vastanium, 170, ExoItems.vanstariumAlloy, 180));
            range = 660f;
            recoil = 2f;
            shake = 2f;
            shootEffect = Fx.colorSparkBig;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 5;
            warmupMaintainTime = 30f;
            minWarmup = 0.96f;
            shootWarmupSpeed = 0.04f;
            scaledHealth = 280;
            shootY = 34;
            rotateSpeed = 1;
            loopSound = ExoSounds.funnylaserloop;
            shootSound = ExoSounds.bigLaserShoot;
            loopSoundVolume = 1.1f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new FlarePart(){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            color1 = ExoPal.empyreanIndigo;
                            y = 5;
                            followRotation = true;
                            rotation = 90;
                            sides = 2;
                            radius = 0;
                            radiusTo = 70;
                            stroke = 7.5f;
                        }},
                        new FlarePart(){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            color1 = ExoPal.empyreanIndigo;
                            y = 5;
                            spinSpeed = 2;
                            sides = 4;
                            radius = 0;
                            radiusTo = 120;
                            stroke = 3.5f;
                        }},
                        new RegionPart("-back"){{
                            progress = PartProgress.warmup;
                            moveY = -4.5f;
                            moveX = 1;
                            mirror = true;
                            under = true;
                        }},
                        new RegionPart("-front2"){{
                            progress = PartProgress.warmup;
                            moveX = 4.5f;
                            moveY = 11f;
                            mirror = true;
                        }},
                        new RegionPart("-front"){{
                            progress = PartProgress.warmup;
                            moveX = 3.5f;
                            moveY = 3f;
                            moveRot = -28;
                            mirror = true;
                        }},
                        new RegionPart("-body"){{
                            progress = PartProgress.warmup;
                            moveY = -3.5f;
                            mirror = false;
                        }},
                        new RegionPart("-platefront"){{
                            progress = PartProgress.warmup;
                            moveX = 3f;
                            moveY = 3f;
                            mirror = true;
                        }},
                        new RegionPart("-plate"){{
                            progress = PartProgress.warmup;
                            moves.add(new PartMove(PartProgress.recoil, 2f, -4f, 0f));
                            moveX = 3.5f;
                            mirror = true;
                        }}
                );
            }};
            shootType = new ExoContinuousLaserBulletType(){{
                hitColor = ExoPal.empyreanIndigoDark;
                damageType = DamageType.thermal;
                damage = 125f;
                length = 670f;
                hitEffect = new MultiEffect(
                        new ParticleEffect(){{
                            line = true;
                            rotWithParent = true;
                            colorFrom = ExoPal.empyreanIndigo;
                            colorTo = ExoPal.empyreanIndigoDark;
                            cone = 35;
                            particles = 3;
                            length = 100;
                            lifetime = 21f;
                            lenFrom = 10;
                            lenTo = 7;
                            strokeFrom = 2f;
                            strokeTo = 0.8f;
                        }},
                        new ParticleEffect(){{
                            line = true;
                            rotWithParent = true;
                            colorFrom = ExoPal.empyreanIndigo;
                            colorTo = ExoPal.empyreanIndigoDark;
                            cone = 45;
                            particles = 2;
                            length = 85;
                            lifetime = 21f;
                            lenFrom = 10;
                            lenTo = 10;
                            strokeFrom = 2f;
                            strokeTo = 0.8f;
                        }});
                intervalBullet = new ChainLightningBulletType() {{
                    lightningColor = ExoPal.empyreanIndigo;
                    damageType = DamageType.energy;
                    range = 650;
                    targetRange = 350;
                    hitSound = Sounds.none;
                    damage = 120;
                    distanceDamageFalloff = 4;
                    chainLightning = 2;
                    segmentLength = 8;
                }};
                intervalRandomSpread = 50;
                intervalBullets = 2;
                bulletInterval = 5f;
                drawSize = 420f;
                backLength = 29f;
                pointyScaling = 0.5f;
                shootEffect = new Effect(20,e->{
                    Draw.z(Layer.effect);
                    Draw.color(ExoPal.empyreanIndigo,e.fout());
                    Tmp.v1.trns(e.rotation, e.fin()*20f);
                    Lines.ellipse(Tmp.v1.x + e.x, Tmp.v1.y + e.y , 0.8f*e.fin()+0.1f, 8,16, e.rotation);
                    Tmp.v2.trns(e.rotation, e.fin()*10f);
                    Lines.ellipse(Tmp.v2.x + e.x, Tmp.v2.y + e.y , 0.6f*e.fin()+0.1f,8f*0.75f, 12,  e.rotation);
                    Lines.stroke(6f*e.fout());
                });
                width = 19f;
                shake = 2f;
                largeHit = true;
                colors = new Color[]{ExoPal.empyreanIndigoDark.cpy().a(.6f), ExoPal.empyreanIndigoDark, Color.white};
                despawnEffect = Fx.none;
            }};
        }};
        aether = new PowerTurret("aether"){{
            requirements(Category.turret, with(ExoItems.rustyCopper, 420, Items.silicon, 300, ExoItems.osmium, 200, ExoItems.neodymium, 320, ExoItems.lightningStone, 250, ExoItems.vanstariumAlloy, 200, ExoItems.empyreanPlating, 300, ExoItems.litusiumAlloy, 150));
            range = 290f;
            recoil = 5f;
            reload = 300f;
            shake = 4f;
            shootEffect = Fx.shootSmokeSmite;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 5;
            minWarmup = 0.99f;
            shootY = 12;
            scaledHealth = 280;
            cooldownTime = 320;
            shootSound = ExoSounds.shockblast;
            shootCone = 35f;
            shoot = new ShootSpread(){{
                spread = 7f;
                shots = 15;
            }};
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.add(
                        new RegionPart("-plate2"){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            moveX = 4.5f;
                            recoilTime = 350;
                            mirror = true;
                        }},
                        new RegionPart("-plate"){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            moveX = 9f;
                            recoilTime = 350;
                            mirror = true;
                        }},
                        new RegionPart("-front"){{
                            progress = PartProgress.warmup;
                            under = true;
                        }},
                        new RegionPart("-back"){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            moveY = -2f;
                            under = true;
                        }}
                );
            }};
            shootType = new ExoBasicBulletType(8f, 207){{
                lifetime = 35f;
                backColor = lightColor = lightningColor = trailColor = hitColor = ExoPal.empyreanblue;
                impact = true;
                knockback = 3f;
                sprite = "circle-bullet";
                damageType = kinetic;
                hitSize = 12f;
                lightning = 2;
                lightningLengthRand = 5;
                lightningLength = 3;
                lightningDamage = damage / 10f;
                width = 155f;
                height = 7;
                shrinkX = 0.45f;
                shrinkY = -2.48f;
                shrinkInterp = Interp.reverse;
                pierce = true;
                intervalBullet = new LightningBulletType(){{
                    damage = 26;
                    lightningColor = ExoPal.empyreanblue;
                    lightningLength = 6;
                    lightningLengthRand = 12;
                    buildingDamageMultiplier = 0.25f;
                }};
                bulletInterval = 3f;
                smokeEffect = ExoFx.square45_6_45;
                hitEffect = ExoFx.square45_6_45;
                despawnEffect = new Effect(35f, 70f, e -> {
                    Draw.color(e.color, Color.white, e.fout() * 0.7f);
                    for(int i : Mathf.signs){

                        Drawf.tri(e.x, e.y, height * 1.5f * e.fout(), width * 0.885f * e.fout(), e.rotation + i * 90);
                        Drawf.tri(e.x, e.y, height * 0.8f * e.fout(), width * 0.252f * e.fout(), e.rotation + 90 + i * 90);
                    }
                });
            }};
        }};
        profane = new ItemTurret("profane"){{
            requirements(Category.turret, with(ExoItems.cobolt, 400, ExoItems.rustyCopper, 300, ExoItems.osmium, 350, ExoItems.thermoCore, 300, ExoItems.iron, 400, ExoItems.neodymium, 200, ExoItems.vanstariumAlloy, 180, ExoItems.empyreanPlating, 150, ExoItems.litusiumAlloy, 250));
            range = 1500f;
            recoil = 0f;
            reload = 1000f;
            shake = 4f;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 5;
            scaledHealth = 280;
            cooldownTime = 320;
            shootSound = Sounds.mediumCannon;

            warmupMaintainTime = 30f;
            minWarmup = 0.96f;
            shootWarmupSpeed = 0.03f;
            shootY = 16f;
            rotateSpeed = 1;
            shootCone = 20f;
            unitSort = UnitSorts.strongest;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-") {{
                parts.addAll(
                        new RegionPart("-manbible") {{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            heatColor = Color.red;
                            heatProgress = PartProgress.warmup.add(-0.2f).add(p -> Mathf.sin(9f, 0.2f) * p.warmup);
                            moveX = 6f;
                            moveY = -2;
                            moveRot = 20;
                            children.add(new RegionPart("-maniblebits"){{
                                progress = PartProgress.warmup.delay(0.6f);
                                mirror = true;
                                under = true;
                                moveX = 5f;
                            }});
                            mirror = true;
                        }},
                        new RegionPart("-plate") {{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            moveX = 4f;
                            moveY = -2;
                            moveRot = 2;
                            moves.add(new PartMove(PartProgress.recoil, 0f, -3f, 0f));
                            mirror = true;
                        }},
                        new RegionPart("-nuke"){{
                            progress = PartProgress.reload.curve(Interp.pow2In);
                            y = 4;
                            colorTo = new Color(1f, 1f, 1f, 0f);
                            color = Color.white;
                            mixColorTo = Pal.accent;
                            mixColor = new Color(1f, 1f, 1f, 0f);
                            under = true;

                            moves.add(new PartMove(PartProgress.warmup.inv(), 0f, -10f, 0f));
                        }}
                );
            }};
            ammo(
                    ExoItems.thermoCore, new BasicBulletType(0f, 1) {{
                        shootEffect = Fx.shootBig;
                        smokeEffect = Fx.shootSmokeMissile;
                        ammoMultiplier = 1f;
                        spawnUnit = new MissileUnitType("vousar-missile") {{
                            speed = 4.6f;
                            maxRange = 6f;
                            lifetime = 60f * 5.5f;
                            outlineColor = ExoPal.empyreanOutline;
                            engineColor = trailColor = ExoPal.cronusRed;
                            engineLayer = Layer.effect;
                            engineSize = 3.1f;
                            engineOffset = 16f;
                            rotateSpeed = 0.25f;
                            trailLength = 18;
                            missileAccelTime = 50f;
                            lowAltitude = true;
                            loopSound = Sounds.missileTrail;
                            loopSoundVolume = 0.6f;
                            deathSound = Sounds.largeExplosion;
                            targetAir = false;

                            fogRadius = 6f;

                            health = 210;

                            weapons.add(new Weapon() {{
                                shootCone = 360f;
                                mirror = false;
                                reload = 1f;
                                deathExplosionEffect = Fx.massiveExplosion;
                                shootOnDeath = true;
                                shake = 10f;
                                bullet = new ExplosionBulletType(2800f, 100f) {{
                                    hitColor = ExoPal.cronusRed;
                                    shootEffect = new MultiEffect(Fx.massiveExplosion, ExoFx.colorBomb, Fx.scatheExplosion, Fx.scatheLight, new WaveEffect() {{
                                        lifetime = 10f;
                                        strokeFrom = 4f;
                                        sizeTo = 130f;
                                    }});

                                    collidesAir = false;
                                    buildingDamageMultiplier = 0.3f;

                                    ammoMultiplier = 1f;
                                    fragLifeMin = 0.1f;
                                    fragBullets = 12;
                                    fragBullet = new ArtilleryBulletType(3.4f, 32) {{
                                        buildingDamageMultiplier = 0.3f;
                                        drag = 0.02f;
                                        hitEffect = Fx.massiveExplosion;
                                        despawnEffect = Fx.scatheSlash;
                                        knockback = 0.8f;
                                        lifetime = 23f;
                                        width = height = 18f;
                                        collidesTiles = false;
                                        splashDamageRadius = 40f;
                                        splashDamage = 80f;
                                        backColor = trailColor = hitColor = ExoPal.cronusRed;
                                        frontColor = Color.white;
                                        smokeEffect = Fx.shootBigSmoke2;
                                        despawnShake = 7f;
                                        lightRadius = 30f;
                                        lightColor = ExoPal.cronusRed;
                                        lightOpacity = 0.5f;

                                        trailLength = 20;
                                        trailWidth = 3.5f;
                                        trailEffect = Fx.none;
                                    }};
                                }};
                            }});
                            abilities.add(new MoveEffectAbility() {{
                                effect = Fx.missileTrailSmoke;
                                rotation = 180f;
                                y = -9f;
                                color = Color.grays(0.6f).lerp(ExoPal.cronusRedlight, 0.5f).a(0.4f);
                                interval = 7f;
                            }});
                        }};
                    }});
        }};
        agios = new PowerTurret("agios"){{
            requirements(Category.turret, with(ExoItems.cobolt, 400, Items.silicon, 300, ExoItems.gold, 150, ExoItems.luxiteStone, 300, ExoItems.lightningStone, 300, ExoItems.iron, 400, ExoItems.osmium, 200, ExoItems.vanstariumAlloy, 180, ExoItems.empyreanPlating, 250, ExoItems.litusiumAlloy, 150));
            range = 290f;
            recoil = 0f;
            reload = 230f;
            shake = 4f;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 5;
            scaledHealth = 280;
            cooldownTime = 320;
            shootSound = Sounds.bolt;

            warmupMaintainTime = 30f;
            minWarmup = 0.96f;
            shootWarmupSpeed = 0.03f;
            shootY = 16f;
            rotateSpeed = 2;
            shootCone = 50f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            color = ExoPal.empyrean;
                            y = shootY;
                            layer = Layer.effect;
                            circle = true;
                            radius = 2;
                            radiusTo = 7;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            color = Color.white;
                            y = shootY;
                            layer = Layer.effect;
                            circle = true;
                            radius = 0.5f;
                            radiusTo = 5f;
                        }},
                        new FlarePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            color1 = ExoPal.empyrean;
                            y = shootY;
                            sides = 2;
                            radius = 0;
                            radiusTo = 70;
                            stroke = 2.5f;
                        }},
                        new RegionPart("-blade"){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            moveX = 8f;
                            moveY = -2;
                            moveRot = 35;
                            mirror = true;
                        }},
                        new RegionPart("-blade"){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            moveX = 11f;
                            moveY = -2;
                            moveRot = 65;
                            mirror = true;
                        }},
                        new RegionPart("-blade"){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            moveX = 11f;
                            moveY = -2;
                            moveRot = 34;
                            mirror = true;
                        }},
                        new RegionPart("-plate"){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            heatColor = Color.red;
                            heatProgress = PartProgress.warmup;
                            moveX = 2f;
                            moveY = 3;
                            moveRot = 20;
                            mirror = true;
                        }},
                        new RegionPart("-bottom"){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            moveX = 4f;
                            under = true;
                            mirror = true;
                        }}
                );
            }};
            shootType = new DestructionBulletType(1f, 460){{
                size /= 2.2f;
                trailWidth = 9.5f;
                trailLength = 57;
                spreadEffect = slopeEffect = Fx.none;
                backColor = trailColor = hitColor = lightColor = lightningColor = ExoPal.empyrean;
                frontColor = Color.white;
                scaleLife = false;
                randomLightningChance = 1f;
                randomGenerateRange = linkRange = 200f;
                randomLightningNum = 5;
                maxHit = 6;
                range = 200f;
                drawSize = 20f;
                hitSound = Sounds.explosionbig;
                splashDamageRadius = 100f;
                splashDamage = 700;
                lightningDamage = 11f;
                intervalBullets = 1;
                bulletInterval = 2;
                trailEffect = new Effect(30f, e -> {
                    color(ExoPal.empyrean);
                    for(int s : Mathf.signs){
                        Drawf.tri(e.x, e.y, 5.5f, 44f * e.fslope(), e.rotation + 90f * s);
                    }
                });
                homingRange = 80;
                homingPower = 0.01f;
                damageType = DamageType.energy;
                trailRotation = true;
                trailInterval = 7f;
                intervalBullet = new LightningBulletType(){{
                    damage = 25;
                    ammoMultiplier = 1f;
                    lightningColor = ExoPal.empyrean;
                    lightningLength = 5;
                    lightningLengthRand = 10;
                }};
                pierce = false;
                collides = false;
                lifetime = 650;
                despawnEffect = hitEffect = ExoFx.empyreanExplosion;
                shootEffect = ExoFx.square45_6_45;
                hitSpacing = 3;
                fragVelocityMin = 0.4f;
                fragLifeMin = 0f;
                fragBullets = 15;
                fragBullet = new ExoBasicBulletType(4f, 100){{
                    width = height = 1f;
                    parts.addAll(
                            new FlarePart(){{
                                progress = PartProgress.reload;
                                color1 = ExoPal.empyrean;
                                y = 6;
                                radius = 22;
                                radiusTo = 0;
                                stroke = 3.5f;
                            }}
                    );
                    damageType = DamageType.energy;
                    backColor = trailColor = lightColor = lightningColor = hitColor = ExoPal.empyrean;
                    frontColor = Color.white;
                    trailEffect = Fx.missileTrail;
                    trailParam = 3.5f;
                    splashDamage = 80;
                    splashDamageRadius = 40;
                    lifetime = 58f;
                    lightning = 2;
                    lightningLength = lightningLengthRand = 4;
                    lightningDamage = 20;
                    hitSoundVolume /= 2.2f;
                    despawnShake = hitShake = 4f;
                    despawnSound = hitSound = Sounds.dullExplosion;
                    trailWidth = 3f;
                    trailLength = 7;
                    trailInterp = Interp.slope;
                    despawnEffect = ExoFx.colorBombSmall;
                    hitEffect = ExoFx.hitSparkHuge;
                }};
                fragVelocityMax = 1f;
                fragVelocityMin = 0.35f;
            }};
        }};
        //tier 4
        arbiter = new PowerTurret("arbiter"){{
            requirements(Category.turret, with(Items.silicon, 80, Items.beryllium, 50, ExoItems.magnetite, 85));
            range = 210f;
            recoil = 0;
            reload = 25;
            outlineColor = ExoPal.empyreanOutline;
            size = 8;
            scaledHealth = 280;
            heatColor = Color.red;
            recoils = 2;
            shootSound = Sounds.shootSmite;
            shootCone = 20f;
            shootY = 27;
            shoot = new ShootAlternate(){{
                barrels = 2;
                spread = 18;
            }};
            rotateSpeed = 1f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                for(int i = 0; i < 2; i++){
                    int f = i;
                    parts.addAll(
                            new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
                                progress = PartProgress.recoil;
                                recoilIndex = f;
                                moveY = -6.5f;
                            }},
                            new RegionPart("-barrel-body"){{
                                progress = PartProgress.recoil;
                                under = true;
                                mirror = true;
                            }},
                            new RegionPart("-barrel-plate-" + (i == 0 ? "l" : "r")){{
                                progress = PartProgress.recoil;
                                recoilIndex = f;
                                moveY = -8.5f;
                            }}
                    );
                }
            }};
            shootType = new ExoBasicBulletType(9, 270){{
                lifetime = 30f;
                damageType = kinetic;
                width = 9;
                height = 15;
                sprite = "missile-large";
                pierceArmor = true;
                shootEffect = Fx.shootBigColor;
                smokeEffect = new Effect(20,e->{
                    Draw.z(Layer.effect);
                    Draw.color(ExoPal.empyreanblue,e.fout());
                    Tmp.v1.trns(e.rotation, e.fin()*20f);
                    Lines.ellipse(Tmp.v1.x + e.x, Tmp.v1.y + e.y , 0.8f*e.fin()+0.1f, 8,16, e.rotation);
                    Tmp.v2.trns(e.rotation, e.fin()*10f);
                    Lines.ellipse(Tmp.v2.x + e.x, Tmp.v2.y + e.y , 0.6f*e.fin()+0.1f,8f*0.75f, 12,  e.rotation);
                    Lines.stroke(6f*e.fout());
                });
                backColor = hitColor = trailColor = ExoPal.empyreanblue;
                frontColor = Color.white;
                trailWidth = 2.5f;
                trailLength = 10;
                hitEffect = despawnEffect = ExoFx.colorBomb;
            }};
        }};

        //genesis align
        //turrets Genesis Align
        //tier 1
        starFleet = new PowerTurret("starfleet"){{
            requirements(Category.turret, with(ExoItems.nickel, 35, ExoItems.curtuses, 100));
            squareSprite = false;
            range = 82f;
            reload = 35f;
            shootEffect = Fx.colorSpark;
            smokeEffect = Fx.none;
            outlineColor = Pal.darkOutline;
            shootY = 8;
            size = 1;
            xRand = 7;
            scaledHealth = 240;
            shootSound = Sounds.laser;
            shoot = new ShootPattern(){{
                shots = 4;
                shotDelay = 3;
            }};
            rotateSpeed = 2.5f;
            coolant = consumeCoolant(0.2f);
            consumePower(1f);
            drawer = new DrawTurret("genesux-");
            shootType = new ExoBasicBulletType(5, 5){{
                backColor = hitColor = trailColor = ExoPal.genesis;
                parts.addAll(
                        new FlarePart(){{
                            progress = PartProgress.life;
                            color1 = ExoPal.genesis;
                            spinSpeed = 3;
                            radius = 6;
                            radiusTo = 6;
                            stroke = 2f;
                        }}
                );
                weaveMag = 2.2f;
                weaveScale = 7;
                trailWidth = 1.5f;
                trailLength = 8;
                homingPower = 0.0789f;
                homingRange = 150;
                width = height = 0f;
                shrinkX = shootY = 0;
                damageType = energy;
                lifetime = 20;
                hitEffect = despawnEffect = Fx.colorSpark;
            }};
        }};
        astral = new ItemTurret("astral"){{
            requirements(Category.turret, with(ExoItems.astrolite, 50, ExoItems.nickel, 80));
            squareSprite = false;
            range = 60f;
            recoil = 0.7f;
            reload = 35;
            shootEffect = Fx.colorSparkBig;
            smokeEffect = Fx.none;
            outlineColor = Pal.darkOutline;
            size = 1;
            scaledHealth = 240;
            maxAmmo = 15;
            shootSound = Sounds.bang;
            rotateSpeed = 2.5f;
            coolant = consumeCoolant(0.2f);
            drawer = new DrawTurret("genesux-");
            ammo(
                    ExoItems.curtuses, new ExoBasicBulletType(6f, 10) {{
                        backColor = hitColor = trailColor = ExoPal.letoColor;
                        frontColor = Color.white;
                        trailWidth = 2f;
                        trailLength = 6;
                        width = height = 9;
                        shrinkX = shrinkY = 0;
                        damageType = cryogenic;
                        lifetime = 11;
                        hitEffect = despawnEffect = ExoFx.desCreepHit;
                      //  hitEffect = despawnEffect = Fx.flakExplosion;
                    }},
                    ExoItems.astrolite, new ExoBasicBulletType(4f, 14) {{
                        backColor = hitColor = trailColor = ExoPal.genesis;
                        frontColor = Color.white;
                        trailWidth = 2f;
                        trailLength = 6;
                        width = height = 9;
                        shrinkX = shrinkY = 0;
                        damageType = energy;
                        lifetime = 11;
                        hitEffect = despawnEffect = ExoFx.desGroundHit;
                     //   hitEffect = despawnEffect = ExoFx.colorBombSmaller;
                    }},
                    ExoItems.stellarIron, new ExoBasicBulletType(4f, 14) {{
                        backColor = hitColor = trailColor = ExoPal.genesis;
                        frontColor = Color.white;
                        trailWidth = 2f;
                        trailLength = 6;
                        width = height = 9;
                        shrinkX = shrinkY = 0;
                        damageType = energy;
                        lifetime = 11;
                        hitEffect = despawnEffect = ExoFx.desCreepHeavyHit;
                        //   hitEffect = despawnEffect = ExoFx.colorBombSmaller;
                    }},
                    ExoItems.nickel, new ExoBasicBulletType(8f, 6) {{
                        backColor = hitColor = trailColor = Color.valueOf("8bc99e");
                        rangeChange = 20;
                        frontColor = Color.white;
                        reloadMultiplier = 4;
                        trailWidth = 2f;
                        trailLength = 6;
                        width = height = 9;
                        shrinkX = shrinkY = 0;
                        damageType = kinetic;
                        lifetime = 11;
                        hitEffect = despawnEffect = ExoFx.desGroundHitMain;
                      //  hitEffect = despawnEffect = ExoFx.blastExplosionColor;
                    }}
            );
        }};
        cosmos = new ItemTurret("cosmos"){{
            requirements(Category.turret, with(ExoItems.nickel, 120, ExoItems.curtuses, 80, Items.silicon, 50));
            range = 160f;
            recoil = 2f;
            reload = 135;
            smokeEffect = Fx.none;
            outlineColor = Pal.darkOutline;
            size = 2;
            scaledHealth = 240;
            shootSound = Sounds.shootBig;
            shootCone = 30f;
            rotateSpeed = 1.5f;
            coolant = consumeCoolant(0.2f);
            drawer = new DrawTurret("genesux-"){{
                new RegionPart("-back"){{
                    progress = PartProgress.recoil.curve(Interp.pow2In);
                    moveY = -2;
                    mirror = false;
                }};
            }};
            ammo(
                    ExoItems.curtuses, new ExoArtilleryBulletType(){{
                        speed = 5f;
                        ammoPerShot = 5;
                        damageType = explosive;
                        trailWidth = 3f;
                        trailLength = 6;
                        shrinkX = shrinkY = 0;
                        splashDamage = 42;
                        splashDamageRadius = 55;
                        lifetime = 38;
                        width = 15;
                        height = 20;
                        backColor = hitColor = lightColor = trailColor = ExoPal.letoColor;
                        hitEffect = despawnEffect = new MultiEffect(ExoFx.coloredHitLarge);
                        smokeEffect = Fx.colorSpark;
                    }},
                    ExoItems.astrolite, new ExoArtilleryBulletType(){{
                        speed = 5f;
                        ammoPerShot = 5;
                        damageType = explosive;
                        trailWidth = 3f;
                        trailLength = 6;
                        shrinkX = shrinkY = 0;
                        splashDamage = 25;
                        splashDamageRadius = 55;
                        lifetime = 38;
                        width = 15;
                        height = 20;
                        backColor = hitColor = lightColor = trailColor = ExoPal.genesis;
                        hitEffect = despawnEffect = new MultiEffect(ExoFx.coloredHitLarge);
                        smokeEffect = Fx.colorSpark;
                        fragRandomSpread = 360f;
                        fragBullets = 5;
                        fragVelocityMin = 1f;

                        fragBullet = new ExoBasicBulletType(5, 9){{
                            width = 7f;
                            damageType = cryogenic;
                            height = 7f;
                            lifetime = 8f;
                            backColor = hitColor = trailColor = ExoPal.genesis;
                            frontColor = Color.white;
                            trailWidth = 1.3f;
                            trailLength = 6;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                        }};
                    }}
            );
        }};
        armada = new PowerTurret("armada"){{
            requirements(Category.turret, with(ExoItems.nickel, 100, ExoItems.curtuses, 100, Items.graphite, 150));
            squareSprite = false;
            range = 140f;
            reload = 35f;
            shootEffect = ExoFx.colorSparkShoot;
            smokeEffect = Fx.none;
            outlineColor = Pal.darkOutline;
            shootY = 0;
            size = 2;
            xRand = 7;
            scaledHealth = 240;
            shootSound = Sounds.bolt;
            shoot = new ShootMulti(new ShootSummon(0f, 0f, 12, 20f),
                    new ShootPattern(){{
                        shots = 2;
                        shotDelay = 3;
                    }}
            );
            rotateSpeed = 1.5f;
            coolant = consumeCoolant(0.2f);
            consumePower(1f);
            drawer = new DrawTurret("genesux-");
            shootType = new ExoBasicBulletType(5, 10){{
                backColor = hitColor = trailColor = ExoPal.genesisDark;
                parts.addAll(
                        new FlarePart(){{
                            progress = PartProgress.life;
                            color1 = ExoPal.genesisDark;
                            spinSpeed = 3;
                            radius = 11;
                            radiusTo = 11;
                            stroke = 2.2f;
                        }}
                );
                weaveMag = 2.6f;
                weaveScale = 7;
                trailWidth = 1.5f;
                trailLength = 8;
                homingPower = 0.0789f;
                homingRange = 150;
                width = height = 0f;
                shrinkX = shootY = 0;
                damageType = energy;
                lifetime = 35;
                hitEffect = despawnEffect = ExoFx.coloredHitLarge;
            }};
        }};
        sagittarius = new PowerTurret("sagittarius"){{
            requirements(Category.turret, with(ExoItems.nickel, 400, ExoItems.selfHealingAlloy, 250, ExoItems.curtuses, 800, ExoItems.stellarIron, 600, Items.silicon, 500));
            squareSprite = false;
            targetAir = true;
            targetGround = false;
            range = 280f;
            recoil = 2f;
            reload = 10;
            outlineColor = Pal.darkOutline;
            size = 4;
            shootY = 4;
            minWarmup = 0.85f;
            shootWarmupSpeed = 0.05f;
            scaledHealth = 240;
            shootSound = Sounds.bolt;
            shoot = new ShootAlternate(){{
                shots = 3;
                barrels = 3;
                spread = 9;
            }};
            rotateSpeed = 2.5f;
            coolant = consumeCoolant(0.2f);
            consumePower(12f);
            drawer = new DrawTurret("genesux-"){{
                parts.addAll(
                        new RegionPart("-top"){{
                            mirror = false;
                            outlineLayerOffset = -0.004f;
                            layerOffset = 0.004f;
                        }},
                        new RegionPart("-side"){{
                            progress = PartProgress.warmup;
                            under = true;
                            moveX = 4f;
                            moveY = -2;
                            moveRot = -12;
                            outlineLayerOffset = -0.001f;
                            layerOffset = 0.001f;
                            mirror = true;
                            children.add(new RegionPart("-bottom"){{
                                mirror = true;
                                under = true;
                            }});
                        }},
                        new RegionPart("-body"){{
                            progress = PartProgress.warmup;
                            moveX = 1.5f;
                            moveRot = -8;
                            mirror = true;
                        }}
                );
            }};
            shootType = new ExoBasicBulletType(6, 32){{
                sprite = "exogenesis-energy-projectile";
                homingRange = 100;
                homingPower = 0.075f;
                shrinkX = shrinkY = 0;
                lifetime = 50;
                width = 8;
                height = 15;
                damageType = DamageType.energy;
                pierce = true;
                hitColor = trailColor = ExoPal.genesisDark;
                trailWidth = 1.5f;
                trailLength = 8;
                shootEffect = ExoFx.square45_6_45;
                hitEffect = despawnEffect = ExoFx.hitMeltColor;
                smokeEffect = Fx.colorSpark;
            }};
        }};
        stellar = new ContinuousLiquidTurret("stellar"){{
            requirements(Category.turret, with(ExoItems.selfHealingAlloy, 200,  Items.silicon, 300, ExoItems.curtuses, 500, ExoItems.nickel, 400));
            drawer = new DrawTurret("genesux-");
            squareSprite = false;
            scaledHealth = 240;
            shootY = 0f;
            size = 3;
            outlineColor = Pal.darkOutline;

            liquidConsumed = 10f / 60f;
            targetInterval = 5f;
            targetUnderBlocks = false;

            float r = range = 130f;

            loopSound = Sounds.torch;
            shootSound = Sounds.none;
            loopSoundVolume = 1f;
            ammo(
                    ExoLiquids.coldPlasma, new ContinuousFlameBulletType(){{
                        damage = 60f;
                        length = r;
                        knockback = 1f;
                        pierceCap = 3;
                        buildingDamageMultiplier = 0.3f;
                        flareColor = ExoPal.genesis;
                        colors = new Color[]{Color.valueOf("6666ff").a(0.55f), ExoPal.genesisDark.a(0.7f), ExoPal.genesis.a(0.8f), ExoPal.genesisLight, Color.white};
                    }}
            );
        }};
        astrology = new PowerTurret("astrology"){{
            requirements(Category.turret, with(ExoItems.astrolite, 430, ExoItems.selfHealingAlloy, 300, Items.silicon, 350, ExoItems.stellarIron, 400));
            range = 200f;
            recoil = 0f;
            reload = 80f;
            squareSprite = false;
            shootEffect = Fx.colorSparkBig;
            outlineColor = Pal.darkOutline;
            size = 3;
            shootY = 0;
            inaccuracy = 100;
            shootCone = 100;
            rotateSpeed = 1.5f;
            scaledHealth = 240;
            shootSound = Sounds.laser;
            shoot = new ShootPattern(){{
                shots = 4;
                shotDelay = 3;
            }};
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            shootType = new ExoBasicBulletType(5, 20){{
                backColor = hitColor = trailColor = ExoPal.genesis;
                parts.addAll(
                        new FlarePart(){{
                            progress = PartProgress.life;
                            color1 = ExoPal.genesis;
                            spinSpeed = 3;
                            radius = 16;
                            radiusTo = 16;
                            stroke = 2.8f;
                        }}
                );
                drag = 0.07f;
                weaveMag = 5f;
                weaveScale = 6;
                trailWidth = 1.5f;
                trailLength = 8;
                width = height = 0f;
                damageType = energy;
                lifetime = 65;
                hitEffect = despawnEffect = ExoFx.colorBombSmall;
                fragBullets = 1;
                fragBullet = new ExoBasicBulletType(6, 55){{
                    backColor = hitColor = trailColor = ExoPal.genesis;
                    parts.addAll(
                            new FlarePart(){{
                                progress = PartProgress.life;
                                color1 = ExoPal.genesis;
                                spinSpeed = 6;
                                radius = 19;
                                radiusTo = 19;
                                stroke = 2.8f;
                            }}
                    );
                    weaveMag = 2.6f;
                    weaveScale = 7;
                    trailWidth = 2f;
                    trailLength = 8;
                    splashDamage = 15;
                    splashDamageRadius = 30;
                    homingPower = 0.0589f;
                    homingRange = 170;
                    width = height = 0f;
                    shrinkX = shootY = 0;
                    damageType = energy;
                    lifetime = 70;
                    hitEffect = despawnEffect = ExoFx.colorBombSmall;
                }};
            }};
        }};
        coldPlasmaThrower = new LiquidTurret("cold-plasmathrower"){{
            requirements(Category.turret, with(ExoItems.selfHealingAlloy, 600, ExoItems.nickel, 1000, ExoItems.stellarIron, 700, ExoItems.axionEnergyCell, 700, ExoItems.urbium, 300, ExoItems.axinvaxaAlloy, 400));
            range = 130f;
            recoil = 0;
            reload = 6f;
            squareSprite = false;
            targetAir = false;
            inaccuracy = 5f;
            heatColor = ExoPal.genesis;
            outlineColor = Pal.darkOutline;
            shootEffect = new MultiEffect(
                    new ParticleEffect(){{
                        particles = 2;
                        length = 140;
                        lifetime = 30;
                        interp = Interp.circleOut;
                        sizeInterp = Interp.pow5In;
                        sizeFrom = 5;
                        sizeTo = 1;
                        lightColor = ExoPal.genesis;
                        colorFrom = ExoPal.genesisLight;
                        colorTo = ExoPal.genesis;
                        cone = 10;
                    }},
                    new ParticleEffect(){{
                        particles = 2;
                        length = 100;
                        lifetime = 35;
                        interp = Interp.circleOut;
                        sizeInterp = Interp.pow5In;
                        sizeFrom = 6;
                        sizeTo = 1;
                        lightColor = ExoPal.genesis;
                        colorFrom = ExoPal.genesisLight;
                        colorTo = ExoPal.genesis;
                        cone = 15;
                    }},
                    new ParticleEffect(){{
                        particles = 2;
                        length = 110;
                        lifetime = 40;
                        interp = Interp.fastSlow;
                        sizeFrom = 6;
                        sizeTo = 1.5f;
                        lightColor = ExoPal.genesis;
                        colorFrom = ExoPal.genesis;
                        colorTo = ExoPal.genesisDark;
                        cone = 15;
                    }},
                    new ParticleEffect(){{
                        particles = 2;
                        length = 120;
                        lifetime = 50;
                        interp = Interp.fastSlow;
                        sizeFrom = 6;
                        sizeTo = 1.5f;
                        lightColor = ExoPal.genesis;
                        colorFrom = ExoPal.genesis;
                        colorTo = ExoPal.genesisDark;
                        cone = 10;
                    }});
            smokeEffect = new MultiEffect(
                    new ParticleEffect(){{
                        particles = 3;
                        length = 160;
                        lifetime = 50;
                        interp = Interp.fastSlow;
                        sizeFrom = 5;
                        sizeTo = 1;
                        lightColor = ExoPal.genesisDark;
                        colorFrom = ExoPal.genesisDark;
                        colorTo = ExoPal.genesisDarkAlpha;
                        cone = 15;
                    }},
                    new ParticleEffect(){{
                        particles = 3;
                        length = 180;
                        lifetime = 60;
                        interp = Interp.fastSlow;
                        sizeFrom = 7;
                        sizeTo = 1;
                        lightColor = ExoPal.genesisDark;
                        colorFrom = ExoPal.genesisDark;
                        colorTo = ExoPal.genesisDarkAlpha;
                        cone = 10;
                    }});
            size = 4;
            scaledHealth = 240;
            shootY = 3;
            shootSound = Sounds.flame;
            coolant = consumeCoolant(0.2f);
            shoot = new ShootPattern(){{
                shots = 4;
                shotDelay = 1;
            }};
            drawer = new DrawTurret("genesux-");
            ammo(
                    ExoLiquids.coldPlasma, new ExoBasicBulletType(5, 35){{
                        lightColor = hitColor = ExoPal.genesisDark;
                        damageType = cryogenic;
                        statusDuration = 60;
                        status = StatusEffects.freezing;
                        height = width = 0;
                        hitSize = 9;
                        hittable = reflectable = false;
                        pierce = pierceBuilding = true;
                        pierceCap = 4;
                        lifetime = 27;
                        despawnEffect = Fx.none;
                        hitEffect = ExoFx.hitMeltColor;
                    }}
            );
        }};
        nebula = new ItemTurret("nebula"){{
            requirements(Category.turret, with(ExoItems.nickel, 800, ExoItems.selfHealingAlloy, 550, ExoItems.stellarIron, 450, ExoItems.curtuses, 350, Items.graphite, 550));
            range = 105f;
            recoil = 3f;
            reload = 70f;
            shake = 2f;
            squareSprite = false;
            outlineColor = Pal.darkOutline;
            shootEffect = Fx.shootBigColor;
            smokeEffect = Fx.shootSmokeSquareSparse;
            size = 4;
            scaledHealth = 240;
            velocityRnd = 0.25f;
            shootCone = 90;
            shootSound = Sounds.shotgun;
            ammoPerShot = 4;
            maxAmmo = 40;
            consumeAmmoOnce = true;
            shoot = new ShootSpread(18, 7f);
            coolant = consumeCoolant(0.4f);

            drawer = new DrawTurret("genesux-"){{
                parts.addAll(
                        new RegionPart("-side"){{
                            moveY = -2;
                            moveX = 1.5f;
                            moveRot =- 16;
                            progress = PartProgress.recoil;
                            mirror = true;
                        }}
                );
            }};
            ammo(
                    ExoItems.axinvaxaAlloy, new ExoBasicBulletType(9f, 120){{
                        knockback = 4f;
                        width = 25f;
                        hitSize = 7f;
                        height = 20f;
                        damageType = kinetic;
                        ammoMultiplier = 1;
                        hitColor = backColor = trailColor = ExoPal.genesisDark;
                        frontColor = Color.white;
                        lifetime = 10;
                        trailWidth = 6f;
                        trailLength = 3;
                        hitEffect = despawnEffect = new MultiEffect( Fx.colorSpark,
                                new ExplosionEffect(){{
                                    smokes = 4;
                                    smokeSize = 4.7f;
                                    lifetime = 35;
                                    smokeSizeBase = 1.6f;
                                    smokeRad = 36;
                                    waveLife = 10;
                                    waveStroke = 4.1f;
                                    waveRad = 25;
                                    waveRadBase = 2.0f;
                                    sparkLen = 7;
                                    sparks = 12;
                                    lightColor = ExoPal.genesis;
                                    waveColor = sparkColor = ExoPal.genesis;
                                }});
                    }},
                    ExoItems.nickel, new ExoBasicBulletType(9f, 40){{
                        knockback = 6f;
                        width = 25f;
                        hitSize = 7f;
                        height = 20f;
                        damageType = kinetic;
                        ammoMultiplier = 1;
                        hitColor = backColor = trailColor = Color.valueOf("8bc99e");
                        frontColor = Color.white;
                        lifetime = 10;
                        trailWidth = 6f;
                        trailLength = 3;
                        hitEffect = despawnEffect = shootEffect = new MultiEffect( Fx.colorSpark,
                                new ExplosionEffect(){{
                                    smokes = 4;
                                    smokeSize = 4.7f;
                                    lifetime = 35;
                                    smokeSizeBase = 1.6f;
                                    smokeRad = 36;
                                    waveLife = 10;
                                    waveStroke = 4.1f;
                                    waveRad = 25;
                                    waveRadBase = 2.0f;
                                    sparkLen = 7;
                                    sparks = 12;
                                    lightColor = Color.valueOf("8bc99e");
                                    waveColor = sparkColor = Color.valueOf("8bc99e");

                                }});
                    }}
            );
        }};
        thuban = new ItemTurret("thuban"){{
            requirements(Category.turret, with(ExoItems.nickel, 800, ExoItems.selfHealingAlloy, 550, ExoItems.stellarIron, 450, ExoItems.curtuses, 350, Items.graphite, 550));
            range = 105f;
            recoil = 3f;
            reload = 70f;
            shake = 2f;
            squareSprite = false;
            outlineColor = Pal.darkOutline;
            shootEffect = Fx.shootBigColor;
            smokeEffect = Fx.shootSmokeSquareSparse;
            size = 4;
            scaledHealth = 240;
            velocityRnd = 0.25f;
            shootCone = 90;
            shootSound = Sounds.shotgun;
            ammoPerShot = 4;
            maxAmmo = 40;
            consumeAmmoOnce = true;
            shoot = new ShootSpread(18, 7f);
            coolant = consumeCoolant(0.4f);

            drawer = new DrawTurret("genesux-"){{
                parts.addAll(
                        new RegionPart("-side"){{
                            moveY = -2;
                            moveX = 1.5f;
                            moveRot =- 16;
                            progress = PartProgress.recoil;
                            mirror = true;
                        }}
                );
            }};
            ammo(
                    ExoItems.axinvaxaAlloy, new ExoBasicBulletType(9f, 120){{
                        knockback = 4f;
                        width = 25f;
                        hitSize = 7f;
                        height = 20f;
                        damageType = kinetic;
                        ammoMultiplier = 1;
                        hitColor = backColor = trailColor = ExoPal.genesisDark;
                        frontColor = Color.white;
                        lifetime = 10;
                        trailWidth = 6f;
                        trailLength = 3;
                        hitEffect = despawnEffect = new MultiEffect( Fx.colorSpark,
                                new ExplosionEffect(){{
                                    smokes = 4;
                                    smokeSize = 4.7f;
                                    lifetime = 35;
                                    smokeSizeBase = 1.6f;
                                    smokeRad = 36;
                                    waveLife = 10;
                                    waveStroke = 4.1f;
                                    waveRad = 25;
                                    waveRadBase = 2.0f;
                                    sparkLen = 7;
                                    sparks = 12;
                                    lightColor = ExoPal.genesis;
                                    waveColor = sparkColor = ExoPal.genesis;
                                }});
                    }},
                    ExoItems.nickel, new ExoBasicBulletType(9f, 40){{
                        knockback = 6f;
                        width = 25f;
                        hitSize = 7f;
                        height = 20f;
                        damageType = kinetic;
                        ammoMultiplier = 1;
                        hitColor = backColor = trailColor = Color.valueOf("8bc99e");
                        frontColor = Color.white;
                        lifetime = 10;
                        trailWidth = 6f;
                        trailLength = 3;
                        hitEffect = despawnEffect = shootEffect = new MultiEffect( Fx.colorSpark,
                                new ExplosionEffect(){{
                                    smokes = 4;
                                    smokeSize = 4.7f;
                                    lifetime = 35;
                                    smokeSizeBase = 1.6f;
                                    smokeRad = 36;
                                    waveLife = 10;
                                    waveStroke = 4.1f;
                                    waveRad = 25;
                                    waveRadBase = 2.0f;
                                    sparkLen = 7;
                                    sparks = 12;
                                    lightColor = Color.valueOf("8bc99e");
                                    waveColor = sparkColor = Color.valueOf("8bc99e");

                                }});
                    }}
            );
        }};
        halley = new ContinuousTurret("halley"){{
            requirements(Category.turret, with(ExoItems.oltuxium, 15, ExoItems.cobolt, 20, ExoItems.quartz, 20));
            range = 100f;
            recoil = 0f;
            squareSprite = false;
            shootEffect = ExoFx.colorBombSmaller;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            shootY = 4;
            size = 4;
            scaledHealth = 280;
            shootSound = Sounds.none;
            loopSoundVolume = 1f;
            loopSound = Sounds.laserbeam;

            shootWarmupSpeed = 0.08f;
            shootCone = 360f;

            rotateSpeed = 2.5f;
            coolant = consumeCoolant(0.2f);

            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
                        new RegionPart("-front"){{
                            progress = PartProgress.warmup;
                            moveRot = -12;
                            moveX = 4;
                            mirror = true;
                        }}
                );
            }};
            shootType = new ExoPointLaserBulletType(){{
                hitColor = trailColor = ExoPal.empyreanIndigo;
                color = Color.white;
                damageType = DamageType.energy;
                sprite = "exogenesis-focal-point-laser";
                beamEffect = Fx.none;
                trailLength = 8;
                damage = 10;
                hitEffect = ExoFx.hitMeltColor;
                smokeEffect = Fx.colorSparkBig;
            }};
        }};
        magnetar = new ContinuousTurret("magnetar"){{
            requirements(Category.turret, with(ExoItems.cobolt, 350, Items.silicon, 280, ExoItems.osmium, 200, ExoItems.neodymium, 320, ExoItems.viliotStone, 250, ExoItems.iron, 170, ExoItems.empyreanPlating, 200, ExoItems.litusiumAlloy, 150, ExoItems.vastanium, 170, ExoItems.vanstariumAlloy, 180));
            range = 660f;
            recoil = 2f;
            shake = 2f;
            shootEffect = Fx.colorSparkBig;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 5;
            warmupMaintainTime = 30f;
            minWarmup = 0.96f;
            shootWarmupSpeed = 0.04f;
            scaledHealth = 280;
            shootY = 34;
            rotateSpeed = 1;
            loopSound = ExoSounds.funnylaserloop;
            shootSound = ExoSounds.bigLaserShoot;
            loopSoundVolume = 1.1f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("genesux-"){{
                parts.addAll(
                        new FlarePart(){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            color1 = ExoPal.empyreanIndigo;
                            y = 5;
                            followRotation = true;
                            rotation = 90;
                            sides = 2;
                            radius = 0;
                            radiusTo = 70;
                            stroke = 7.5f;
                        }},
                        new FlarePart(){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            color1 = ExoPal.empyreanIndigo;
                            y = 5;
                            spinSpeed = 2;
                            sides = 4;
                            radius = 0;
                            radiusTo = 120;
                            stroke = 3.5f;
                        }},
                        new RegionPart("-back"){{
                            progress = PartProgress.warmup;
                            moveY = -4.5f;
                            moveX = 1;
                            mirror = true;
                            under = true;
                        }},
                        new RegionPart("-front2"){{
                            progress = PartProgress.warmup;
                            moveX = 4.5f;
                            moveY = 11f;
                            mirror = true;
                        }},
                        new RegionPart("-front"){{
                            progress = PartProgress.warmup;
                            moveX = 3.5f;
                            moveY = 3f;
                            moveRot = -28;
                            mirror = true;
                        }},
                        new RegionPart("-body"){{
                            progress = PartProgress.warmup;
                            moveY = -3.5f;
                            mirror = false;
                        }},
                        new RegionPart("-platefront"){{
                            progress = PartProgress.warmup;
                            moveX = 3f;
                            moveY = 3f;
                            mirror = true;
                        }},
                        new RegionPart("-plate"){{
                            progress = PartProgress.warmup;
                            moves.add(new PartMove(PartProgress.recoil, 2f, -4f, 0f));
                            moveX = 3.5f;
                            mirror = true;
                        }}
                );
            }};
            shootType = new ExoContinuousLaserBulletType(){{
                hitColor = ExoPal.empyreanIndigoDark;
                damageType = DamageType.thermal;
                damage = 125f;
                length = 670f;
                hitEffect = new MultiEffect(
                        new ParticleEffect(){{
                            line = true;
                            rotWithParent = true;
                            colorFrom = ExoPal.empyreanIndigo;
                            colorTo = ExoPal.empyreanIndigoDark;
                            cone = 35;
                            particles = 3;
                            length = 100;
                            lifetime = 21f;
                            lenFrom = 10;
                            lenTo = 7;
                            strokeFrom = 2f;
                            strokeTo = 0.8f;
                        }},
                        new ParticleEffect(){{
                            line = true;
                            rotWithParent = true;
                            colorFrom = ExoPal.empyreanIndigo;
                            colorTo = ExoPal.empyreanIndigoDark;
                            cone = 45;
                            particles = 2;
                            length = 85;
                            lifetime = 21f;
                            lenFrom = 10;
                            lenTo = 10;
                            strokeFrom = 2f;
                            strokeTo = 0.8f;
                        }});
                intervalBullet = new ChainLightningBulletType() {{
                    lightningColor = ExoPal.empyreanIndigo;
                    damageType = DamageType.energy;
                    range = 650;
                    targetRange = 350;
                    hitSound = Sounds.none;
                    damage = 120;
                    distanceDamageFalloff = 4;
                    chainLightning = 2;
                    segmentLength = 8;
                }};
                intervalRandomSpread = 50;
                intervalBullets = 2;
                bulletInterval = 5f;
                drawSize = 420f;
                backLength = 29f;
                pointyScaling = 0.5f;
                shootEffect = new Effect(20,e->{
                    Draw.z(Layer.effect);
                    Draw.color(ExoPal.empyreanIndigo,e.fout());
                    Tmp.v1.trns(e.rotation, e.fin()*20f);
                    Lines.ellipse(Tmp.v1.x + e.x, Tmp.v1.y + e.y , 0.8f*e.fin()+0.1f, 8,16, e.rotation);
                    Tmp.v2.trns(e.rotation, e.fin()*10f);
                    Lines.ellipse(Tmp.v2.x + e.x, Tmp.v2.y + e.y , 0.6f*e.fin()+0.1f,8f*0.75f, 12,  e.rotation);
                    Lines.stroke(6f*e.fout());
                });
                width = 19f;
                shake = 2f;
                largeHit = true;
                colors = new Color[]{ExoPal.empyreanIndigoDark.cpy().a(.6f), ExoPal.empyreanIndigoDark, Color.white};
                despawnEffect = Fx.none;
            }};
        }};
        neutronMortar = new PowerTurret("neutron-mortar"){{
            requirements(Category.turret, with(ExoItems.rustyCopper, 420, Items.silicon, 300, ExoItems.osmium, 200, ExoItems.neodymium, 320, ExoItems.lightningStone, 250, ExoItems.vanstariumAlloy, 200, ExoItems.empyreanPlating, 300, ExoItems.litusiumAlloy, 150));
            range = 290f;
            recoil = 5f;
            reload = 300f;
            shake = 4f;
            shootEffect = Fx.shootSmokeSmite;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 7;
            minWarmup = 0.99f;
            shootY = 12;
            scaledHealth = 280;
            cooldownTime = 320;
            shootSound = ExoSounds.shockblast;
            shootCone = 35f;
            shoot = new ShootSpread(){{
                spread = 7f;
                shots = 15;
            }};
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("genesux-"){{
                parts.add(
                        new RegionPart("-plate2"){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            moveX = 4.5f;
                            recoilTime = 350;
                            mirror = true;
                        }},
                        new RegionPart("-plate"){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            moveX = 9f;
                            recoilTime = 350;
                            mirror = true;
                        }},
                        new RegionPart("-front"){{
                            progress = PartProgress.warmup;
                            under = true;
                        }},
                        new RegionPart("-back"){{
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            moveY = -2f;
                            under = true;
                        }}
                );
            }};
            shootType = new ExoBasicBulletType(8f, 207){{
                lifetime = 35f;
                backColor = lightColor = lightningColor = trailColor = hitColor = ExoPal.empyreanblue;
                impact = true;
                knockback = 3f;
                sprite = "circle-bullet";
                damageType = kinetic;
                hitSize = 12f;
                lightning = 2;
                lightningLengthRand = 5;
                lightningLength = 3;
                lightningDamage = damage / 10f;
                width = 155f;
                height = 7;
                shrinkX = 0.45f;
                shrinkY = -2.48f;
                shrinkInterp = Interp.reverse;
                pierce = true;
                intervalBullet = new LightningBulletType(){{
                    damage = 26;
                    lightningColor = ExoPal.empyreanblue;
                    lightningLength = 6;
                    lightningLengthRand = 12;
                    buildingDamageMultiplier = 0.25f;
                }};
                bulletInterval = 3f;
                smokeEffect = ExoFx.square45_6_45;
                hitEffect = ExoFx.square45_6_45;
                despawnEffect = new Effect(35f, 70f, e -> {
                    Draw.color(e.color, Color.white, e.fout() * 0.7f);
                    for(int i : Mathf.signs){

                        Drawf.tri(e.x, e.y, height * 1.5f * e.fout(), width * 0.885f * e.fout(), e.rotation + i * 90);
                        Drawf.tri(e.x, e.y, height * 0.8f * e.fout(), width * 0.252f * e.fout(), e.rotation + 90 + i * 90);
                    }
                });
            }};
        }};
        supernova = new LiquidTurret("supernova"){{
            requirements(Category.turret, with(ExoItems.cobolt, 400, ExoItems.rustyCopper, 300, ExoItems.osmium, 350, ExoItems.thermoCore, 300, ExoItems.iron, 400, ExoItems.neodymium, 200, ExoItems.vanstariumAlloy, 180, ExoItems.empyreanPlating, 150, ExoItems.litusiumAlloy, 250));
            range = 500f;
            squareSprite = false;
            loopSound = Sounds.none;
            extinguish = false;
            recoil = 0f;
            reload = 650f;
            shake = 4f;
            heatColor = Color.red;
            outlineColor = Pal.darkOutline;
            size = 7;
            scaledHealth = 300;
            cooldownTime = 320;
            shoot.firstShotDelay = 100;
            shootEffect = ExoFx.supernovaShoot;
            chargeSound = Sounds.lasercharge2;
            shootSound = ExoSounds.coolplasmaboom;

            warmupMaintainTime = 30f;
            minWarmup = 0.96f;
            shootWarmupSpeed = 0.03f;
            shootY = -4.75f;
            rotateSpeed = 1.5f;
            unitSort = UnitSorts.strongest;
            coolant = consumeCoolant(0.2f);
            consumePower(90f);
            drawer = new DrawTurret("genesux-"){{
                parts.addAll(
                new RegionPart("-glow") {{
                    progress = PartProgress.charge.add(-0.2f).add(p -> Mathf.sin(9f, 0.2f) * p.warmup);
                    color = Color.valueOf("000000");
                    colorTo = Color.red;
                    blending = Blending.additive;
                    outline = mirror = false;
                }},
               // new EffectSpawnPart() {{
                //    useProgress = true;
                //    progress = PartProgress.charge;
                //    y = -4.75f;
                //   effectColor = ExoPal.genesis;
                //   randomEffectRot = 360;
                //   effectChance = 0.5f;
                //}},
               // new EffectSpawnPart() {{
                //    useProgress = true;
                //    y = -4.75f;
                //    effectColor = ExoPal.genesis;
                //    effect = ExoFx.singleSpark;
                //    randomEffectRot = 360;
                //    effectChance = 0.5f;
                //}},
               // new EffectSpawnPart() {{
                //    useProgress = mirror = true;
                //    progress = PartProgress.charge;
                //    x = 4f;
                //    effect = ExoFx.supernovaSpark;
                //    effectChance = 0.5f;
                //}},
               // new ShapePart() {{
               //     circle = true;
               //     y = -4.75f;
               //     layer = 114;
               //     radiusTo = 1;
               //     radius = 0.3f;
               //     color = Color.white;
               // }},
              //  new ShapePart() {{
               //     circle = true;
               //     y = -4.75f;
               //     layer = 110;
               //     radiusTo = 3;
               //     radius = 0.45f;
               //     color = ExoPal.genesis;
               // }},
                 //parts
                new RegionPart("-bodySide"){{
                    progress = PartProgress.warmup;
                    moveX = 6.5f;
                    mirror = under = true;
                }},
                new RegionPart("-backWing"){{
                    progress = PartProgress.warmup;
                    moveX = 12.5f;
                    moveY = -24.5f;
                    moveRot = 80;
                    under = mirror = true;
                }},
                new RegionPart("-backWing"){{
                    progress = PartProgress.warmup;
                    moveX = 6.5f;
                    moveY = -20.5f;
                    moveRot = 25;
                    under = mirror = true;
                }},
                new RegionPart("-backWing"){{
                    progress = PartProgress.warmup;
                    moveY = -17.5f;
                    under = mirror = true;
                }},
                new RegionPart("-wing"){{
                    progress = PartProgress.warmup;
                    y = -8.5f;
                    x = 14.25f;
                    moveRot = -10;
                    moveX = 4.5f;
                    under = mirror = true;
                }},
                new RegionPart("-bodySidePlate"){{
                    progress = PartProgress.warmup;
                    moveX = 4.5f;
                    mirror = true;
                }}
                );
            }};
            ammo(
            Liquids.hydrogen, new StarBulletType(1.3f, 225){{
                radius = 20;
                damageType = thermal;
                hitSound = Sounds.dullExplosion;
                realColor = hitColor = trailColor = ExoPal.cronusRed;
                rotationSpeed = 100;

                trailRotation = true;
                lifetime = 300f;
                swirlEffects = 2;
                splashDamage = 100;
                splashDamageRadius = 50;
                int times = 25;
                float life = ExoFx.starCharge.lifetime;
                chargeEffect = new MultiEffect(
                        new WrapEffect(new RepeatEffect(ExoFx.supernovaCharge, (life - ExoFx.supernovaCharge.lifetime - 1f) / times, times), ExoPal.cronusRed, 48f),
                        ExoFx.starCharge
                );
                shootEffect = new MultiEffect(ExoFx.blastExplosionColor, ExoFx.hitEmpColorSpark);
                hitEffect = despawnEffect = new MultiEffect(Fx.titanSmoke, ExoFx.empyreanExplosion, Fx.colorSpark);
                intervalBullet = new ExoFireBulletType(0.3f,75) {{
                    damageType = thermal;
                    lifetime = 30;
                    drag = -0.0001f;
                    colorFrom = ExoPal.cronusRedlight;
                    colorMid = ExoPal.cronusRed;
                    colorTo = ExoPal.cronusRedDark;
                }};
                intervalBullets = 3;
                bulletInterval = 3;
                trailSinScl = 6;
                trailSinMag = 0.3f;
                trailParam = 5;
                trailLength = 10;
                trailWidth = 3.5f;
            }},
            ExoLiquids.helium, new StarBulletType(1.3f, 425){{
                radius = 29;
                damageType = thermal;
                hitSound = Sounds.dullExplosion;
                realColor = hitColor = trailColor = ExoPal.starYellow;
                trailRotation = true;
                lifetime = 300f;
                splashDamage = 150;
                splashDamageRadius = 50;
                int times = 25;
                float life = ExoFx.starCharge.lifetime;
                chargeEffect = new MultiEffect(
                        new WrapEffect(new RepeatEffect(ExoFx.supernovaCharge, (life - ExoFx.supernovaCharge.lifetime - 1f) / times, times), ExoPal.starYellow, 48f),
                        ExoFx.starCharge
                );
                shootEffect = new MultiEffect(ExoFx.blastExplosionColor, ExoFx.hitEmpColorSpark);
                hitEffect = despawnEffect = new MultiEffect(Fx.titanSmoke, ExoFx.empyreanExplosion, Fx.colorSpark);
                intervalBullet = new ChainLightningBulletType() {{
                    lightningColor = ExoPal.starYellow;
                    damageType = DamageType.thermal;
                    range = 180;
                    targetRange = 150;
                    hitSound = Sounds.none;
                    damage = 80;
                    width = 11;
                    distanceDamageFalloff = 4;
                    chainLightning = 1;
                    segmentLength = 1;
                }};
                intervalBullets = 2;
                bulletInterval = 3;
                trailSinScl = 6;
                trailSinMag = 0.3f;
                trailParam = 5;
                trailLength = 10;
                trailWidth = 3.5f;
            }},
            Liquids.ozone, new StarBulletType(1.3f, 585){{
                radius = 29;
                damageType = thermal;
                hitSound = Sounds.dullExplosion;
                realColor = hitColor = trailColor = ExoPal.starWhite;
                trailRotation = true;
                lifetime = 300f;
                splashDamage = 150;
                splashDamageRadius = 50;
                int times = 25;
                float life = ExoFx.starCharge.lifetime;
                chargeEffect = new MultiEffect(
                        new WrapEffect(new RepeatEffect(ExoFx.supernovaCharge, (life - ExoFx.supernovaCharge.lifetime - 1f) / times, times), ExoPal.starWhite, 48f),
                        ExoFx.starCharge
                );
                shootEffect = new MultiEffect(ExoFx.blastExplosionColor, ExoFx.hitEmpColorSpark);
                hitEffect = despawnEffect = new MultiEffect(Fx.titanSmoke, ExoFx.empyreanExplosion, ExoFx.starShockWave, Fx.colorSpark);
                intervalBullet = new ExoBasicBulletType(1, 100){{
                    width = height = 7f;
                    sprite = "exogenesis-plasma";
                    shrinkY = shrinkX = 0f;
                    damageType = thermal;
                    drag = -0.05f;
                    hitEffect = despawnEffect = ExoFx.blastExplosionColor;
                    backColor = trailColor = hitColor = ExoPal.starWhite;
                    frontColor = lightningColor = lightColor = hitColor;
                    trailLength = 13;
                    homingRange = 80f;
                    homingPower = 0.003f;
                    homingDelay = 3;

                    status = StatusEffects.melting;
                    statusDuration = 60f;
                }};
                fragRandomSpread = 0f;
                fragSpread =  60;
                fragBullets = 6;
                fragBullet = new FancyLaserBulletType(){{
                    damage = 425f;
                    sideAngle = 27f;
                    sideWidth = 1.5f;
                    sideLength = 20f;
                    lifetime = 60;
                    largeHit = true;
                    width = 35f;
                    length = 200f;
                    colors = new Color[]{ExoPal.starWhite.cpy().a(0.4f), ExoPal.starWhite, Color.white};
                    hitEffect = ExoFx.coloredHitLarge;
                    hitColor = ExoPal.starWhite;
                    shootEffect = ExoFx.hitEmpColorSpark;
                }};
                intervalSpread = 60f;
                intervalRandomSpread = 0;
                bulletInterval = 8;
                intervalBullets = 6;
                trailSinScl = 6;
                trailSinMag = 0.3f;
                trailParam = 5;
                trailLength = 10;
                trailWidth = 3.5f;
            }},
            ExoLiquids.coldPlasma, new StarBulletType(1.3f, 660){{
                radius = 29;
                trailWidth = 9.5f;
                trailLength = 57;
                trailSinScl = 3;
                trailSinMag = 0.4f;
                trailParam = 3.5f;
                int times = 25;
                float life = ExoFx.starCharge.lifetime;
                chargeEffect = new MultiEffect(
                        new WrapEffect(new RepeatEffect(ExoFx.supernovaCharge, (life - ExoFx.supernovaCharge.lifetime - 1f) / times, times), ExoPal.genesis, 48f),
                        ExoFx.starCharge
                );
                chargeEffect.lifetime = life;
                realColor = trailColor = hitColor = lightColor = lightningColor = ExoPal.genesis;
                scaleLife = false;
                hitSound = Sounds.plasmaboom;
                splashDamageRadius = 100f;
                splashDamage = 700;
                intervalBullets = 1;
                bulletInterval = 3;
                damageType = DamageType.thermal;
                intervalBullet = new ChainLightningBulletType() {{
                    lightningColor = ExoPal.genesis;
                    damageType = DamageType.thermal;
                    range = 180;
                    targetRange = 150;
                    hitSound = Sounds.none;
                    damage = 340;
                    distanceDamageFalloff = 4;
                    chainLightning = 1;
                    segmentLength = 8;
                }};
                pierce = false;
                collides = true;
                lifetime = 300;
                despawnEffect = hitEffect = ExoFx.empyreanExplosion;
                shootEffect = ExoFx.square45_6_45;
                fragLifeMin = 1f;
                fragBullets = 1;
                fragBullet = new BlackHoleBulletType(0f, 1400f / 30f){{
                    lifetime = 330f;
                    growTime = 15;
                    damageRadius = 30;
                    swirlEffects = 5;
                    swirlInterval = 3;
                    color = hitColor = ExoPal.genesis;
                    lightRadius = 8f;
                    lightOpacity = 0.7f;
                    despawnEffect = hitEffect = ExoFx.singularityDespawn;
                }};
            }}
        );
        }};
        polaris = new ItemTurret("polaris"){{
            requirements(Category.turret, with(ExoItems.cobolt, 400, ExoItems.rustyCopper, 300, ExoItems.osmium, 350, ExoItems.thermoCore, 300, ExoItems.iron, 400, ExoItems.neodymium, 200, ExoItems.vanstariumAlloy, 180, ExoItems.empyreanPlating, 150, ExoItems.litusiumAlloy, 250));
            range = 1000f;
            recoil = 3f;
            reload = 500f;
            shake = 4f;
            heatColor = Color.red;
            outlineColor = Pal.darkOutline;
            size = 7;
            scaledHealth = 280;
            cooldownTime = 2;
            maxAmmo = 200;
            shootSound = Sounds.railgun;
            shootEffect = new Effect(22, e -> {
                color(e.color);
                float w = 1.2f + 7 * e.fout();

                Drawf.tri(e.x, e.y, w, 45f * e.fout(), e.rotation);
                color(e.color);

                for(int i : Mathf.signs){
                    Drawf.tri(e.x, e.y, w * 3.3f, 18f * e.fout(), e.rotation + i * 90f);
                }

                Drawf.tri(e.x, e.y, w, 4f * e.fout(), e.rotation + 180f);
            });
            smokeEffect = new Effect(30,e->{
                Draw.z(Layer.effect);
                Draw.color(e.color,e.fout());
                Tmp.v1.trns(e.rotation, e.fin()*20f);
                Lines.ellipse(Tmp.v1.x + e.x, Tmp.v1.y + e.y , 1.1f*e.fin()+0.1f, 16,27, e.rotation);
                Lines.stroke(4f*e.fout());
            });
            warmupMaintainTime = 30f;
            minWarmup = 0.96f;
            shootWarmupSpeed = 0.03f;
            shootY = -12.25f;
            rotateSpeed = 1;
            shootCone = 20f;
            unitSort = UnitSorts.strongest;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("genesux-") {{
                parts.addAll(
                new RegionPart("-glow") {{
                    progress = PartProgress.warmup.add(-0.2f).add(p -> Mathf.sin(9f, 0.2f) * p.warmup);
                    color = Color.valueOf("000000");
                    colorTo = Color.red;
                    blending = Blending.additive;
                    outline = mirror = false;
                }},
                new EffectSpawnPart() {{
                    useProgress = mirror = true;
                    progress = PartProgress.heat;
                    y = -12.25f;
                    x = 3.5f;
                    effectColor = ExoPal.genesis;
                    effect = ExoFx.railgunSpark;
                    randomEffectRot = 0;
                    effectChance = 1f;
                }},
                new RegionPart("-rail") {{
                    progress = PartProgress.warmup.curve(Interp.pow2In);
                    heatProgress = PartProgress.warmup.add(-0.2f).add(p -> Mathf.sin(9f, 0.2f) * p.warmup);
                    moveY = 8;
                    mirror = false;
                }},
                new RegionPart("-wing") {{
                    progress = PartProgress.warmup.curve(Interp.pow2In);
                    moves.add(new PartMove(PartProgress.recoil, 0f, -8f, 0f), new PartMove(PartProgress.warmup.delay(0.6f), 0f, 5.5f, 0f));
                    heatColor = Color.red;
                    heatProgress = PartProgress.warmup.add(-0.2f).add(p -> Mathf.sin(9f, 0.2f) * p.warmup);
                    moveX = 2.6f;
                    children.add(
                    new RegionPart("-wingbit"){{
                        progress = PartProgress.warmup.delay(0.5f);
                        layerOffset = -0.001f;
                        mirror = true;
                        under = true;
                        moveY = 4.3f;
                    }},
                    new RegionPart("-wingbit2"){{
                        progress = PartProgress.warmup.delay(0.6f);
                        moves.add(new PartMove(PartProgress.recoil, 0f, -3f, 0f), new PartMove(PartProgress.warmup.delay(0.5f), 0f, -3f, 0f));
                        layerOffset = -0.001f;
                        mirror = true;
                        under = true;
                        moveX = 5f;
                    }});
                    mirror = under = true;
                }}
                );
            }};
            ammo(
            Items.tungsten, new ExoRailBulletType(){{
                length = 1000;
                damage = 1000f;
                ammoPerShot = 50;
                damageType = DamageType.pierce;
                hitColor = ExoPal.genesis;
                hitEffect = ExoFx.coloredHitLarge;
                pierceDamageFactor = 0.1f;
                smokeEffect = Fx.colorSpark;
                endEffect = new Effect(22f, e -> {
                    clipSize = 140;
                    color(e.color);
                    Drawf.tri(e.x, e.y, e.fout() * 10f, 25f, e.rotation);
                    color(Color.white);
                    Drawf.tri(e.x, e.y, e.fout() * 4.8f, 19f, e.rotation);
                });
                lineEffect = new Effect(20f, e -> {
                    clipSize = 140;
                    if(!(e.data instanceof Vec2 v)) return;

                    color(e.color);
                    stroke(e.fout() * 1.1f + 0.6f);

                    Fx.rand.setSeed(e.id);
                    for(int i = 0; i < 7; i++){
                        Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                        Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                    }

                    e.scaled(22f, b -> {
                        stroke(b.fout() * 10f);
                        color(e.color);
                        Lines.line(e.x, e.y, v.x, v.y);
                    });
                    e.scaled(22f, b -> {
                        stroke(b.fout() * 6.5f);
                        color(Color.white);
                        Lines.line(e.x, e.y, v.x, v.y);
                    });
                });
            }}
        );
        }};

        genesisFactory = new UnitFactory("genesis-factory"){{
            requirements(Category.units, with(ExoItems.astrolite, 50, Items.silicon, 100, ExoItems.curtuses, 50));
            plans = Seq.with(
                    new UnitPlan(ExoUnitTypes.orion, 60f * 15, with(Items.silicon, 15, ExoItems.curtuses, 50))
            );
            size = 3;
            consumePower(1.2f);
        }};

        empyreanFactory = new UnitFactory("empyrean-factory"){{
            requirements(Category.units, with(Items.copper, 60, Items.beryllium, 70, Items.silicon, 70));
            plans = Seq.with(
                    new UnitPlan(ExoUnitTypes.lux, 60f * 15, with(Items.silicon, 30, Items.beryllium, 50))
            );
            size = 3;
            consumePower(1.2f);
        }};
    }
}