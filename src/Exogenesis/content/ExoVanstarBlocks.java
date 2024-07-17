package Exogenesis.content;

import Exogenesis.entities.part.EffectSpawnPart;
import Exogenesis.type.DamageType;
import Exogenesis.type.bullet.*;
import Exogenesis.type.bullet.vanilla.*;
import Exogenesis.util.feature.PositionLightning;
import Exogenesis.util.func.DrawFunc;
import Exogenesis.world.blocks.PowerHarvester;
import Exogenesis.world.turrets.SpeedupTurret;
import Exogenesis.graphics.ExoPal;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
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
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.blocks.distribution.*;
import mindustry.world.draw.*;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;

import static Exogenesis.type.DamageType.*;
import static mindustry.type.ItemStack.*;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
    public class ExoVanstarBlocks{
        public static Block
        //blocks
        ductEmpyrean, harvesterSmall, harvesterMedium, siliconForger, platingFactory, metaglassForger, listusiumForge, gigavoltForge, y, u, i, o,
        //cores
        coreBelief, coreHope, coreReliance,
        //walls
        listusiumWall, largeListusiumWall, coboltWall, largeCoboltWall, ironWall, largeIronWall, vanstaniumWall, largeVanstaniumWall,
        violiteWall, largeVioliteWall, vanstariumWall, largeVanstariumWall, hugeVanstariumWall,
        //turrets
        focalPoint, gale, light, bliss, prism, tanons, /*wrath,*/ glory, essence, purger,
        excalibur, aspect, godsent, eminence, aeon, grandeur, aether, profane, agios, sin, arbiter, demiurge, phoss,
        empyreanFactory;
        public static void load(){
            //Empyrean blocks
            ductEmpyrean = new Duct("empyrean-duct"){{
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
            metaglassForger = new GenericCrafter("metaglass-forger"){{
                requirements(Category.crafting, with(ExoItems.rustyCopper, 60, Items.graphite, 30, ExoItems.cobolt, 30));
                craftEffect = Fx.smeltsmoke;
                outputItem = new ItemStack(Items.metaglass, 3);
                craftTime = 60f;
                size = 3;
                hasPower = hasItems = true;
                drawer = new DrawMulti(new DrawDefault(),
                        new DrawFlame(Color.valueOf("ffc099")),
                        new DrawGlowRegion("-glow2"){{
                            color = Color.valueOf("70170b");
                            glowIntensity = 1f;
                            alpha = 0.7f;
                        }},
                        new DrawGlowRegion("-glow"){{
                            color = Color.valueOf("70170b");
                            glowIntensity = 1f;
                            alpha = 0.9f;
                        }}
                );
                ambientSound = Sounds.smelter;
                ambientSoundVolume = 0.07f;

                consumeItems(with(ExoItems.quartz, 3, Items.sand, 3));
                consumePower(0.60f);
            }};
            //walls
            coboltWall = new Wall("cobolt-wall"){{
                requirements(Category.defense, with(ExoItems.cobolt, 6));
                health = 120;
                researchCostMultiplier = 0.1f;
            }};
            largeCoboltWall = new Wall("cobolt-wall-large"){{
                requirements(Category.defense, ItemStack.mult(coboltWall.requirements, 4));
                health = 120 * 4;
                size = 2;
            }};
            ironWall = new Wall("iron-wall"){{
                requirements(Category.defense, with(ExoItems.iron, 6));
                health = 160;
                researchCostMultiplier = 0.1f;
            }};
            largeIronWall = new Wall("iron-wall-large"){{
                requirements(Category.defense, ItemStack.mult(ironWall.requirements, 4));
                health = 160 * 4;
                size = 2;
            }};
            listusiumWall = new Wall("listusium-wall"){{
                requirements(Category.defense, with(ExoItems.litusiumAlloy, 6));
                health = 190;
                researchCostMultiplier = 0.1f;
            }};
            largeListusiumWall = new Wall("listusium-wall-large"){{
                requirements(Category.defense, ItemStack.mult(listusiumWall.requirements, 4));
                health = 190 * 4;
                size = 2;
            }};

            //turrets Empyrean
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
                shootSound = Sounds.blaster;
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
                inaccuracy = 5;
                shootCone = 30f;
                shootY = 12;
                shoot = new ShootAlternate(){{
                    barrels = 2;
                    shots = 1;
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
                shootType = new FancyLaserBulletType(){{
                    damage = 75f;
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
                range = 370f;
                recoil = 2f;
                reload = 80f;
                shake = 2f;
                heatColor = Color.red;
                outlineColor = ExoPal.empyreanOutline;
                size = 4;
                shootY = 10;
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
                    lifetime = 160f;
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
                    smokeEffect = Fx.blastExplosion;

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
                                moveY = -3;
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
                recoilTime = 100;
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
                loopSoundVolume = 0.9f;
                coolant = consumeCoolant(0.2f);
                consumePower(6f);
                drawer = new DrawTurret("elecian-"){{
                    parts.addAll(
                            new FlarePart(){{
                                progress = PartProgress.recoil.curve(Interp.pow2In);
                                color1 = ExoPal.empyreanIndigo;
                                y = 16;
                                followRotation = true;
                                rotation = 90;
                                sides = 2;
                                radius = 0;
                                radiusTo = 250;
                                stroke = 3.5f;
                            }},
                            new FlarePart(){{
                                progress = PartProgress.recoil.curve(Interp.pow2In);
                                color1 = ExoPal.empyreanIndigo;
                                y = 16;
                                spinSpeed = 2;
                                sides = 4;
                                radius = 0;
                                radiusTo = 120;
                                stroke = 2.5f;
                            }},
                            new EffectSpawnPart() {{
                                useProgress =  true;
                                progress = PartProgress.recoil;
                                effectColor = ExoPal.empyreanIndigo;
                                y = 16;
                                effect = ExoFx.randLifeSparkExo;
                                randomEffectRot = 60f;
                                effectChance = 0.8f;
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
                shootEffect = Fx.colorSparkBig;
                heatColor = Color.red;
                outlineColor = ExoPal.empyreanOutline;
                rotateSpeed = 1;
                size = 5;
                minWarmup = 0.99f;
                shootY = 12;
                scaledHealth = 280;
                cooldownTime = 320;
                shootSound = Sounds.pulseBlast;
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
                shootType = new ExoBasicBulletType(10f, 207){{
                    lifetime = 45f;
                    backColor = lightColor = lightningColor = trailColor = hitColor = ExoPal.empyreanblue;
                    impact = true;
                    knockback = 7f;
                    drag = 0.017f;
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
                        lightningLength = 3;
                        lightningLengthRand = 7;
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
                reload = 330f;
                shake = 4f;
                shootEffect = ExoFx.colorBomb;
                heatColor = Color.red;
                outlineColor = ExoPal.empyreanOutline;
                size = 5;
                scaledHealth = 280;
                cooldownTime = 320;
                shootSound = Sounds.pulseBlast;

                warmupMaintainTime = 30f;
                minWarmup = 0.96f;
                shootWarmupSpeed = 0.03f;
                shootY = 16f;
                rotateSpeed = 1;
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
                            new EffectSpawnPart() {{
                                useProgress =  true;
                                progress = PartProgress.warmup;
                                effectColor = ExoPal.empyrean;
                                y = shootY;
                                effect = ExoFx.supernovaSpark;
                                randomEffectRot = 360f;
                                effectChance = 0.2f;
                            }},
                            new EffectSpawnPart() {{
                                useProgress =  true;
                                progress = PartProgress.recoil;
                                effectColor = ExoPal.empyrean;
                                y = shootY;
                                effect = ExoFx.randLifeSparkExo;
                                randomEffectRot = 360f;
                                effectChance = 0.1f;
                            }},
                            new RegionPart("-blade"){{
                                progress = PartProgress.warmup.curve(Interp.pow2In);
                                moveX = 8f;
                                moveY = -2;
                                moveRot = 65;
                                mirror = true;
                            }},
                            new RegionPart("-blade"){{
                                progress = PartProgress.warmup.curve(Interp.pow2In);
                                moveX = 11f;
                                moveY = -2;
                                moveRot = 95;
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
            sin = new ContinuousTurret("sin"){{
                requirements(Category.turret, with(Items.carbide, 50, Items.tungsten, 200, ExoItems.neodymium, 150, ExoItems.litusiumAlloy, 75));
                shootType = new PointLaserBulletType(){{
                    damage = 20f;
                    hitEffect = Fx.blastExplosion;
                    beamEffect = Fx.none;
                    beamEffectInterval = 0;
                    buildingDamageMultiplier = 0.75f;
                    damageInterval = 3;
                    color = hitColor = ExoPal.cronusRedlight;
                    sprite = "laser-white";
                    status = StatusEffects.melting;
                    statusDuration = 60;
                    oscScl /= 1.77f;
                    oscMag /= 1.33f;
                    hitShake = 2;
                    trailLength = 8;
                }
                    private final Color tmpColor = new Color();
                    private final Color from = color, to = ExoPal.cronusRed;
                    private final static float chargeReload = 65f;

                    private final static float lerpReload = 10f;

                    private boolean charged(Bullet b){
                        return b.fdata > chargeReload;
                    }

                    private Color getColor(Bullet b){
                        return tmpColor.set(from).lerp(to, warmup(b));
                    }

                    private float warmup(Bullet b){
                        return Mathf.curve(b.fdata, chargeReload - lerpReload / 2f, chargeReload + lerpReload / 2f);
                    }

                    @Override
                    public void update(Bullet b){
                        super.update(b);

                        b.damage = damage * (1 + warmup(b) * 1.5f);

                        boolean cool = false;

                        if(b.data == null)cool = true;
                        else if(b.data instanceof Healthc){
                            Healthc h = (Healthc)b.data;
                            if(!h.isValid() || !h.within(b.aimX, b.aimY, ((Sized)h).hitSize() + 4)){
                                b.data = null;
                                cool = true;
                            }
                        }

                        if(cool){
                            b.fdata = Mathf.approachDelta(b.fdata, 0, 1);
                        }else b.fdata = Math.min(b.fdata, chargeReload + lerpReload / 2f + 1f);

                        if(charged(b)){
                            if(!Vars.headless && b.timer(3, 3)){
                                PositionLightning.createEffect(b, Tmp.v1.set(b.aimX, b.aimY), getColor(b), 1, 2);
                                if(Mathf.chance(0.25)) Fx.none.at(b.x, b.y, tmpColor);
                            }

                            if(b.timer(4, 2.5f)){
                                Lightning.create(b, getColor(b), b.damage() / 2f, b.aimX, b.aimY, b.rotation() + Mathf.range(34f), Mathf.random(5, 12));
                            }
                        }
                    }

                    @Override
                    public void draw(Bullet b){
                        float darkenPartWarmup = warmup(b);
                        float stroke =  b.fslope() * (1f - oscMag + Mathf.absin(Time.time, oscScl, oscMag)) * (darkenPartWarmup + 1) * 5;

                        if(trailLength > 0 && b.trail != null){
                            float z = Draw.z();
                            Draw.z(z - 0.0001f);
                            b.trail.draw(getColor(b), stroke);
                            Draw.z(z);
                        }

                        Draw.color(getColor(b));
                        DrawFunc.basicLaser(b.x, b.y, b.aimX, b.aimY, stroke);
                        Draw.color(Color.white);
                        DrawFunc.basicLaser(b.x, b.y, b.aimX, b.aimY, stroke * 0.74f * (2 + darkenPartWarmup) / 3f);

                        Drawf.light(b.aimX, b.aimY, b.x, b.y, stroke, tmpColor, 0.76f);
                        Drawf.light(b.x, b.y, stroke * 4, tmpColor, 0.76f);
                        Drawf.light(b.aimX, b.aimY, stroke * 3, tmpColor, 0.76f);

                        Draw.color(tmpColor);
                        if(charged(b)){
                            float qW = Mathf.curve(warmup(b), 0.5f, 0.7f);

                            for(int s : Mathf.signs){
                                Drawf.tri(b.x, b.y, 6, 21 * qW, 90 * s + Time.time * 1.8f);
                            }

                            for(int s : Mathf.signs){
                                Drawf.tri(b.x, b.y, 7.2f, 25 * qW, 90 * s + Time.time * -1.1f);
                            }
                        }

                        if(darkenPartWarmup > 0.005f){
                            tmpColor.lerp(Color.white, 1f);
                            Draw.color(tmpColor);
                            DrawFunc.basicLaser(b.x, b.y, b.aimX, b.aimY, stroke * 0.55f * darkenPartWarmup);
                            Draw.z(Layer.effect + 1);
                            DrawFunc.basicLaser(b.x, b.y, b.aimX, b.aimY, stroke * 0.6f * darkenPartWarmup);
                            Draw.z(Layer.effect + 1);
                        }

                        Draw.reset();
                    }

                    @Override
                    public void hit(Bullet b, float x, float y){
                        if(Mathf.chance(0.4))hitEffect.at(x, y, b.rotation(), getColor(b));
                        hitSound.at(x, y, hitSoundPitch, hitSoundVolume);

                        Effect.shake(hitShake, hitShake, b);

                        if(fragOnHit){
                            createFrags(b, x, y);
                        }
                    }

                    @Override
                    public void hitEntity(Bullet b, Hitboxc entity, float health){
                        if(entity instanceof Healthc){
                            Healthc h = (Healthc)entity;
                            if(charged(b)){
                                h.damagePierce(b.damage);
                            }else{
                                h.damage(b.damage);
                            }
                        }

                        if(charged(b) && entity instanceof Unit){
                            Unit unit = (Unit)entity;
                            unit.apply(status, statusDuration);
                        }

                        if(entity == b.data)b.fdata += Time.delta;
                        else b.fdata = 0;
                        b.data = entity;
                    }

                    @Override
                    public void hitTile(Bullet b, Building build, float x, float y, float initialHealth, boolean direct){
                        super.hitTile(b, build, x, y, initialHealth, direct);
                        if(build == b.data)b.fdata += Time.delta;
                        else b.fdata = 0;
                        b.data = build;
                    }
                };
                drawer = new DrawTurret("elecian-"){{
                    parts.addAll(
                            new EffectSpawnPart() {{
                                useProgress =  true;
                                progress = PartProgress.recoil;
                                effectColor = ExoPal.empyreanIndigo;
                                y = 16;
                                effect = ExoFx.randLifeSparkExo;
                                randomEffectRot = 60f;
                                effectChance = 0f;
                            }},
                            //Exhuast particles
                            new EffectSpawnPart() {{
                                useProgress =  true;
                                mirror = false;
                                progress = PartProgress.recoil;
                                effectColor = ExoPal.cronusRed;
                                y = -18.25f;
                                effect = ExoFx.supernovaSpark;
                                randomEffectRot = 20f;
                                effectChance = 0.15f;
                            }},
                            new EffectSpawnPart() {{
                                useProgress =  true;
                                mirror = true;
                                progress = PartProgress.recoil;
                                effectColor = ExoPal.cronusRed;
                                x = 8.5f;
                                y = -11f;
                                effect = ExoFx.supernovaSpark;
                                randomEffectRot = 20f;
                                effectChance = 0.15f;
                            }},
                            //barrel particles
                            new RegionPart("-exhuast-glow"){{
                                mirror = false;
                                layer = Layer.effect;
                                color = new Color(1f, 1f, 1f, 0f);
                                colorTo = ExoPal.cronusRed;
                                blending = Blending.additive;
                                outline = false;
                                progress = PartProgress.warmup;
                            }},
                            new RegionPart("-exhuast-glowExtra"){{
                                mirror = false;
                                layer = Layer.effect;
                                color = new Color(1f, 1f, 1f, 0f);
                                colorTo = ExoPal.cronusRed;
                                blending = Blending.additive;
                                outline = false;
                                progress = PartProgress.warmup;
                            }},
                            new EffectSpawnPart() {{
                                useProgress = mirror = true;
                                progress = PartProgress.warmup;
                                y = 0f;
                                x = 3.5f;
                                effectColor = ExoPal.cronusRed;
                                effect = ExoFx.railgunSpark;
                                randomEffectRot = 1;
                                effectChance = 0.01f;
                            }},
                            new EffectSpawnPart() {{
                                useProgress =  true;
                                progress = PartProgress.warmup;
                                effectColor = ExoPal.cronusRed;
                                y = shootY;
                                effect = ExoFx.randLifeSparkExo;
                                randomEffectRot = 35f;
                                effectChance = 0.3f;
                            }},
                            new EffectSpawnPart() {{
                                useProgress =  true;
                                progress = PartProgress.warmup;
                                effectColor = ExoPal.cronusRed;
                                y = shootY;
                                effect = ExoFx.supernovaSpark;
                                randomEffectRot = 60f;
                                effectChance = 0.8f;
                            }},
                            new RegionPart("-bars-bottom"){{
                                mirror = false;
                                under = true;
                            }},
                            new RegionPart("-bottom-barrel"){{
                                progress = PartProgress.warmup.curve(Interp.fastSlow).delay(0.92f);
                                moveX = 2f;
                                under = true;
                                mirror = true;
                            }},
                            new RegionPart("-bars"){{
                                mirror = false;
                                under = true;
                            }},
                            new RegionPart("-barrel"){{
                                progress = PartProgress.warmup.curve(Interp.fastSlow);
                                moveX = 3f;
                                moves.add(new PartMove(PartProgress.warmup.delay(0.9f), 0f, -2f, 0f));
                                under = true;
                                mirror = true;
                            }},
                            new RegionPart("-body-charger"){{
                        progress = PartProgress.warmup.curve(Interp.sineOut);
                        moveY = -2.5f;
                        mirror = false;
                    }}

                    );
                }};

                shootSound = Sounds.none;
                recoil = 1;
                loopSoundVolume = 1f;
                loopSound = Sounds.laserbeam;

                shootWarmupSpeed = 0.08f;
                shootCone = 10f;

                aimChangeSpeed = 0.9f;
                rotateSpeed = 0.9f;
                canOverdrive = false;

                shootY = 0f;
                minWarmup = 0.8f;
                warmupMaintainTime = 45;
                shootWarmupSpeed /= 2;
                outlineColor = ExoPal.empyreanOutline;
                size = 7;
                range = 420f;
                scaledHealth = 300;
                armor = 10;

                unitSort = UnitSorts.strongest;

                consumePower(16);
                consumeLiquid(Liquids.cryofluid, 12f / 60f);
            }};
            demiurge = new PowerTurret("demiurge"){{
                requirements(Category.turret, with(Items.silicon, 80, Items.beryllium, 50, ExoItems.magnetite, 85));
                range = 300f;
                recoil = 3;
                reload = 485;
                outlineColor = ExoPal.empyreanOutline;
                size = 10;
                cooldownTime = 220;
                scaledHealth = 280;
                moveWhileCharging = true;
                chargeSound = Sounds.lasercharge;
                heatColor = ExoPal.empyreanIndigo;
                shootSound = Sounds.shockBlast;
                shootCone = 60f;
                shootY = 36;
                shoot = new ShootSpread(){{
                    spread = 18;
                    shots = 7;
                    firstShotDelay = 100;
                }};
                rotateSpeed = 0.7f;
                coolant = consumeCoolant(0.2f);
                consumePower(6f);
                drawer = new DrawTurret("elecian-"){{
                        parts.addAll(
                                new RegionPart("-demiurge-charge1"){{
                                    mirror = false;
                                    layer = Layer.effect;
                                    color = new Color(1f, 1f, 1f, 0f);
                                    colorTo = ExoPal.empyreanIndigo;
                                    blending = Blending.additive;
                                    outline = false;
                                    progress = PartProgress.charge;
                                }},
                                new RegionPart("-demiurge-charge2"){{
                                    mirror = false;
                                    layer = Layer.effect;
                                    color = new Color(1f, 1f, 1f, 0f);
                                    colorTo = ExoPal.empyreanIndigo;
                                    blending = Blending.additive;
                                    outline = false;
                                    progress = PartProgress.charge.delay(0.99f);
                                }},
                                new RegionPart("-demiurge-charge3"){{
                                    mirror = false;
                                    layer = Layer.effect;
                                    color = new Color(1f, 1f, 1f, 0f);
                                    colorTo = ExoPal.empyreanIndigo;
                                    blending = Blending.additive;
                                    outline = false;
                                    progress = PartProgress.charge.delay(0.98f);
                                }},
                                new RegionPart("-side-plate"){{
                                    progress = PartProgress.recoil.curve(Interp.bounceIn);
                                    mirror = true;
                                    x = 21.75f;
                                    y = -17.75f;
                                    moveRot = -65f;
                                }},
                                new RegionPart("-barrel-plate"){{
                                    progress = PartProgress.recoil.curve(Interp.bounceIn);
                                    mirror = true;
                                    x = 12.25f;
                                    y = -8.25f;
                                    moveRot = -25f;
                                }},
                                new RegionPart("-body-plate"){{
                                    progress = PartProgress.recoil.curve(Interp.circleOut);
                                    moveX = 4;
                                    mirror = true;
                                }}
                        );
                }};
                shootType = new FancyLaserBulletType(){{
                    damage = 275f;
                    lifetime = 45;
                    sideWidth = 0f;
                    largeHit = true;
                    boltNum = 3;
                    width = 62f;
                    length = 300f;
                    hitColor = ExoPal.empyreanIndigoDark;
                    shootEffect = ExoFx.square45_6_45;
                    colors = new Color[]{ExoPal.empyreanIndigoDark.cpy().a(0.3f), ExoPal.empyreanIndigo, Color.white};
                }};
            }};
            arbiter = new SpeedupTurret("arbiter"){{
                requirements(Category.turret, with(Items.silicon, 80, Items.beryllium, 50, ExoItems.magnetite, 85));
                range = 350f;
                recoil = 0;
                reload = 125;
                outlineColor = ExoPal.empyreanOutline;
                size = 8;
                scaledHealth = 280;
                heatColor = Color.red;
                recoils = 2;
                shootSound = Sounds.laser;
                shootCone = 20f;
                shootY = 24;
                warmupMaintainTime = 120f;
                maxSpeedupScl = 8f;
                speedupPerShoot = 0.1f;
                overheatTime = 800f;
                shoot = new ShootAlternate(){{
                    barrels = 2;
                    spread = 20;
                }};
                rotateSpeed = 1f;
                coolant = consumeCoolant(0.2f);
                consumePower(6f);
                drawer = new DrawTurret("elecian-"){{
                    for(int i = 0; i < 2; i++){
                        int f = i;
                        parts.addAll(
                                new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
                                    progress = PartProgress.recoil.curve(Interp.fastSlow);
                                    recoilIndex = f;
                                    moveY = -6.5f;
                                }},
                                new RegionPart("-barrel-body"){{
                                    progress = PartProgress.recoil.curve(Interp.fastSlow);
                                    under = true;
                                    mirror = true;
                                }},
                                new RegionPart("-barrel-plate-" + (i == 0 ? "l" : "r")){{
                                    progress = PartProgress.recoil.curve(Interp.fastSlow);
                                    recoilIndex = f;
                                    moveY = -8.5f;
                                }}
                        );
                    }
                }};
                shootType = new ExoBasicBulletType(19, 270){{
                    lifetime = 20f;
                    damageType = kinetic;
                    splashDamageRadius = 40;
                    splashDamage = 30;
                    status = StatusEffects.unmoving;
                    statusDuration = 1;
                    width = 14;
                    height = 21;
                    sprite = "circle-bullet";
                    pierceArmor = true;
                    shootEffect = ExoFx.randLifeSparkExo;
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
                    trailWidth = 3.5f;
                    trailLength = 10;
                    despawnEffect = ExoFx.colorBomb;
                    hitEffect = new MultiEffect(ExoFx.empyreanExplosionSplash, Fx.flakExplosionBig);
                }};
            }};
            empyreanFactory = new UnitFactory("empyrean-factory"){{
                requirements(Category.units, with(Items.copper, 60, Items.beryllium, 70, Items.silicon, 70));
                plans = Seq.with(
                        new UnitPlan(ExoUnitTypes.lux, 60f * 15, with(Items.silicon, 30, Items.beryllium, 50))
                );
                size = 3;
                consumePower(1.2f);
            }};
            //cores
            coreBelief = new CoreBlock("core-belief"){{
                requirements(Category.effect, with(ExoItems.rustyCopper, 1000, ExoItems.cobolt, 800));
                alwaysUnlocked = true;

                isFirstTier = true;
                unitType = UnitTypes.alpha;
                health = 1100;
                itemCapacity = 4000;
                size = 4;

                unitCapModifier = 8;
            }};
            coreHope = new CoreBlock("core-hope"){{
                requirements(Category.effect, with(ExoItems.rustyCopper, 3000, ExoItems.cobolt, 3000, Items.silicon, 2000));

                unitType = UnitTypes.beta;
                health = 3500;
                itemCapacity = 9000;
                size = 5;
                thrusterLength = 20f;
                unitCapModifier = 16;
                researchCostMultiplier = 0.07f;
            }};
            coreReliance = new CoreBlock("core-reliance"){{
                requirements(Category.effect, with(ExoItems.rustyCopper, 8000, ExoItems.cobolt, 8000, Items.silicon, 5000, ExoItems.neodymium, 4000));

                unitType = UnitTypes.gamma;
                health = 6000;
                itemCapacity = 13000;
                size = 6;
                thrusterLength = 24f;

                unitCapModifier = 24;
                researchCostMultiplier = 0.11f;
            }};
        }
    }
