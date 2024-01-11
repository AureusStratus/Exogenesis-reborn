package Exogenesis.content;

import Exogenesis.type.DamageType;
import Exogenesis.type.bullet.*;
import Exogenesis.type.bullet.vanilla.*;
import Exogenesis.world.turrets.SpeedupTurret;
import Exogenesis.graphics.ExoPal;

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
    //env
    deepVansterWater, vansterWater, shallowVansterWater, vansterSandyWater, yellowIce, yellowGrass, lightningStoneCharged, lightningStoneDim, skystonegrey, skystone, vanstarock, vanstarockRound, skystonebright, redLightningStone, blackSand,
    lightningStoneChargedWall, lightningStoneDimWall, redLightningStoneWall,
    //ore
    oreOltuxium, oreChronophite, oreGold, ferricIronWall, magnetiteOreWall, magnetiteCrystal, lightningCrystal,
    //blocks
    ductEmpyrean,
    //turrets
    focalPoint, gale, light, bliss, prism, tanons, glory, essence, purger,
    excalibur, aspect, godsent, eminence, grandeur, aether, agios, arbiter, phoss,
    genesisFactory, empyreanFactory;

    public static void load(){
        oreOsmium = new OreBlock(ExoItems.osmium){{
            variants = 5;
            wallOre = true;
        }};

        //empyrean
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
        lightningCrystal = new TallBlock("lightning-crystal"){{
            variants = 3;
            itemDrop = ExoItems.lightningStone;
            clipSize = 128f;
        }};
        //Empyrean blocks
        ductEmpyrean = new Duct("duct-empyrean"){{
            requirements(Category.distribution, with(Items.beryllium, 1));
            health = 90;
            speed = 4f;
            researchCost = with(Items.beryllium, 5);
        }};

        //turrets Empyrean
        focalPoint = new ContinuousTurret("focal-point"){{
            requirements(Category.turret, with(Items.silicon, 30, Items.beryllium, 20));
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
            requirements(Category.turret, with(Items.beryllium, 20, ExoItems.oltuxium, 20));
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
            drawer = new DrawTurret("elecian-"){{
            }};
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
            requirements(Category.turret, with(ExoItems.oltuxium, 25, Items.copper, 25, Items.silicon, 20));
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
            drawer = new DrawTurret("elecian-"){{
            }};
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
            requirements(Category.turret, with(ExoItems.oltuxium, 40, Items.silicon, 30));
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
                hitEffect = despawnEffect = ExoFx.colorBombSmaller;
                smokeEffect = Fx.colorSpark;
            }};
        }};

        prism = new ContinuousTurret("prism"){{
            requirements(Category.turret, with(Items.copper, 30, Items.silicon, 50, ExoItems.oltuxium, 30, ExoItems.iron, 40));
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
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            hollow = true;
                            color = ExoPal.empyreanIndigoDark;
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
                            color = ExoPal.empyreanIndigoDark;
                            layer = Layer.effect;
                            circle = true;
                            stroke = 0;
                            strokeTo = 0.9f;
                            radius = 7.5f;
                            radiusTo = 7.5f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.curve(Interp.pow2In);
                            color = ExoPal.empyreanIndigoDark;
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
                hitColor = trailColor = ExoPal.empyreanIndigoDark;
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
            requirements(Category.turret, with(Items.silicon, 100, ExoItems.magnetite, 40, Items.copper, 40));
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
            drawer = new DrawTurret("elecian-"){{
            }};
            shootType = new PosLightningType(50f){{
                lightningColor = hitColor = ExoPal.empyrean;
                damageType = DamageType.energy;
                lightningDamage = 8;
                lightning = 7;
                lightningLength = 15;
                lightningLengthRand = 35;
                maxRange = rangeOverride = 250f;
                hitEffect = Fx.circleColorSpark;
                smokeEffect = Fx.shootBigSmoke2;
            }};
        }};

        glory = new PowerTurret("glory"){{
            requirements(Category.turret, with(Items.beryllium, 80, ExoItems.iron, 55, ExoItems.magnetite, 55));
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
            drawer = new DrawTurret("elecian-"){{
            }};
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

        essence = new SpeedupTurret("essence"){{
            requirements(Category.turret, with(Items.beryllium, 1000, ExoItems.iron, 85, ExoItems.oltuxium, 30));
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
            drawer = new DrawTurret("elecian-"){{
            }};
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
            requirements(Category.turret, with(Items.silicon, 80, Items.beryllium, 50, ExoItems.magnetite, 85));
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
            requirements(Category.turret, with(Items.beryllium, 100, ExoItems.oltuxium, 50, Items.copper, 50, ExoItems.vanstariumAlloy, 170, ExoItems.litusiumAlloy, 70));
            range = 270f;
            recoil = 2f;
            reload = 80f;
            shake = 2f;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            outlineColor = ExoPal.empyreanOutline;
            size = 4;
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
                backColor = hitColor = trailColor = ExoPal.empyreanIndigoDark;
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
            requirements(Category.turret, with(Items.copper, 120, ExoItems.oltuxium, 80, ExoItems.magnetite, 120, ExoItems.iron, 70, ExoItems.vanstariumAlloy, 120, ExoItems.litusiumAlloy, 80));
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
                            color = ExoPal.empyreanIndigoDark;
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
                            color = ExoPal.empyreanIndigoDark;
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
                hitColor = ExoPal.empyreanIndigoDark;
                hitEffect = despawnEffect = Fx.hitBulletColor;
            }};
        }};

        godsent = new PowerTurret("godsent"){{
            requirements(Category.turret, with(Items.copper, 120, ExoItems.osmium, 40, ExoItems.oltuxium, 120, ExoItems.magnetite, 60, ExoItems.vanstariumAlloy, 150, ExoItems.iron, 100, ExoItems.litusiumAlloy, 90));
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
            requirements(Category.turret, with(Items.beryllium, 40, ExoItems.oltuxium, 80, ExoItems.gold, 50, ExoItems.magnetite, 40, ExoItems.iron, 140, ExoItems.vanstariumAlloy, 120, ExoItems.litusiumAlloy, 100));
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
            drawer = new DrawTurret("elecian-"){{
            }};
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

        grandeur = new ContinuousTurret("grandeur"){{
            requirements(Category.turret, with(Items.beryllium, 420, Items.silicon, 280, ExoItems.osmium, 100, ExoItems.magnetite, 320, ExoItems.lightningStone, 250, ExoItems.iron, 170, ExoItems.vanstariumAlloy, 180));
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
            loopSoundVolume = 1.5f;
            coolant = consumeCoolant(0.2f);
            consumePower(6f);
            drawer = new DrawTurret("elecian-"){{
                parts.addAll(
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
                            moveX = 3.5f;
                            mirror = true;
                        }}
                );
            }};
            shootType = new ExoContinuousLaserBulletType(){{
                hitColor = ExoPal.empyreanIndigoDark;
                damageType = DamageType.thermal;
                damage = 175f;
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
                drawSize = 420f;
                backLength = 29f;
                pointyScaling = 0.5f;
                width = 19f;
                shake = 2f;
                largeHit = true;
                colors = new Color[]{ExoPal.empyreanIndigoDark.cpy().a(.6f), ExoPal.empyreanIndigoDark, Color.white};
                despawnEffect = Fx.none;
            }};
        }};

        aether = new PowerTurret("aether"){{
            requirements(Category.turret, with(Items.copper, 420, Items.silicon, 480, ExoItems.gold, 170, ExoItems.magnetite, 320, ExoItems.chronophite, 350, ExoItems.vanstariumAlloy, 200, ExoItems.litusiumAlloy, 200));
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


        agios = new PowerTurret("agios"){{
            requirements(Category.turret, with(Items.copper, 220, Items.silicon, 500, ExoItems.oltuxium, 100, ExoItems.chronophite, 300, ExoItems.lightningStone, 300, ExoItems.iron, 450, ExoItems.vanstariumAlloy, 180, ExoItems.litusiumAlloy, 300));
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
                            moveRot = 45;
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
            shootSound = Sounds.laser;
            inaccuracy = 1;
            shootCone = 30f;
            shootY = 32;
            shoot = new ShootAlternate(){{
                barrels = 2;
                spread = 16;
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
                                mirror = true;
                            }},
                            new RegionPart("-barrel-plate-" + (i == 0 ? "l" : "r")){{
                                progress = PartProgress.recoil;
                                recoilIndex = f;
                                moveY = -3.5f;
                            }}
                    );
                }
            }};
            shootType = new LaserBulletType(){{
                damage = 75f;
                sideAngle = 40f;
                sideWidth = 1.5f;
                sideLength = 30f;
                width = 25f;
                length = 210f;
                hitColor = ExoPal.empyrean;
                shootEffect = ExoFx.square45_6_45;
                colors = new Color[]{Color.valueOf("f5c04590"), Color.valueOf("fee761"), Color.white};
            }};
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