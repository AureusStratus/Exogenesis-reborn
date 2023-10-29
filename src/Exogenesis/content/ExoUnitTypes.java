package Exogenesis.content;

import Exogenesis.entities.bullet.DelayedPointBulletType;
import Exogenesis.entities.bullet.EffectBulletType;
import Exogenesis.entities.bullet.PosLightningType;
import Exogenesis.graphics.ExoPal;
import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import mindustry.entities.units.*;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class ExoUnitTypes {
    public static UnitType ursa, avicularia, twilight, notodoris,
    //erekir
    prometheus, atlas, nemesis, hyperion, rhea, cronus,
    //empyrean
    lux, glimmer, shine, auric, radiance, prayer, apprise, revelation, enlightenment, excelsus, orion;
    public static void load() {
        prometheus = new ErekirUnitType("prometheus") {{
            constructor = TankUnit::create;
            speed = 0.28f;
            hitSize = 110f;
            health = 80000f;
            fogRadius = 50;
            crushDamage = 1.5f;
            faceTarget = false;
            singleTarget = true;
            armor = 75;
            shadowElevation = 0.1f;
            omniMovement = false;
            treadPullOffset = 1;
            rotateSpeed = 0.45f;
            treadRects = new Rect[]{new Rect(65, 70, 131, 180), new Rect(46, -248, 85, 63), new Rect(166, -183.5f, 32, 39)};
            weapons.add(new Weapon("exogenesis-prometheus-cannon"){{
                shootSound = Sounds.laserblast;
                soundPitchMin = 1f;
                minWarmup = 0.7f;
                smoothReloadSpeed = 0.08f;
                shootWarmupSpeed = 0.03f;
                shadow = 50f;
                heatColor = Color.valueOf("f9350f");
                top = rotate = true;
                mirror = false;
                shake = 14f;
                shootY = 8f;
                x = y = 0;
                reload = 200f;
                recoil = 3f;
                layerOffset = 1;
                rotateSpeed = 0.6f;
                cooldownTime = 250f;
                parts.addAll(
                new RegionPart("-glow"){{
                    color = Color.red;
                    colorTo = Color.red;
                    blending = Blending.additive;
                    outline = mirror = false;
                }},
                new ShapePart(){{
                    progress = PartProgress.warmup.delay(0.2f);
                    color = Color.valueOf("feb380");
                    circle = hollow = true;
                    stroke = 0f;
                    strokeTo = 1.9f;
                    radius = radiusTo = 18;
                    layer = Layer.effect;
                    y = -36;
                }},
                new ShapePart(){{
                    progress = PartProgress.warmup.delay(0.2f);
                    color = Color.valueOf("feb380");
                    circle = hollow = true;
                    stroke = 0f;
                    strokeTo = 1.1f;
                    radius = radiusTo = 7;
                    layer = Layer.effect;
                    y = -36;
                }},
                new ShapePart(){{
                    progress = PartProgress.warmup.delay(0.2f);
                    color = Color.valueOf("feb380");
                    circle = hollow = true;
                    stroke = 0f;
                    strokeTo = 0.7f;
                    radius = radiusTo = 9;
                    layer = Layer.effect;
                    y = -36;
                }},
                new HaloPart() {{
                    y = -36f;
                    radius = 4.6f;
                    tri = true;
                    color = Color.valueOf("feb380");
                    layer = Layer.effect;
                    haloRotateSpeed = 0.7f;
                    haloRadius = haloRadiusTo = 18f;
                    stroke = 0f;
                    strokeTo = 2f;
                    shapes = 4;
                    triLengthTo = 4f;
                    triLength = 0;
                }},
                new HaloPart() {{
                    y = -36f;
                    radius = 4.6f;
                    tri = true;
                    color = Color.valueOf("feb380");
                    layer = Layer.effect;
                    haloRotateSpeed = -0.7f;
                    haloRadius = haloRadiusTo = 18f;
                    stroke = 0f;
                    strokeTo = 2f;
                    shapes = 4;
                    triLengthTo = 4f;
                    triLength = 0;
                }},
                new RegionPart("-spine1"){{
                    mirror = under = true;
                    x = 9;
                    y = 54;
                    progress = PartProgress.warmup.delay(0.1f).blend(PartProgress.reload, 1f);
                    moves.add(new PartMove(PartProgress.recoil.shorten(1f), 0f, 0f, 13f));
                    moveRot = 50f;
                }},
                new RegionPart("-spine1"){{
                    mirror = under = true;
                    x = 9;
                    y = 62;
                    progress = PartProgress.warmup.delay(0.2f).blend(PartProgress.reload, 1f);
                    moves.add(new PartMove(PartProgress.recoil.shorten(1f), 0f, 0f, 16f));
                    moveRot = 68f;
                }},
                new RegionPart("-spine2"){{
                    mirror = under = true;
                    x = 9;
                    y = 68;
                    progress = PartProgress.warmup.delay(0.3f).blend(PartProgress.reload, 1f);
                    moves.add(new PartMove(PartProgress.recoil.shorten(1f), 0f, 0f, 18f));
                    moveRot = 83f;
                }}
                );
                bullet = new RailBulletType(){{
                    damage = 1500f;
                    length = 530;
                    lightColor = hitColor = lightningColor = Color.valueOf("feb380");
                    shootEffect = ExoFx.ColorRailShoot;
                    pierceEffect = ExoFx.ColorRailHit;
                    pointEffect = ExoFx.ColorRailTrail;
                    hitEffect = Fx.massiveExplosion;
                    smokeEffect = Fx.shootBig2;
                    pointEffectSpace = 25f;
                    pierceDamageFactor = 0.3f;
                    collidesTiles = true;
                }};
            }});
            weapons.add(new Weapon("exogenesis-prometheus-machine-gun") {{
                reload = 60f;
                mirror = rotate = true;
                cooldownTime = 80;
                rotateSpeed = 1.5f;
                x = 24;
                y = 30;
                shoot = new ShootPattern() {{
                    shots = 4;
                }};
                shootY = inaccuracy = 8;
                velocityRnd = 0.2f;
                shootSound = Sounds.artillery;
                ejectEffect = Fx.casing2;
                heatColor = Color.valueOf("f9350f");
                recoil = 4;
                shake = 1.8f;
                parts.addAll(
                new RegionPart("-glow"){{
                    color = Color.red;
                    colorTo = Color.red;
                    blending = Blending.additive;
                    outline = mirror = false;
                }}
                );
                bullet = new ArtilleryBulletType() {{
                    damage = 115f;
                    hitEffect = Fx.massiveExplosion;
                    speed = 4.5f;
                    lifetime = 90;
                    shootEffect = new MultiEffect(Fx.shootBig2, Fx.shootBigSmoke);
                    status = StatusEffects.blasted;
                    statusDuration = 100;
                    width = height = 19;
                    splashDamage = 57f;
                    splashDamageRadius = 60;
                    trailLength = 10;
                    trailWidth = 3.5f;
                    backColor = trailColor = lightColor = Color.valueOf("feb380");
                }};
            }});
            weapons.add(new Weapon("exogenesis-prometheus-machine-gun") {{
                reload = 60f;
                mirror = rotate = true;
                cooldownTime = 80;
                rotateSpeed = 1.5f;
                x = -15;
                y = 38;
                shoot = new ShootPattern() {{
                    shots = 4;
                }};
                shootY = inaccuracy = 8;
                velocityRnd = 0.2f;
                shootSound = Sounds.artillery;
                ejectEffect = Fx.casing2;
                heatColor = Color.valueOf("f9350f");
                recoil = 4;
                shake = 1.8f;
                parts.addAll(
                        new RegionPart("-glow"){{
                            color = Color.red;
                            colorTo = Color.red;
                            blending = Blending.additive;
                            outline = mirror = false;
                        }}
                );
                bullet = new ArtilleryBulletType() {{
                    damage = 115f;
                    hitEffect = Fx.massiveExplosion;
                    speed = 4.5f;
                    lifetime = 90;
                    shootEffect = new MultiEffect(Fx.shootBig2, Fx.shootBigSmoke);
                    status = StatusEffects.blasted;
                    statusDuration = 100;
                    width = height = 19;
                    splashDamage = 57f;
                    splashDamageRadius = 60;
                    trailLength = 10;
                    trailWidth = 3.5f;
                    backColor = trailColor = lightColor = Color.valueOf("feb380");
                }};
            }});
        }};
        atlas = new ErekirUnitType("atlas") {{
            constructor = LegsUnit::create;
            fogRadius = 50;
            speed = 0.45f;
            hitSize = 56f;
            health = 78000f;
            faceTarget = singleTarget = true;
            armor = 30;
            shadowElevation = 0.3f;
            allowLegStep = hovering = true;
            rotateSpeed = 1.6f;
            legSpeed = 0.6f;
            legMoveSpace = 0.7f;
            baseLegStraightness = 0.8f;
            legPhysicsLayer = false;
            legGroupSize = 4;
            legLength = 50;
            legCount = 8;
            legExtension = -4;
            legContinuousMove = lockLegBase = true;
            rippleScale = 6.8f;
            legPairOffset = 3;
            legBaseOffset = 36;
            legSplashDamage = 156;
            legSplashRange = 60;
            groundLayer = 77;
            weapons.add(new Weapon("atlas-boom") {{
                reload = 800f;
                mirror = false;
                x = 0;
                y = 4.5f;
                shootY = 0;
                shootStatus = StatusEffects.unmoving;
                shootStatusDuration = shoot.firstShotDelay;
                shoot.firstShotDelay = 150;
                shootSound = Sounds.artillery;
                smoothReloadSpeed = 0.15f;
                shootWarmupSpeed = 0.05f;
                minWarmup = 0.9f;
                recoilTime = 500;
                recoil = 0;
                shake = 1f;
                parts.addAll(
                        new HoverPart(){{
                            color = Pal.techBlue;
                            circles = 5;
                            stroke = 0f;
                            phase = 170;
                            radius = 28;
                            layer = Layer.effect;
                            y = 6.5f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.delay(0.2f);
                            color = Pal.techBlue;
                            circle = hollow = true;
                            stroke = 0f;
                            strokeTo = 1.9f;
                            radius = radiusTo = 18;
                            layer = Layer.effect;
                            y = -42;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.warmup.delay(0.2f);
                            color = Pal.techBlue;
                            circle = hollow = true;
                            sides = 4;
                            rotateSpeed = 0.7f;
                            stroke = 0f;
                            strokeTo = 1.3f;
                            radius = radiusTo = 17;
                            layer = Layer.effect;
                            y = -42;
                        }},
                        new ShapePart() {{
                            progress = PartProgress.warmup.delay(0.2f);
                            color = Pal.techBlue;
                            circle = hollow = true;
                            sides = 4;
                            rotateSpeed = -0.7f;
                            stroke = 0f;
                            strokeTo = 1.3f;
                            radius = radiusTo = 17;
                            layer = Layer.effect;
                            y = -42;
                        }},
                        new ShapePart() {{
                            progress = PartProgress.warmup.delay(0.2f);
                            color = Pal.techBlue;
                            circle = hollow = true;
                            stroke = 0f;
                            strokeTo = 0.7f;
                            radius = radiusTo = 9;
                            layer = Layer.effect;
                            y = -42;
                        }},
                        new HaloPart() {{
                            progress = PartProgress.warmup.delay(0.2f);
                            color = Pal.techBlue;
                            tri = true;
                            haloRotateSpeed = -0.7f;
                            haloRadius = haloRadiusTo = 17.5f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = 8;
                            triLength = 0;
                            radius = 4.6f;
                            layer = Layer.effect;
                            y = -42;
                        }},
                        new HaloPart() {{
                            progress = PartProgress.warmup.delay(0.2f);
                            color = Pal.techBlue;
                            tri = true;
                            haloRotateSpeed = 0.7f;
                            haloRadius = haloRadiusTo = 17.5f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = 8;
                            triLength = 0;
                            radius = 4.6f;
                            layer = Layer.effect;
                            y = -42;
                        }},
                        // weapon parts
                        new ShapePart(){{
                            progress = PartProgress.recoil;
                            color = Color.white;
                            circle = true;
                            radius = 1.5f;
                            radiusTo = 10;
                            layer = 114;
                            y = 2;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.recoil;
                            color = Color.valueOf("aec6ff");
                            circle = true;
                            radius = 3;
                            radiusTo = 20;
                            layer = Layer.effect;
                            y = 2;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.recoil;
                            color = Color.valueOf("8ca9e855");
                            circle = true;
                            radius = 4;
                            radiusTo = 26;
                            layer = Layer.effect;
                            y = 2;
                        }},
                        new ShapePart() {{
                            progress = PartProgress.recoil;
                            color = Color.valueOf("597cff45");
                            circle = true;
                            radius = 4.2f;
                            radiusTo = 29;
                            layer = Layer.effect;
                            y = 2;
                        }}
                );
                bullet = new EmpBulletType() {{
                    parts.addAll(
                        new ShapePart(){{
                            color = Color.white;
                            circle = true;
                            radius = radiusTo = 15;
                            layer = 114;
                        }},
                        new ShapePart(){{
                            color = Color.valueOf("aec6ff");
                            circle = true;
                            radius = radiusTo = 25;
                            layer = Layer.effect;
                        }},
                        new ShapePart(){{
                            color = Color.valueOf("8ca9e855");
                            circle = true;
                            radius = radiusTo = 31;
                            layer = Layer.effect;
                        }},
                        new ShapePart(){{
                            color = Color.valueOf("597cff45");
                            circle = true;
                            radius = radiusTo = 34;
                            layer = Layer.effect;
                       }},
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           haloRotateSpeed = -2.4f;
                           haloRadius = haloRadiusTo = 36f;
                           stroke = strokeTo = 2f;
                           shapes = 2;
                           triLengthTo = triLength = 9;
                           radius = 35f;
                           layer = Layer.effect;
                       }},
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           shapeRotation = 180;
                           haloRotateSpeed = -2.4f;
                           haloRadius = haloRadiusTo = 36f;
                           stroke = strokeTo = 2f;
                           shapes = 2;
                           triLengthTo = triLength = 6;
                           radius = 12f;
                           layer = Layer.effect;
                       }},
                       //1
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           haloRotateSpeed = -2.7f;
                           haloRadius = haloRadiusTo = 36f;
                           stroke = strokeTo = 2f;
                           shapes = 1;
                           triLengthTo = triLength = 9;
                           radius = 35f;
                           layer = Layer.effect;
                        }},
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           shapeRotation = 180;
                           haloRotateSpeed = -2.7f;
                           haloRadius = haloRadiusTo = 36f;
                           stroke = strokeTo = 2f;
                           shapes = 1;
                           triLengthTo = triLength = 6;
                           radius = 12f;
                           layer = Layer.effect;
                        }},
                        //2
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           haloRotateSpeed = -1.7f;
                           haloRadius = haloRadiusTo = 36f;
                           stroke = strokeTo = 2f;
                           shapes = 1;
                           triLengthTo = triLength = 9;
                           radius = 35f;
                           layer = Layer.effect;
                        }},
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           shapeRotation = 180;
                           haloRotateSpeed = -1.7f;
                           haloRadius = haloRadiusTo = 36f;
                           stroke = strokeTo = 2f;
                           shapes = 1;
                           triLengthTo = triLength = 6;
                           radius = 12f;
                           layer = Layer.effect;
                        }},
                            //3
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           haloRotateSpeed = 2f;
                           haloRadius = haloRadiusTo = 36f;
                           stroke = strokeTo = 2f;
                           shapes = 1;
                           triLengthTo = triLength = 9;
                           radius = 35f;
                           layer = Layer.effect;
                        }},
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           shapeRotation = 180;
                           haloRotateSpeed = 2f;
                           haloRadius = haloRadiusTo = 36f;
                           stroke = strokeTo = 2f;
                           shapes = 1;
                           triLengthTo = triLength = 6;
                           radius = 12f;
                           layer = Layer.effect;
                        }},
                            //4
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           haloRotateSpeed = 1.2f;
                           haloRadius = haloRadiusTo = 32f;
                           stroke = strokeTo = 2f;
                           shapes = 1;
                           triLengthTo = triLength = 9;
                           radius = 28f;
                           layer = Layer.effect;
                        }},
                       new HaloPart() {{
                           color = Pal.techBlue;
                           tri = true;
                           shapeRotation = 180;
                           haloRotateSpeed = 1.2f;
                           haloRadius = haloRadiusTo = 32f;
                           stroke = strokeTo = 2f;
                           shapes = 1;
                           triLengthTo = triLength = 6;
                           radius = 12f;
                           layer = Layer.effect;
                        }}
                       //5
                    );
                    width = height = 0;
                    backColor = hitColor = trailColor = Pal.techBlue;
                    lifetime = 160f;
                    scaleLife = scaledSplashDamage = true;
                    hitSound = Sounds.largeExplosion;
                    chargeEffect = new MultiEffect(
                    new WaveEffect(){{
                        colorFrom = Pal.techBlue;
                        colorTo = Color.valueOf("aec6ff");
                        sizeFrom = 180;
                        sizeTo = 0f;
                        lifetime = 150f;
                        strokeTo = 7;
                        strokeFrom = 0f;
                    }},
                    new WaveEffect(){{
                        colorFrom = Pal.techBlue;
                        colorTo = Color.valueOf("aec6ff");
                        interp = Interp.pow5Out;
                        sizeFrom = 180;
                        sizeTo = 0f;
                        lifetime = 150f;
                        strokeTo = 7;
                        strokeFrom = 0f;
                    }},
                    new WaveEffect(){{
                        colorFrom = Pal.techBlue;
                        colorTo = Color.valueOf("aec6ff");
                        sizeFrom = 150;
                        sizeTo = 0f;
                        lifetime = 130f;
                        strokeTo = 6;
                        strokeFrom = 0f;
                    }},
                    new WaveEffect(){{
                        colorFrom = Pal.techBlue;
                        colorTo = Color.valueOf("aec6ff");
                        sizeFrom = 120;
                        sizeTo = 0f;
                        lifetime = 120f;
                        strokeTo = 4;
                        strokeFrom = 0f;
                    }});
                    hitEffect = new MultiEffect(
                    new ParticleEffect(){{
                        lightOpacity = 0.5f;
                        particles = 30;
                        length = 150;
                        baseLength = 30;
                        lifetime = 240;
                        interp = Interp.circleOut;
                        sizeInterp = Interp.pow5In;
                        sizeFrom = 27;
                        sizeTo = 1;
                        lightColor = colorFrom = colorTo = Pal.techBlue;
                    }},
                    new ParticleEffect(){{
                        lightOpacity = 0.5f;
                        particles = 30;
                        length = 180;
                        baseLength = 30;
                        lifetime = 60;
                        interp = Interp.circleOut;
                        sizeInterp = Interp.pow5In;
                        sizeFrom = 15;
                        sizeTo = 1;
                        lightColor = colorFrom = colorTo = Pal.techBlue;
                    }},
                    new ParticleEffect(){{
                        lightOpacity = 0.5f;
                        particles = 30;
                        length = 120;
                        baseLength = 30;
                        lifetime = 180;
                        interp = Interp.circleOut;
                        sizeInterp = Interp.pow5In;
                        sizeFrom = 20;
                        sizeTo = 1;
                        lightColor = colorFrom = colorTo = Pal.techBlue;
                    }},
                    new ParticleEffect(){{
                        lightOpacity = 0.5f;
                        particles = 20;
                        length = 180;
                        baseLength = 30;
                        lifetime = 220;
                        interp = Interp.circleOut;
                        sizeInterp = Interp.pow5In;
                        sizeFrom = 35;
                        sizeTo = 1;
                        lightColor = colorFrom = colorTo = Pal.techBlue;
                    }},
                    new ParticleEffect(){{
                        lightOpacity = 0.5f;
                        particles = 35;
                        layer = 99;
                        length = 160;
                        baseLength = 30;
                        lifetime = 160;
                        interp = Interp.circleOut;
                        sizeInterp = Interp.pow5In;
                        sizeFrom = 21;
                        sizeTo = 10;
                        lightColor = colorFrom = colorTo = Color.valueOf("7d7d7d");
                    }},
                    new ParticleEffect(){{
                        lightOpacity = 0.5f;
                        particles = 35;
                        layer = 99;
                        length = 160;
                        baseLength = 30;
                        lifetime = 180;
                        interp = Interp.circleOut;
                        sizeInterp = Interp.pow5In;
                        sizeFrom = 25;
                        sizeTo = 18;
                        lightColor = colorFrom = colorTo = Color.valueOf("7d7d7d");
                    }},
                    new ParticleEffect(){{
                        lightOpacity = 0.5f;
                        line = true;
                        particles = 35;
                        length = 275;
                        offset = 40;
                        strokeFrom = 5;
                        strokeTo = 0;
                        lifetime = 160;
                        lenFrom = 20;
                        lenTo = 10;
                        lightColor = colorFrom = Pal.techBlue;
                        colorTo = Color.valueOf("aec6ff");
                    }},
                    new WaveEffect(){{
                        colorTo = Pal.techBlue;
                        colorFrom = Color.valueOf("aec6ff");
                        interp = Interp.circleOut;
                        sizeFrom = 20;
                        sizeTo = 150f;
                        lifetime = 55;
                        strokeTo = 0;
                        strokeFrom = 10f;
                    }},
                    new WaveEffect(){{
                        colorTo = Pal.techBlue;
                        colorFrom = Color.valueOf("aec6ff");
                        interp = Interp.circleOut;
                        sizeFrom = 10;
                        sizeTo = 100f;
                        lifetime = 55;
                        strokeTo = 0;
                        strokeFrom = 7f;
                    }});
                    speed = 4f;
                    damage = 260f;
                    recoil = 0.6f;
                    splashDamage = 1275;
                    splashDamageRadius = 100;
                    buildingDamageMultiplier = 1.45f;
                    collidesTiles = true;
                    collidesAir = collidesGround = false;
                    radius = 150f;
                    lightRadius = 60;
                    timeIncrease = 0f;
                    powerDamageScl = 1;
                    powerSclDecrease = 0.3f;
                    unitDamageScl = 0.2f;
                    status = StatusEffects.freezing;
                    statusDuration = 100;
                    shootEffect = Fx.lightningShoot;
                    homingPower = 0.0678f;
                    homingRange = 40;
                    trailSinScl = 2.4f;
                    trailSinMag = 1.2f;
                    trailLength = 26;
                    trailWidth = 9f;
                    trailChance = 0.3f;
                    trailParam = 3.5f;
                    trailEffect = new ParticleEffect() {{
                        particles = 5;
                        length = baseLength = 13.5f;
                        lifetime = 30f;
                        cone = 360;
                        colorFrom = trailColor;
                        colorTo = Color.valueOf("8ca9e8AA");
                        sizeFrom = 10f;
                        sizeTo = 0f;
                    }};
                    intervalBullets = 1;
                    intervalRandomSpread = 60;
                    bulletInterval = 2;
                    intervalBullet = new EmpBulletType(){{
                        width = height = 15f;
                        hitPowerEffect = hitEffect = Fx.none;
                        lifetime = 35f;
                        radius = 140;
                        hitColor = backColor = trailColor = Pal.techBlue;
                        frontColor = Color.white;
                        unitDamageScl = 0.1f;
                        trailWidth = 2.1f;
                        trailLength = 5;
                        despawnHit = true;
                        collides = false;
                        instantDisappear = true;
                        lightningColor = Pal.techBlue;
                        lightning = 3;
                        lightningDamage = 32;
                        lightningLength = 4;
                        lightningCone = 360;
                        lightningLengthRand = 7;
                        buildingDamageMultiplier = 0.3f;
                        fragBullets = 1;
                        fragLifeMin = 0.3f;
                        fragBullet = new BasicBulletType(6f, 130){{
                        parts.addAll(
                                new ShapePart(){{
                                    color = Color.white;
                                    circle = true;
                                    radius = radiusTo = 1.5f;
                                    layer = 114;
                                }},
                                new ShapePart(){{
                                    color = Color.valueOf("aec6ff");
                                    circle = true;
                                    radius = radiusTo = 3.5f;
                                    layer = Layer.effect;
                                }},
                                new ShapePart(){{
                                    color = Color.valueOf("8ca9e855");
                                    circle = true;
                                    radius = radiusTo = 5.5f;
                                    layer = Layer.effect;
                                }},
                                new ShapePart(){{
                                    color = Color.valueOf("597cff45");
                                    circle = true;
                                    radius = radiusTo = 6;
                                    layer = Layer.effect;
                                }}
                        );
                            width = height = 0f;
                            lifetime = 60f;
                            backColor = hitColor = trailColor = Pal.techBlue;
                            frontColor = Color.white;
                            hitSound = Sounds.explosion;
                            drag = 0.019f;
                            pierceBuilding = true;
                            pierceCap = 2;
                            pierce = despawnHit = true;
                            weaveMag = 2;
                            weaveScale = 8;
                            homingPower = 0.0002f;
                            homingRange = 100;
                            trailSinScl = 2.4f;
                            trailSinMag = 0.8f;
                            trailParam = 1.5f;
                            trailWidth = 2.5f;
                            trailLength = 9;
                            hitEffect = ExoFx.colorBombSmaller;
                        }};
                    }};
                    fragLifeMin = 0.2f;
                    fragBullets = 14;
                    fragBullet = new ArtilleryBulletType(5.4f, 32){{
                        buildingDamageMultiplier = 1.3f;
                        parts.addAll(
                            new FlarePart(){{
                                progress = PartProgress.life;
                                color1 = Pal.techBlue;
                                sides = 2;
                                stroke = 3.5f;
                                radius = radiusTo = 15;
                                layer = Layer.effect;
                            }}
                        );
                        hitEffect = new MultiEffect(Fx.massiveExplosion, Fx.scatheSlash);
                        despawnHit = true;
                        knockback = 0.8f;
                        lifetime = 30f;
                        width = height = 18f;
                        splashDamageRadius = 50f;
                        splashDamage = 100f;
                        backColor = trailColor = hitColor = Pal.techBlue;
                        frontColor = Color.white;
                        despawnShake = 7f;
                        lightRadius = 30f;
                        lightColor = Pal.techBlue;
                        lightOpacity = 0.5f;
                        trailLength = 20;
                        trailWidth = 3.5f;
                        trailEffect = Fx.none;
                    }};
                }};
            }});
            weapons.add(new Weapon("exogenesis-atlas-energy-mount") {{
                reload = 120f;
                mirror = rotate = true;
                shootCone = 45;
                cooldownTime = 80;
                layerOffset = 2;
                rotateSpeed = 2;
                x = 40;
                y = 1.5f;
                shoot = new ShootSpread() {{
                    shots = 3;
                    spread = 10;
                }};
                minWarmup = 0.85f;
                smoothReloadSpeed = 0.08f;
                shootWarmupSpeed = 0.02f;
                shootY = inaccuracy = 8;
                shootSound = Sounds.laser;
                recoil = 3.5f;
                shake = 1.8f;
                parts.addAll(
                new RegionPart("-front"){{
                    mirror = under = true;
                    layerOffset = -1;
                    outlineLayerOffset = 1;
                    moveX = 3;
                    progress = PartProgress.warmup;
                    moves.add(new PartMove(PartProgress.recoil, 0f, 0f, -8f));
                    moveRot = -13f;
                }},
                new RegionPart("-sink"){{
                    mirror = under = true;
                    moveX = 5;
                    moveY = -5;
                    healColor = Color.valueOf("7ba2f6");
                    progress = PartProgress.warmup;
                    moveRot = 4f;
                }},
                new RegionPart("-sink"){{
                    mirror = under = true;
                    layerOffset = -1;
                    moveX = 6;
                    moveY = -1;
                    healColor = Color.valueOf("7ba2f6");
                    progress = PartProgress.warmup;
                    moveRot = 26f;
                }},
                new RegionPart("-bottom"){{
                    mirror = under = true;
                    layerOffset = -2;
                    y = 3;
                    moveY = -3;
                    progress = PartProgress.warmup;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -4f, 0f));
                    moveRot = -13f;
                }}
                );
                bullet = new BasicBulletType(){{
                    shootEffect = Fx.shootBig;
                    hitColor = Pal.techBlue;
                    smokeEffect = Fx.shootSmokeMissile;
                    spawnUnit = new MissileUnitType("atlas-missile"){{
                        speed = 6;
                        maxRange = 15f;
                        lifetime = 105f;
                        targetable = false;
                        engineColor = trailColor = Pal.techBlue;
                        engineLayer = Layer.effect;
                        engineSize = 3f;
                        engineOffset = 6f;
                        rotateSpeed = 3.9f;
                        trailLength = 6;
                        homingDelay = 25;
                        outlines = drawCell = drawBody = false;
                        lowAltitude = true;
                        deathSound = Sounds.explosion;
                        fogRadius = 0f;
                        health = 100;
                        parts.addAll(
                                new FlarePart(){{
                                    progress = PartProgress.life.slope().curve(Interp.pow3Out);
                                    color1 = Pal.techBlue;
                                    stroke = 5.5f;
                                    radius = 0;
                                    radiusTo = 45;
                                    layer = Layer.effect;
                                }}
                        );
                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            deathExplosionEffect = shootEffect;
                            shootOnDeath = true;
                            shake = 2f;
                            bullet = new ExplosionBulletType(140f, 58f){{
                                hitColor = ExoPal.empyrean;
                                shootEffect = new MultiEffect(ExoFx.colorBombSmaller, new ExplosionEffect(){{
                                    waveColor = sparkColor = Pal.techBlue;
                                    smokes = 12;
                                    smokeSize = 4.7f;
                                    smokeSizeBase = 1.6f;
                                    waveLife = 10;
                                    waveStroke = 3.1f;
                                    waveRad = 65f;
                                    waveRadBase = 2;
                                    sparkLen = 5;
                                    sparks = 12;
                                }});
                                collidesGround = collidesAir = collidesTiles = true;
                                buildingDamageMultiplier = 0.6f;
                            }};
                        }});
                    }};
                }};
            }});
            weapons.add(new Weapon("exogenesis-atlas-blaster") {{
                reload = 80f;
                mirror = rotate = true;
                rotateSpeed = 1.5f;
                x = 55;
                y = -14.5f;
                shootSound = Sounds.bolt;
                shoot = new ShootPattern() {{
                    shots = 3;
                    shotDelay = 3.5f;
                }};
                shootCone = 15;
                layerOffset = 2.1f;
                shootY = 7;
                inaccuracy = 1.5f;
                recoil = 3;
                shake = 1f;
                bullet = new BasicBulletType(9f, 155){{
                    width = 11f;
                    height = 17f;
                    sprite = "circle-bullet";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = Pal.techBlue;
                    lifetime = 50f;
                    hitEffect = new ParticleEffect() {{
                        particles = 7;
                        line = true;
                        length = 65f;
                        lifetime = 35f;
                        offset = 50;
                        cone = 30;
                        colorFrom = Pal.techBlue;
                        colorTo = Pal.techBlue;
                        lenFrom = lenTo = 8f;
                    }};
                    shrinkY = shrinkX = 0;
                    shootEffect = Fx.lightningShoot;
                    buildingDamageMultiplier = 1.15f;
                    despawnHit = true;
                    trailLength = 10;
                    trailWidth = 3.5f;
                    trailChance = 0.3f;
                    trailEffect = new ParticleEffect() {{
                        particles = 13;
                        length = baseLength = 2.5f;
                        lifetime = 20f;
                        cone = 360;
                        colorFrom = Pal.techBlue;
                        colorTo = Pal.techBlue;
                        sizeFrom = 10f;
                        sizeTo = 0f;
                    }};
                }};
            }});
        }};
        nemesis = new ErekirUnitType("nemesis") {{
            constructor = UnitEntity::create;
            shadowElevation = 3f;
            fogRadius = 50;
            health = 46500;
            crashDamageMultiplier = 10;
            armor = 20f;
            speed = 0.88f;
            accel = 0.04f;
            drag = 0.04f;
            range = 200;
            flying = true;
            hitSize = lightRadius = 80f;
            engineSize = 0f;
            faceTarget = singleTarget = lowAltitude = true;
            abilities.add(new EnergyFieldAbility(25f, 45f, 380f){{
                statusDuration = 60f * 6f;
                maxTargets = 25;
            }});
            abilities.add(new RegenAbility(){{
                amount = 10f;
            }});
            abilities.add(new SuppressionFieldAbility(){{
                orbRadius = 5.3f;
                reload = 40;
                range = 150;
                layer = 109;
                x = 29;
                y = -16f;
            }});
            abilities.add(new SuppressionFieldAbility(){{
                orbRadius = 5.3f;
                reload = 40;
                range = 150;
                layer = 109;
                x = -29;
                y = -16f;
            }});
            parts.addAll(
            new HoverPart(){{
                color = Color.valueOf("a393fe");
                circles = 3;
                stroke = 0f;
                phase = 50;
                radius = 15;
                mirror = false;
                layer = Layer.effect;
                y = 25.5f;
            }},
            new RegionPart(){{
                color = Color.valueOf("9681fb");
                colorTo = Color.valueOf("9681fb");
                blending = Blending.additive;
                outline = mirror = false;
            }},
            new ShapePart(){{
                progress = PartProgress.recoil;
                color = Color.valueOf("a393fe");
                hollow = circle = mirror = true;
                stroke = strokeTo = 1.2f;
                radius = radiusTo = 8;
                layer = Layer.effect;
                x = 29;
                y = -16;
            }},
            new ShapePart(){{
                progress = PartProgress.recoil;
                color = Color.valueOf("a393fe");
                hollow = circle = mirror = true;
                stroke = strokeTo = 0.5f;
                radius = radiusTo = 5;
                layer = Layer.effect;
                x = 29;
                y = -16;
            }},
            new HaloPart(){{
                color = Color.valueOf("a393fe");
                tri = true;
                haloRotateSpeed = 1.7f;
                haloRadius = haloRadiusTo = 5f;
                stroke = strokeTo = 2f;
                shapes = 6;
                triLengthTo = triLength = 8;
                radius = 2f;
                layer = Layer.effect;
                x = 29;
                y = -16;
            }},
            new HaloPart(){{
                color = Color.valueOf("a393fe");
                tri = true;
                haloRotateSpeed = 0.7f;
                haloRadius = haloRadiusTo = 5f;
                stroke = strokeTo = 2f;
                shapes = 4;
                triLengthTo = triLength = 3;
                radius = 2.6f;
                layer = Layer.effect;
                x = 29;
                y = -16;
            }},
            new HaloPart(){{
                color = Color.valueOf("a393fe");
                tri = true;
                haloRotateSpeed = 0.6f;
                haloRadius = haloRadiusTo = 8f;
                stroke = strokeTo = 2f;
                shapes = 4;
                triLengthTo = triLength = 3;
                radius = 3f;
                layer = Layer.effect;
                x = 29;
                y = -16;
            }}
            );
            weapons.add(new Weapon("engine"){{
                mirror = alwaysContinuous = parentizeEffects = continuous = alwaysShooting = true;
                alternate = display = rotate = false;
                baseRotation = 180;
                x = 33;
                y = -39;
                shootY = 10;
                shootSound = Sounds.none;
                bullet = new ContinuousFlameBulletType(){{
                    damage = width = 4f;
                    layer = Layer.effect;
                    drawFlare = collides = false;
                    length = 27;
                    divisions = 20;
                    intervalBullets = 2;
                    intervalRandomSpread = 1;
                    bulletInterval = 2.7f;
                    intervalBullet = new BulletType(){{
                        despawnHit = true;
                        despawnEffect = Fx.none;
                        instantDisappear = true;
                        hitEffect = new ParticleEffect(){{
                            particles = 1;
                            line = true;
                            layer = 108;
                            length = 35f;
                            lifetime = 31f;
                            baseLength = 8;
                            cone = 20;
                            interp = Interp.circleOut;
                            colorFrom = colorTo = Color.valueOf("9681fb");
                            strokeFrom = 2;
                            lenFrom = 10;
                            lenTo = 0f;
                        }};
                    }};
                    colors = new Color[]{Color.valueOf("9681fb50"), Color.valueOf("9681fb"), Color.valueOf("bf92f9"), Color.white};
                }};
            }});
            weapons.add(new Weapon("engine2"){{
                mirror = alwaysContinuous = parentizeEffects = continuous = alwaysShooting = true;
                alternate = display = rotate = false;
                baseRotation = 224;
                x = 53;
                y = -35;
                shootY = 14;
                shootSound = Sounds.none;
                bullet = new ContinuousFlameBulletType(){{
                    damage = 4;
                    width = 5.3f;
                    layer = Layer.effect;
                    drawFlare = collides = false;
                    length = 20;
                    divisions = 20;
                    intervalBullets = 2;
                    intervalRandomSpread = 1;
                    bulletInterval = 2.7f;
                    intervalBullet = new BulletType(){{
                        despawnHit = true;
                        despawnEffect = Fx.none;
                        instantDisappear = true;
                        hitEffect = new ParticleEffect(){{
                            particles = 1;
                            line = true;
                            layer = 108;
                            length = 45f;
                            lifetime = 31f;
                            baseLength = 8;
                            cone = 25;
                            interp = Interp.circleOut;
                            colorFrom = colorTo = Color.valueOf("9681fb");
                            strokeFrom = 2;
                            lenFrom = 6;
                            lenTo = 0f;
                        }};
                    }};
                    colors = new Color[]{Color.valueOf("9681fb50"), Color.valueOf("9681fb"), Color.valueOf("bf92f9"), Color.white};
                }};
            }});
            weapons.add(new Weapon("exogenesis-big-missiles") {{
                reload = 230f;
                mirror = true;
                alternate = false;
                shootCone = 300;
                layerOffset = -1;
                x = 40;
                y = 1.5f;
                minWarmup = 0.85f;
                smoothReloadSpeed = 0.08f;
                shootWarmupSpeed = 0.02f;
                shootY = inaccuracy = 8;
                shootSound = Sounds.missileLaunch;
                recoil = 3.5f;
                shake = 1.8f;
                parts.addAll(
                new RegionPart("-missile"){{
                    mirror = false;
                    under = true;
                    layerOffset = -1;
                    outlineLayerOffset = 1;
                    progress = PartProgress.reload;
                    moveRot = -5f;
                }}
                );
                bullet = new BulletType(){{
                    shootEffect = smokeEffect = Fx.none;
                    spawnUnit = new MissileUnitType("big-thorium-missile"){{
                        speed = 5.6f;
                        maxRange = 15f;
                        hitSize = 20;
                        lifetime = 160f;
                        engineColor = trailColor = Color.valueOf("9681fb");
                        outlineColor = Color.valueOf("36363c");
                        engineLayer = Layer.effect;
                        engineSize = 5.3f;
                        engineOffset = 19f;
                        rotateSpeed = 0.9f;
                        missileAccelTime = 45;
                        trailLength = 22;
                        homingDelay = 5;
                        lowAltitude = true;
                        deathSound = Sounds.largeExplosion;
                        loopSound = Sounds.missileTrail;
                        loopSoundVolume = 0.6f;
                        fogRadius = 0f;
                        health = 800;
                        abilities.add(new MoveEffectAbility(){{
                            effect = Fx.missileTrailSmoke;
                            rotation = 180f;
                            rotateEffect = true;
                            y = -17f;
                            color = Color.grays(0.6f).lerp(Color.valueOf("9681fb"), 0.5f).a(0.4f);
                            interval = 3f;
                        }});
                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            deathExplosionEffect = shootEffect;
                            shootOnDeath = true;
                            shake = 4f;
                            bullet = new ExplosionBulletType(500f, 70f){{
                                shootEffect = Fx.reactorExplosion;
                                killShooter = true;
                                suppressionRange = 70;
                                suppressionDuration = 150;
                                status = StatusEffects.blasted;
                                statusDuration = 100;
                                hitSoundVolume = 5;
                                collidesGround = collidesAir = collidesTiles = true;
                                buildingDamageMultiplier = 0.8f;
                            }};
                        }});
                    }};
                }};
            }});
            weapons.add(new Weapon("exogenesis-nemesis-weapon"){{
                reload = 30f;
                rotate = mirror = false;
                x = 0;
                y = 0;
                layerOffset = -0.0001f;
                shoot = new ShootMulti(new ShootBarrel(){{
                barrels = new float[]{
                        42f, 65f, 0f,
                        -42f, 65f, 0f,
                        42f, 64f, 0f,
                        -42f, 64f, 0f,
                };
                }}, new ShootHelix(){{
                    shots = 2;
                    scl = 2.7f;
                    mag = 2f;
                }});
                shootSound = Sounds.mediumCannon;
                recoils = 4;
                recoil = shootY = shootX = 0;
                shake = 2f;
                parts.add(
                        new RegionPart("-barrel-1"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 1;
                            outlineLayerOffset = -0.0002f;
                            progress = PartProgress.recoil;
                            moveY = -3.5f;
                        }},
                        new RegionPart("-barrel-2"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 0;
                            outlineLayerOffset = -0.0002f;
                            progress = PartProgress.recoil;
                            moveY = -3.5f;
                        }},
                        new RegionPart("-barrel-3"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 3;
                            outlineLayerOffset = -0.0002f;
                            progress = PartProgress.recoil;
                            moveY = -3.5f;
                        }},
                        new RegionPart("-barrel-4"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 2;
                            outlineLayerOffset = -0.0002f;
                            progress = PartProgress.recoil;
                            moveY = -3.5f;
                        }}
                );
                bullet = new BasicBulletType(13.5f, 120){{
                    width = 15f;
                    height = 25f;
                    lifetime = 40f;
                    shootEffect = new MultiEffect(Fx.explosion, Fx.circleColorSpark);
                    shrinkY = shrinkX = 0;
                    hitEffect = new MultiEffect(Fx.sapExplosion, Fx.circleColorSpark, ExoFx.colorBombSmall);
                    despawnHit = true;
                    intervalRandomSpread = 50;
                    intervalBullets = 3;
                    intervalBullet = new LightningBulletType(){{
                        damage = 78;
                        lightningColor = Color.valueOf("9681fb");
                        lightningLength = 8;
                        lightningLengthRand = 11;
                        buildingDamageMultiplier = 0.25f;
                    }};
                    trailLength = 10;
                    trailWidth = 4.5f;
                    sprite = "missile-large";
                    hitColor = Color.valueOf("a393fe");
                    lightningColor = backColor = trailColor = Color.valueOf("a393fe");
                }};
            }});
        }};
        hyperion = new ErekirUnitType("hyperion") {{
            constructor = UnitEntity::create;
            speed = 0.78f;
            hitSize = 90f;
            health = 32000f;
            faceTarget = true;
            fogRadius = 50;
            armor = 45;

            hovering = singleTarget = flying = true;
            shadowElevation = 0.1f;
            rotateSpeed = 0.8f;
                //small
                parts.add(new HoverPart(){{
                    x = 48f;
                    y = 25;
                    mirror = true;
                    radius = 9f;
                    phase = 30f;
                    layerOffset = -0.001f;
                    color = Pal.surge;
                }});
                parts.add(new HoverPart(){{
                    x = 48f;
                    y = -25;
                    mirror = true;
                    radius = 9f;
                    phase = 30f;
                    layerOffset = -0.001f;
                    color = Pal.surge;
                }});
                //large
                parts.add(new HoverPart(){{
                    x = 26f;
                    y = 49;
                    mirror = true;
                    radius = 19f;
                    circles = 4;
                    phase = 90f;
                    layerOffset = -0.001f;
                    color = Pal.surge;
                }});
                parts.add(new HoverPart(){{
                    x = 26f;
                    y = -49;
                    mirror = true;
                    radius = 19f;
                    circles = 4;
                    phase = 90f;
                    layerOffset = -0.001f;
                    color = Pal.surge;
                }});
            weapons.add(new Weapon("exogenesis-hyperion-weapon"){{
                shootSound = Sounds.shootBig;
                top = rotate = true;
                mirror = false;
                shake = 14f;
                shootY = 5f;
                x = y = 0;
                reload = 11;
                recoil = 0f;
                recoils = 4;
                layerOffset = 2;
                cooldownTime = 250f;
                rotateSpeed = 1;
                parts.add(
                        new RegionPart("-barrel-1"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 3;
                            cooldownTime = 50;
                            heatProgress = PartProgress.recoil.add(0.2f);
                            progress = PartProgress.recoil;
                            moveY = -6f;
                        }},
                        new RegionPart("-barrel-2"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 2;
                            cooldownTime = 50;
                            heatProgress = PartProgress.recoil.add(0.2f);
                            progress = PartProgress.recoil;
                            moveY = -6f;
                        }},
                        new RegionPart("-barrel-3"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 1;
                            cooldownTime = 50;
                            heatProgress = PartProgress.recoil.add(0.2f);
                            progress = PartProgress.recoil;
                            moveY = -6f;
                        }},
                        new RegionPart("-barrel-4"){{
                            mirror = false;
                            under = true;

                            recoilIndex = 0;
                            cooldownTime = 50;
                            heatProgress = PartProgress.recoil.add(0.2f);
                            progress = PartProgress.recoil;
                            moveY = -6f;
                        }}
                );
                shoot = new ShootBarrel(){{
                    barrels = new float[]{
                    19f, 48f, 0f,
                    6.25f, 48f, 0f,
                    -6.25f, 48f, 0f,
                    -19f, 48f, 0f,
                    };
                }};
                bullet = new EmpBulletType() {{
                    sprite = "missile-large";
                    width = 12f;
                    height = 36f;
                    speed = 13;
                    damage = 550;
                    lifetime = 32f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = new ParticleEffect(){{
                        particles = 8;
                        line = true;
                        length = 60f;
                        lifetime = 40f;
                        baseLength = 8;
                        cone = offset = 30;
                        interp = Interp.circleOut;
                        colorFrom = colorTo = Pal.surge;
                        strokeFrom = 4;
                        lenFrom = lenTo = 6f;
                    }};
                    shootEffect = new MultiEffect(Fx.blastExplosion, Fx.flakExplosionBig, Fx.massiveExplosion);
                    hitEffect = new MultiEffect(Fx.blastExplosion, Fx.colorSparkBig, Fx.shootBigColor);
                    despawnHit = true;
                    shrinkY = shrinkX = 0;
                    hitPowerEffect = chainEffect = Fx.none;
                    pierceCap = 1;
                    pierceArmor = true;
                    pierceBuilding = false;
                    unitDamageScl = 1.5f;
                    buildingDamageMultiplier = 0.3f;
                    bulletInterval = 1;
                    intervalBullets = 2;
                    intervalRandomSpread = 30;
                    intervalBullet = new LightningBulletType(){{
                        damage = 30;
                        ammoMultiplier = 1f;
                        collidesTiles = false;
                        lightningColor = Pal.surge;
                        lightningLength = 3;
                        lightningLengthRand = 5;
                        buildingDamageMultiplier = 0.2f;
                    }};
                    radius = 0;
                    trailChance = 1;
                    trailRotation = true;
                    trailInterval = 5f;
                    trailLength = 12;
                    trailWidth = 4f;
                    trailEffect = Fx.shootHealYellow;
                    lightning = 2;
                    lightningLength = 3;
                    lightningLengthRand = 6;
                    lightningColor = backColor = trailColor = hitColor = Pal.surge;
                    lightningDamage = 50;
                }};
            }});
            weapons.add(new Weapon("exogenesis-hyperion-flak-turret"){{
                x = 18f;
                y = -27f;
                rotateSpeed = 2.5f;
                reload = 6f;
                shootSound = Sounds.shootBig;
                ejectEffect = Fx.casing2;
                rotationLimit = 60;
                cooldownTime = 80;
                shootCone = 40;
                layerOffset = 1;
                shadow = 7f;
                rotate = true;
                mirror = true;
                alternate = false;
                shake = 1.8f;
                recoils = 2;
                recoil = 0f;
                parts.add(
                        new RegionPart("-barrel-1"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 1;
                            progress = PartProgress.recoil;
                            moveY = -5f;
                        }},
                        new RegionPart("-barrel-2"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 0;
                            progress = PartProgress.recoil;
                            moveY = -5f;
                        }}
                );
                shoot = new ShootBarrel(){{
                    barrels = new float[]{
                            3.5f, 15f, 0f,
                            -3.5f, 15f, 0f,
                    };
                }};
                bullet = new BasicBulletType(7f, 60){{
                    width = 11f;
                    height = 20f;
                    lifetime = 45f;
                    shootEffect = Fx.shootBig;
                    trailLength = 6;
                    trailWidth = 2f;
                }};
            }});
        }};
        rhea = new ErekirUnitType("rhea") {{
            constructor = UnitEntity::create;
            defaultCommand = UnitCommand.repairCommand;
            buildSpeed = 2.6f;
            buildBeamOffset = 30;
            shadowElevation = 2f;
            health = 76500f;
            lightRadius = 80;
            fogRadius = 50;
            armor = 16f;
            speed = 1.4f;
            accel = 0.04f;
            drag = 0.04f;
            flying = true;
            fallSpeed = 0.006f;
            crashDamageMultiplier = 20;
            hitSize = 100f;
            engineColor = Color.valueOf("fc81de");
            engineOffset = 58;
            engineSize = 9.5f;
            faceTarget = true;
            singleTarget = true;
            lowAltitude = true;
            immunities.add(StatusEffects.burning);
            parts.addAll(
                    new RegionPart("-glow"){{
                        mirror = false;
                        under = true;
                        layer = -1;
                        color = colorTo = Color.valueOf("8400ff");
                        blending = Blending.additive;
                        outline = false;
                        progress = PartProgress.warmup;
                    }},
                    new HoverPart(){{
                        color = ExoPal.erekirPink;
                        circles = 3;
                        phase = 100;
                        radius = 48f;
                        mirror = false;
                        layer = Layer.effect;
                        y = 14.25f;
                    }}
                    );
            setEnginesMirror(
                    new UnitEngine(28, -56, 5, 270),
                    new UnitEngine(-28, -56, 5, 270)
            );
            weapons.add(new Weapon("Rhea-energy-ball"){{
                x = 18f;
                y = -27f;
                shootCone = 25;
                reload = 500;
                shootSound = ExoSounds.bigLaserShoot;
                shootY = 0f;
                rotateSpeed = 5;
                rotate = true;
                minWarmup = 0.8f;
                smoothReloadSpeed = 0.15f;
                recoil = 0.5f;
                parts.addAll(
                        new ShapePart() {{
                            circle = true;
                            layer = 114;
                            radiusTo = 0;
                            radius = 9;
                            color = Color.white;
                            progress = PartProgress.reload;
                        }},
                        new ShapePart() {{
                            circle = true;
                            layer = 114;
                            radiusTo = 0;
                            radius = 13;
                            color = Color.valueOf("ffcbdd");
                            progress = PartProgress.reload;
                        }},
                        new ShapePart() {{
                            circle = true;
                            layer = 114;
                            radiusTo = 0;
                            radius = 16;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.reload;
                        }},
                        new RegionPart("-pew") {{
                            mirror = false;
                            under = true;
                            growY = 12;
                            growX = 50;
                            y = 12;
                            x = 16;
                            layer = 110;
                            color = ExoPal.erekirPink;
                            colorTo = Color.valueOf("d370d300");
                            blending = Blending.additive;
                            outline = false;
                            progress = PartProgress.warmup;
                        }},
                        //main
                        new HaloPart() {{
                            tri = true;
                            y = 12;
                            radius = 7.6f;
                            layer = Layer.effect;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = 10;
                            triLengthTo = 43;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }},
                        new HaloPart() {{
                            tri = true;
                            shapeRotation = 180;
                            y = 12;
                            radius = 7.6f;
                            layer = Layer.effect;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = triLengthTo = 4;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }},
                        //sides
                        new HaloPart() {{
                            tri = true;
                            y = 12;
                            radius = 5.6f;
                            layer = Layer.effect;
                            haloRotation = 33;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = 6;
                            triLengthTo = 23;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }},
                        new HaloPart() {{
                            tri = true;
                            y = 12;
                            radius = 5.6f;
                            layer = Layer.effect;
                            haloRotation = 33;
                            shapeRotation = 180;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = triLengthTo = 4;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }},
                        //sides
                        new HaloPart() {{
                            tri = true;
                            y = 12;
                            radius = 5.6f;
                            layer = Layer.effect;
                            haloRotation = -33;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = 6;
                            triLengthTo = 23;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }},
                        new HaloPart() {{
                            tri = true;
                            y = 12;
                            radius = 5.6f;
                            layer = Layer.effect;
                            haloRotation = 33;
                            shapeRotation = 180;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = 6;
                            triLengthTo = 23;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }},
                        //sides2
                        new HaloPart() {{
                            tri = true;
                            y = 12;
                            radius = 4.3f;
                            layer = Layer.effect;
                            haloRotation = -60;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = 0;
                            triLengthTo = 10;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }},
                        new HaloPart() {{
                            tri = true;
                            y = 12;
                            radius = 4.3f;
                            layer = Layer.effect;
                            haloRotation = -60;
                            shapeRotation = 180;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = 0;
                            triLengthTo = 10;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }},
                        //sides2
                        new HaloPart() {{
                            tri = true;
                            y = 12;
                            radius = 4.3f;
                            layer = Layer.effect;
                            haloRotation = 60;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = 0;
                            triLengthTo = 10;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }},
                        new HaloPart() {{
                            tri = true;
                            y = 12;
                            radius = 4.3f;
                            layer = Layer.effect;
                            haloRotation = 60;
                            shapeRotation = 180;
                            haloRadius = haloRadiusTo = 12;
                            strokeTo = 2;
                            shapes = 1;
                            triLength = 0;
                            triLengthTo = 10;
                            color = ExoPal.erekirPink;
                            progress = PartProgress.warmup;
                        }}
                        );
                bullet = new BasicBulletType(4f, 70){{
                    parts.addAll(
                            new ShapePart() {{
                                circle = true;
                                layer = 114;
                                radiusTo = 0;
                                radius = 9;
                                color = Color.white;
                                progress = PartProgress.reload;
                            }},
                            new ShapePart() {{
                                circle = true;
                                layer = Layer.effect;
                                radiusTo = 0;
                                radius = 13;
                                color = Color.valueOf("ffcbdd");
                                progress = PartProgress.reload;
                            }},
                            new ShapePart() {{
                                circle = true;
                                layer = Layer.effect;
                                radiusTo = 0;
                                radius = 16;
                                color = ExoPal.erekirPink;
                                progress = PartProgress.reload;
                            }},
                            new HoverPart(){{
                                color = ExoPal.erekirPink;
                                circles = 3;
                                phase = 100;
                                radius = 48f;
                                mirror = false;
                                layer = Layer.effect;
                                y = 14.25f;
                            }}
                            );
                    lightRadius = 40;
                    hitColor = trailColor = ExoPal.erekirPink;
                    trailLength = 26;
                    trailWidth = 9;
                    scaleLife = true;
                    collidesGround = collidesTiles = collidesAir = false;
                    width = height = 0;
                    despawnEffect = new MultiEffect(ExoFx.explodeyscathe, ExoFx.colorBomb,
                    new ParticleEffect(){{
                        lightOpacity = 0.5f;
                        line = true;
                        particles = 35;
                        length = 275;
                        offset = 40;
                        strokeFrom = 5;
                        strokeTo = 0;
                        lifetime = 160;
                        lenFrom = 20;
                        lenTo = 10;
                        lightColor = colorFrom = Color.valueOf("ffcbdd");
                        colorTo = ExoPal.erekirPink;
                    }});
                    hitSound = Sounds.largeExplosion;
                    splashDamage = 1276;
                    splashDamageRadius = 100;
                    scaledSplashDamage = true;
                    trailSinScl = 2;
                    trailSinMag = 1.2f;
                    trailChance = 0.3f;
                    trailParam = 3.5f;
                    lifetime = 160f;
                    shootEffect = ExoFx.explodeyscathe;
                    bulletInterval = 3;
                    intervalRandomSpread = 60;
                    intervalBullet = new BasicBulletType(7, 50){{
                        parts.addAll(
                                new ShapePart() {{
                                    circle = true;
                                    layer = 114;
                                    radiusTo = radius = 1;
                                    color = Color.white;
                                }},
                                new ShapePart() {{
                                    circle = true;
                                    layer = Layer.effect;
                                    radiusTo = radius = 2;
                                    color = Color.valueOf("ffcbdd");
                                }},
                                new ShapePart() {{
                                    circle = true;
                                    layer = Layer.effect;
                                    radiusTo = radius = 3;
                                    color = ExoPal.erekirPink;
                                }}
                        );
                        hitSound = Sounds.explosion;
                        hitColor = trailColor = ExoPal.erekirPink;
                        pierceBuilding = pierce = true;
                        pierceCap = 2;
                        homingPower = 0.002f;
                        homingRange = 100;
                        lifetime = 60;
                        width = height = 1;
                        drag = 0.029f;
                        weaveMag = 40;
                        weaveScale = -5;
                        trailSinScl = 2;
                        trailSinMag = 0.8f;
                        trailLength = 26;
                        trailWidth = 9;
                        despawnHit = true;
                        hitEffect = ExoFx.colorBombSmaller;
                    }};
                }};
            }});
        }};
        ursa = new UnitType("ursa") {{
            constructor = LegsUnit::create;
            speed = 0.27f;
            hitSize = 37f;
            health = 37000f;
            faceTarget = true;
            armor = 10;
            shadowElevation = 0.23f;
            targetAir = false;
            allowLegStep = true;
            hovering = true;

            legPhysicsLayer = false;
            legGroupSize = 3;
            legCount = 6;
            legContinuousMove = true;
            rippleScale = 1.2f;
            stepShake = 1.5f;
            rotateSpeed = 1.3f;
            legLength = 29f;
            legBaseOffset = 12f;
            legMoveSpace = 0.7f;

            groundLayer = Layer.legUnit;
            weapons.add(new Weapon("ursa-weapon"){{
                shootSound = Sounds.laserblast;
                chargeSound = Sounds.lasercharge;
                soundPitchMin = 1f;
                top = false;
                mirror = false;
                shake = 14f;
                shootY = 5f;
                x = y = 0;
                reload = 350f;
                recoil = 0f;

                cooldownTime = 350f;

                shootStatusDuration = 60f * 2f;
                shootStatus = StatusEffects.unmoving;
                shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                parentizeEffects = true;

                bullet = new DelayedPointBulletType(){{
                    damage = 1060f;
                    width = 75f;
                    delayEffectLifeTime = lifetime = 0f;
                    rangeOverride = 660;
                    trailEffect = Fx.none;
                    lightning = 7;
                    lightningLength = 15;
                    lightningLengthRand = 35;
                    lightningDamage = 50;
                    lightColor = hitColor = lightningColor = Pal.heal;
                    chargeEffect = Fx.greenLaserCharge;
                    hitEffect = despawnEffect = new MultiEffect(ExoFx.empyreanExplosion);
                    healPercent = 25f;
                    collidesTeam = true;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                }};
            }});
        }};
        avicularia = new UnitType("avicularia"){{
            groundLayer = Layer.legUnit;
            constructor = LegsUnit::create;
            drag = 0.1f;
            speed = 0.42f;
            hitSize = 35.5f;
            health = 52000;
            rotateSpeed = 1.3f;
            legContinuousMove = true;
            legCount = 8;
            legMoveSpace = 0.76f;
            legPairOffset = 0.7f;
            legGroupSize = 2;
            legLength = 112f;
            legExtension = -8.25f;
            legBaseOffset = 8f;
            stepShake = 2.4f;
            legLengthScl = 1f;
            rippleScale = 2f;
            legSpeed = 0.2f;

            legSplashDamage = 80f;
            legSplashRange = 40f;
            hovering = true;
            armor = 13f;
            allowLegStep = true;
            shadowElevation = 0.95f;
            weapons.add(new Weapon("exogenesis-sap-energy-gun") {{
                    reload = 22f;
                    mirror = true;
                    rotate = true;
                    rotateSpeed = 2;
                    x = 19;
                    y = 3;
                    shoot = new ShootSpread() {{
                        spread = 6f;
                        shots = 3;
                    }};
                    shootSound = Sounds.laser;
                    recoil = 2;
                    shake = 1f;
                    bullet = new LaserBulletType() {{
                        damage = 115f;
                        sideWidth = 0f;
                        sideLength = 0f;
                        lightningSpacing = 17f;
                        lightningDelay = 0.12f;
                        lightningDamage = 10f;
                        lightningLength = 4;
                        lightningLengthRand = 2;
                        lightningAngleRand = 15f;
                        width = 25f;
                        length = 140f;
                        hitColor = lightningColor = Pal.sapBullet;
                        shootEffect = ExoFx.colorBombSmall;
                        colors = new Color[]{Pal.sapBulletBack.cpy().a(0.4f), Pal.sapBullet, Color.white};
                    }};
            }});
            weapons.add(new Weapon("exogenesis-avicularia-weapon") {{
                reload = 100f;
                mirror = false;
                x = 0;
                y = -17;
                shootSound = Sounds.torch;
                shootY = 21;
                recoil = 2;
                rotateSpeed = 2;
                rotate = continuous = alwaysContinuous = true;
                shake = 1f;
                bullet = new ContinuousLaserBulletType(){{
                    hitColor = Pal.sapBullet;
                    damage = 35f;
                    length = 220f;
                    hitEffect = ExoFx.hitMeltColor;
                    drawSize = 420f;
                    width = 8.6f;
                    shake = 1f;
                    largeHit = true;
                    colors = new Color[]{Pal.sapBulletBack.cpy().a(0.4f), Pal.sapBullet, Color.white};
                    despawnEffect = Fx.smokeCloud;
                    intervalBullet = new LightningBulletType(){{
                        damage = 30;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = Pal.sapBullet;
                        lightningLength = 20;
                        lightningLengthRand = 28;
                    }};
                    intervalRandomSpread = 20;
                    intervalBullets = 2;
                    bulletInterval = 4f;
                    smokeEffect = Fx.none;
                    shootEffect = Fx.none;
                }};
            }});
    }};
        twilight = new UnitType("twilight") {{
            constructor = UnitEntity::create;
            shadowElevation = 1.3f;
            health = 54000f;
            armor = 17f;
            speed = 0.45f;
            accel = 0.04f;
            drag = 0.04f;
            flying = true;
            hitSize = 80f;
            engineOffset = 46.75f;
            engineSize = 5.75f;
            faceTarget = true;
            lowAltitude = true;
            weapons.add(new Weapon("exogenesis-twilight-mount"){{
                reload = 10f;
                mirror = true;
                alternate = false;
                rotate = true;
                rotationLimit = 90;
                layerOffset = 1;
                rotateSpeed = 2.5f;
                x = 27;
                y = -14;
                shootY = 13;
                inaccuracy = 2;
                shoot = new ShootMulti(new ShootAlternate(){{
                spread = 4f;
                }}, new ShootPattern(){{
                    shots = 2;
                    shotDelay = 2f;
                }});
                shootSound = Sounds.shootBig;
                recoil = 4;
                shake = 1f;
                bullet = new BasicBulletType(9f, 90){{
                width = 11f;
                height = 20f;
                lifetime = 42f;
                shootEffect = Fx.shootBig;
                trailLength = 6;
                trailWidth = 2f;
                lightning = 2;
                lightningLength = 6;
                lightningColor = Pal.surge;
                lightningDamage = 20;
                }};
            }},
            new Weapon("exogenesis-heavy-gunner"){{
                x = 18f;
                y = -27f;
                rotateSpeed = 3f;
                reload = 9f;
                shootSound = Sounds.shoot;
                shadow = 7f;
                rotate = true;
                recoil = 0.5f;
                shootY = 7.25f;
                bullet = new BasicBulletType(7f, 70){{
                    width = 11f;
                    height = 20f;
                    lifetime = 45f;
                    shootEffect = Fx.shootBig;
                    trailLength = 6;
                    trailWidth = 2f;
                }};
            }}, new Weapon("exogenesis-heavy-gunner"){{
                x = 14f;
                y = 20f;
                rotateSpeed = 3f;
                reload = 9f;
                shootSound = Sounds.shoot;
                shadow = 7f;
                rotate = true;
                recoil = 0.5f;
                shootY = 7.25f;
                bullet = new BasicBulletType(7f, 70){{
                    width = 11f;
                    height = 20f;
                    lifetime = 45f;
                    shootEffect = Fx.shootBig;
                    trailLength = 6;
                    trailWidth = 2f;
                }};
            }});
        }};
        notodoris = new UnitType("notodoris") {{
            constructor = UnitWaterMove::create;
            trailLength = 70;
            waveTrailX = 23f;
            waveTrailY = -39f;
            trailScl = 3.5f;
            health = 54000f;
            omniMovement = true;
            armor = 17f;
            speed = 0.56f;
            accel = 0.2f;
            drag = 0.4f;
            hitSize = 80f;
            rotateSpeed = 1f;
            faceTarget = false;
            weapons.add(new Weapon("exogenesis-notodoris-mount"){{
                reload = 6f;
                mirror = true;
                alternate = false;
                rotate = true;
                rotateSpeed = 2.5f;
                x = 27;
                y = -7;
                layerOffset = 1;
                inaccuracy = 1;
                recoils = 2;
                shootY = 16;
                shoot = new ShootAlternate(){{
                spread = 8f;
                }};
                shootSound = Sounds.bolt;
                recoil = 1;
                shake = 1f;
                parts.add(
                new RegionPart("-barrel-1"){{
                    mirror = false;
                    under = true;
                    recoilIndex = 1;
                    progress = PartProgress.recoil;
                    moveY = -4f;
                }},
                new RegionPart("-barrel-2"){{
                    mirror = false;
                    under = true;
                    recoilIndex = 0;
                    progress = PartProgress.recoil;
                    moveY = -4f;
                }}
                );
                bullet = new EmpBulletType(){{
                    width = 17f;
                    height = 28f;
                    speed = 9;
                    damage = 170;
                    lifetime = 32f;
                    shootEffect = Fx.shootBig;
                    shrinkY = shrinkX = 0;
                    trailEffect = new Effect(13f, e -> {
                        color(Pal.heal);
                        for(int s : Mathf.signs){
                        Drawf.tri(e.x, e.y, 2.5f, 14f * e.fslope(), e.rotation + 90f*s);
                        }
                    });
                    healAmount = 100;
                    radius = 30;
                    unitDamageScl = 0.3f;
                    trailRotation = true;
                    trailInterval = 2f;
                    trailLength = 6;
                    trailWidth = 2.6f;
                    lightning = 2;
                    lightningLength = 6;
                    lightningColor = backColor = trailColor = hitColor = Pal.heal;
                    lightningDamage = 20;
            }};
            }});
            weapons.add(new Weapon("torpedo") {{
                reload = 10f;
                mirror = true;
                alternate = false;
                x = 30;
                y = -12;
                baseRotation = -90;
                shootCone = 180;
                shoot = new ShootAlternate(){{
                    barrels = 7;
                    shots = 3;
                    spread = 2;
                }};
                shootSound = Sounds.mineDeploy;
                showStatSprite = false;
                shake = 1f;
                bullet = new BasicBulletType(2f, 75){{
                    width = height = 16f;
                    sprite = "mine-bullet";
                    maxRange = 50f;
                    ignoreRotation = true;
                    hitSound = Sounds.plasmaboom;
                    layer = Layer.scorch;
                    inaccuracy = 2f;
                    splashDamageRadius = splashDamage = 25;
                    spin = 2;
                    weaveMag = 2f;
                    weaveScale = 4f;
                    drag = -0.017f;
                    homingPower = 0.05f;
                    collideFloor = true;
                    ejectEffect = Fx.none;
                    hitSize = 22f;
                    collidesAir = false;
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = Pal.heal;
                    lifetime = 86f;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = new MultiEffect(Fx.blastExplosion, Fx.greenCloud);
                    shootEffect = ExoFx.colorSparkShoot;
                    trailLength = 10;
                    trailWidth = 2f;
                }};
            }});
        }};
        lux = new UnitType("lux") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 3;
            speed = 4.8f;
            hitSize = 10f;
            health = 460f;
            flying = true;
            drag = 0.08f;
            accel = 0.09f;
            drawCell = false;
            faceTarget = true;
            circleTarget = true;
            lowAltitude = true;
            armor = 2;
            engineLayer = Layer.effect;
            trailLength = 8;
            trailColor = ExoPal.empyrean;
            rotateSpeed = 4.7f;
            engineSize = 2.7f;
            engineOffset = 0;
            weapons.add(new Weapon("lux") {{
                reload = 40f;
                mirror = false;
                x = 0;
                shoot = new  ShootHelix(){{
                    mag = 5.5f;
                    scl = 2f;
                }};
                shootSound = Sounds.bolt;
                showStatSprite = false;
                recoil = 0;
                shake = 1f;
                parts.add(
                        new ShapePart() {{
                            mirror = false;
                            progress = PartProgress.warmup;
                            circle = true;
                            layer = Layer.effect;
                            y = 0f;
                            color = ExoPal.empyrean;
                            stroke = strokeTo = 1f;
                            radiusTo = radius = 3f;
                        }},
                        new ShapePart() {{
                            mirror = false;
                            progress = PartProgress.warmup;
                            circle = true;
                            layer = Layer.effect;
                            y = 0f;
                            color = Color.white;
                            radiusTo = radius = 1.5f;
                        }},
                        new HaloPart() {{
                            y = 0f;
                            radius = 1.5f;
                            tri = true;
                            color = ExoPal.empyrean;
                            layer = Layer.effect;
                            haloRotateSpeed = -2.5f;
                            haloRadius = haloRadiusTo = 3f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = triLength = 4f;
                        }},
                        new HaloPart() {{
                            y = 0f;
                            radius = 1.5f;
                            tri = true;
                            color = ExoPal.empyrean;
                            layer = Layer.effect;
                            haloRotateSpeed = 2.5f;
                            haloRadius = haloRadiusTo = 3f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = triLength = 4f;
                        }}
                );
                bullet = new BasicBulletType(8f, 15){{
                    width = 7f;
                    height = 13f;
                    sprite = "missile";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    lifetime = 16f;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    shootEffect = ExoFx.colorSparkShoot;
                    trailLength = 10;
                    trailWidth = 2f;
                }};
            }});
        }};
        glimmer = new UnitType("glimmer") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 3;
            speed = 3.4f;
            hitSize = 16f;
            health = 860f;
            flying = true;
            drag = 0.08f;
            accel = 0.09f;
            faceTarget = true;
            lowAltitude = true;
            armor = 3;
            engineLayer = Layer.effect;
            trailLength = 8;
            trailColor = ExoPal.empyrean;
            rotateSpeed = 4.4f;
            engineSize = 3;
            engineOffset = 4;
            parts.add(
                    new ShapePart() {{
                        mirror = false;
                        progress = PartProgress.warmup;
                        circle = true;
                        layer = Layer.effect;
                        y = -4f;
                        color = ExoPal.empyrean;
                        radiusTo = radius = 3f;
                    }},
                    new ShapePart() {{
                        mirror = false;
                        progress = PartProgress.warmup;
                        circle = true;
                        layer = Layer.effect;
                        y = -4f;
                        color = Color.white;
                        radiusTo = radius = 1.5f;
                    }},
                    new HaloPart() {{
                        y = -4f;
                        radius = 1.8f;
                        tri = true;
                        color = ExoPal.empyrean;
                        layer = Layer.effect;
                        haloRotateSpeed = -2.5f;
                        haloRadius = haloRadiusTo = 3f;
                        stroke = 0f;
                        strokeTo = 2f;
                        shapes = 2;
                        triLengthTo = triLength = 4f;
                    }},
                    new HaloPart() {{
                        y = -4f;
                        radius = 1.8f;
                        tri = true;
                        color = ExoPal.empyrean;
                        layer = Layer.effect;
                        haloRotateSpeed = 2.5f;
                        haloRadius = haloRadiusTo = 3f;
                        stroke = 0f;
                        strokeTo = 2f;
                        shapes = 2;
                        triLengthTo = triLength = 4f;
                    }}
            );
            weapons.add(new Weapon("glimmer") {{
                reload = 5f;
                mirror = true;
                x = 4;
                y = 3;
                shootSound = Sounds.bolt;
                showStatSprite = false;
                recoil = 0;
                shake = 1f;
                bullet = new BasicBulletType(9f, 12){{
                    width = 8f;
                    height = 17f;
                    sprite = "missile";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    lifetime = 10f;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    shrinkY = shrinkX = 0;
                    shootEffect = Fx.shootSmallColor;
                    trailLength = 10;
                    trailWidth = 2f;
                    fragOnHit = false;
                    fragRandomSpread = 0f;
                    fragSpread = 10f;
                    fragBullets = 3;
                    fragVelocityMin = 1f;

                    fragBullet = new BasicBulletType(8f, 9){{
                        sprite = "missile";
                        width = 7f;
                        height = 13f;
                        lifetime = 7f;
                        hitSize = 4f;
                        backColor = hitColor = trailColor = ExoPal.empyrean;
                        frontColor = Color.white;
                        trailWidth = 2f;
                        trailLength = 6;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                    }};
                }};
            }});
        }};
        shine = new UnitType("shine") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 3;
            speed = 4f;
            hitSize = 15f;
            health = 1160f;
            flying = true;
            drag = 0.06f;
            accel = 0.09f;
            faceTarget = true;
            lowAltitude = true;
            armor = 5;
            trailLength = 8;
            trailColor = ExoPal.empyrean;
            rotateSpeed = 4.7f;
            engineSize = 0;
            engineOffset = 0;
            setEnginesMirror(
            new UnitEngine(4.5f, -9, 2f, 315f)
            );
            weapons.add(new Weapon("shine") {{
                reload = 60f;
                mirror = false;
                x = 0;
                shoot = new  ShootPattern(){{
                    shotDelay = 2f;
                    shots = 3;
                }};
                shootSound = Sounds.malignShoot;
                showStatSprite = false;
                recoil = 0;
                shake = 1f;
                parts.add(
                        new ShapePart() {{
                            mirror = false;
                            progress = PartProgress.warmup;
                            circle = true;
                            layer = Layer.effect;
                            y = 0f;
                            color = ExoPal.empyrean;
                            radiusTo = radius = 4.5f;
                        }},
                        new ShapePart() {{
                            mirror = false;
                            progress = PartProgress.warmup;
                            circle = true;
                            layer = Layer.effect;
                            y = 0f;
                            color = Color.white;
                            radiusTo = radius = 3f;
                        }},
                        new HaloPart() {{
                            y = 0f;
                            radius = 2f;
                            tri = true;
                            color = ExoPal.empyrean;
                            layer = Layer.effect;
                            haloRotateSpeed = -2.5f;
                            haloRadius = haloRadiusTo = 4.5f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = triLength = 4f;
                        }},
                        new HaloPart() {{
                            y = 0f;
                            radius = 2f;
                            tri = true;
                            color = ExoPal.empyrean;
                            layer = Layer.effect;
                            haloRotateSpeed = 2.5f;
                            haloRadius = haloRadiusTo = 4.5f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 3;
                            triLengthTo = triLength = 5.5f;
                        }}
                );
                bullet = new BasicBulletType(8f, 45){{
                    width = height = 10f;
                    sprite = "circle-bullet";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    hitEffect = despawnEffect = ExoFx.colorBombSmall;
                    lifetime = 35f;
                    weaveMag = 3;
                    weaveScale = 2;
                    shrinkY = shrinkX = 0;
                    trailEffect = new Effect(13f, e -> {
                        color(ExoPal.empyrean);
                        for(int s : Mathf.signs){
                            Drawf.tri(e.x, e.y, 2.5f, 14f * e.fslope(), e.rotation + 90f*s);
                        }
                    });
                    trailRotation = true;
                    trailInterval = 3f;
                    lightning = 4;
                    lightningLength = 6;
                    lightningColor = ExoPal.empyrean;
                    lightningDamage = 11;
                    shootEffect = ExoFx.colorSparkShoot;
                    trailLength = 10;
                    trailWidth = 3f;
                }};
            }});
        }};
        auric = new UnitType("auric") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 3;
            speed = 2.4f;
            hitSize = 40f;
            health = 5650f;
            flying = true;
            drag = 0.07f;
            accel = 0.04f;
            faceTarget = true;
            lowAltitude = true;
            armor = 8;
            trailLength = 8;
            trailColor = engineColor = ExoPal.empyrean;
            rotateSpeed = 2.6f;
            engineSize = 0;
            engineOffset = 0;
            setEnginesMirror(
                    new UnitEngine(19.5f, -18, 5f, 315f),
                    new UnitEngine(9.5f, -25, 3f, 315f)
            );
            weapons.add(new Weapon("auric") {{
                reload = 80f;
                mirror = false;
                x = 0;
                shootSound = Sounds.malignShoot;
                showStatSprite = false;
                recoil = 0;
                shake = 1f;
                parts.add(
                        new ShapePart() {{
                            mirror = false;
                            progress = PartProgress.warmup;
                            circle = true;
                            layer = Layer.effect;
                            y = 0f;
                            color = ExoPal.empyrean;
                            radiusTo = radius = 11f;
                        }},
                        new ShapePart() {{
                            mirror = false;
                            progress = PartProgress.warmup;
                            circle = true;
                            layer = Layer.effect;
                            y = 0f;
                            color = Color.white;
                            radiusTo = radius = 7f;
                        }},
                        new HaloPart() {{
                            y = 0f;
                            radius = 3.5f;
                            tri = true;
                            color = ExoPal.empyrean;
                            layer = Layer.effect;
                            haloRotateSpeed = -3f;
                            haloRadius = haloRadiusTo = 11f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 3;
                            triLengthTo = triLength = 6f;
                        }},
                        new HaloPart() {{
                            y = 0f;
                            radius = 4f;
                            tri = true;
                            color = ExoPal.empyrean;
                            layer = Layer.effect;
                            haloRotateSpeed = 3f;
                            haloRadius = haloRadiusTo = 11f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 3;
                            triLengthTo = triLength = 8.5f;
                        }}
                );
                bullet = new BasicBulletType(5f, 85){{
                    width = height = 37f;
                    sprite = "exogenesis-plasma";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    lifetime = 65f;
                    splashDamage = 50;
                    splashDamageRadius = 60;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = new MultiEffect(ExoFx.empyreanExplosion, ExoFx.blastcolor);
                    intervalBullet = new BasicBulletType(4f, 25){{
                        width = height = 7f;
                        sprite = "circle-bullet";
                        frontColor = Color.white;
                        backColor = hitColor = trailColor = ExoPal.empyrean;
                        lifetime = 18f;
                        drag = 0.02f;
                        hitEffect = despawnEffect = ExoFx.colorBombSmall;
                        weaveMag = 3;
                        weaveScale = 2;
                        shrinkY = shrinkX = 0;
                        trailEffect = new Effect(13f, e -> {
                            color(ExoPal.empyrean);
                            for(int s : Mathf.signs){
                                Drawf.tri(e.x, e.y, 1.8f, 14f * e.fslope(), e.rotation + 90f*s);
                            }
                        });
                        homingRange = 60;
                        homingPower = 0.01f;
                        trailRotation = true;
                        trailInterval = 3f;
                        lightning = 4;
                        lightningLength = 6;
                        lightningColor = ExoPal.empyrean;
                        lightningDamage = 11;
                        shootEffect = Fx.lightningShoot;
                        trailLength = 10;
                        trailWidth = 2f;
                    }};
                    bulletInterval = 3f;
                    lightning = 7;
                    lightningLength = 9;
                    lightningColor = ExoPal.empyrean;
                    lightningDamage = 11;
                    shootEffect = Fx.lightningShoot;
                    trailSinScl = 2;
                    trailSinMag = 0.8f;
                    trailParam = 5;
                    trailLength = 6;
                    trailWidth = 4f;
                }};
            }});
        }};
        radiance = new UnitType("radiance") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 3;
            speed = 1.97f;
            hitSize = 40f;
            health = 25600f;
            flying = true;
            drag = 0.07f;
            accel = 0.04f;
            faceTarget = true;
            lowAltitude = true;
            armor = 8;
            trailLength = 8;
            trailColor = engineColor = ExoPal.empyrean;
            rotateSpeed = 2.4f;
            engineSize = 0;
            engineOffset = 0;
            parts.add(
                    new ShapePart() {{
                        mirror = false;
                        progress = PartProgress.warmup;
                        circle = true;
                        layer = Layer.effect;
                        y = -8f;
                        color = ExoPal.empyrean;
                        radiusTo = radius = 11f;
                    }},
                    new ShapePart() {{
                        mirror = false;
                        progress = PartProgress.warmup;
                        circle = true;
                        layer = Layer.effect;
                        y = -8f;
                        color = Color.white;
                        radiusTo = radius = 7f;
                    }},
                    new HaloPart() {{
                        y = -8f;
                        radius = 3.5f;
                        tri = true;
                        color = ExoPal.empyrean;
                        layer = Layer.effect;
                        haloRotateSpeed = -3f;
                        haloRadius = haloRadiusTo = 11f;
                        stroke = 0f;
                        strokeTo = 2f;
                        shapes = 6;
                        triLengthTo = triLength = 6f;
                    }},
                    new HaloPart() {{
                        y = -8f;
                        radius = 4f;
                        tri = true;
                        color = ExoPal.empyrean;
                        layer = Layer.effect;
                        haloRotateSpeed = 4f;
                        haloRadius = haloRadiusTo = 11f;
                        stroke = 0f;
                        strokeTo = 2f;
                        shapes = 2;
                        triLengthTo = triLength = 13.5f;
                    }});
            parts.add(new HaloPart(){{
                y = -8f;
                radius = 3f;
                tri = true;
                color = ExoPal.empyrean;
                layer = Layer.effect;
                haloRotateSpeed = -4f;
                haloRadius = haloRadiusTo = 11f;
                stroke = 0f;
                strokeTo = 2f;
                shapes = 2;
                triLengthTo = triLength = 10.5f;
            }});
            setEnginesMirror(
                    new UnitEngine(19.5f, -27, 5f, 60f),
                    new UnitEngine(9.5f, -27, 4f, 60f)
            );
            weapons.add(new Weapon("radiance-laser") {{
                reload = 280f;
                mirror = false;
                y = 8;
                x = 0;
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
                continuous = true;
                parentizeEffects = true;
                recoil = 0;
                shake = 3f;
                bullet = new ContinuousLaserBulletType(){{
                    hitColor = ExoPal.empyrean;
                    damage = 35f;
                    length = 180f;
                    hitEffect = Fx.hitMeltHeal;
                    drawSize = 420f;
                    lifetime = 260f;
                    shake = 1f;
                    colors = new Color[]{ExoPal.empyrean.cpy().a(.2f), ExoPal.empyrean.cpy().a(.5f), ExoPal.empyrean.cpy().mul(1.2f), Color.white};
                    despawnEffect = Fx.smokeCloud;
                    intervalBullet = new LightningBulletType(){{
                        damage = 30;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = ExoPal.empyrean;
                        lightningLength = 10;
                        lightningLengthRand = 18;
                    }};
                    intervalRandomSpread = 40;
                    intervalBullets = 2;
                    bulletInterval = 1f;
                    smokeEffect = Fx.none;
                    shootEffect = ExoFx.colorBomb;
                }};
            }});
            weapons.add(new Weapon("exogenesis-radiance-mount"){{
                x = 25;
                shootY = 11f;
                reload = 55f;
                recoil = 2f;
                shootSound = Sounds.laser;
                shadow = 15f;
                mirror = true;
                rotate = true;
                rotateSpeed = 1.5f;
                bullet = new LaserBulletType(){{
                    damage = 115f;
                    sideAngle = 20f;
                    sideWidth = 1.5f;
                    sideLength = 50f;
                    width = 25f;
                    length = 160f;
                    hitColor = ExoPal.empyrean;
                    shootEffect = ExoFx.colorBombSmall;
                    colors = new Color[]{Color.valueOf("fee761aa"), Color.valueOf("fcff98"), Color.white};
                }};
            }});
        }};
        prayer = new UnitType("prayer") {{
            constructor = UnitEntity::create;
            defaultCommand = UnitCommand.repairCommand;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 2;
            speed = 2.8f;
            hitSize = 10f;
            health = 760f;
            flying = true;
            drag = 0.08f;
            accel = 0.09f;
            faceTarget = true;
            lowAltitude = true;
            armor = 1;
            trailLength = 8;
            trailColor = ExoPal.empyrean;
            rotateSpeed = 3.7f;
            engineSize = 1.7f;
            engineOffset = 5;
            parts.add(
                    new ShapePart() {{
                        mirror = true;
                        progress = PartProgress.warmup;
                        circle = true;
                        hollow = true;
                        layer = Layer.effect;
                        y = 0f;
                        color = ExoPal.empyrean;
                        stroke = strokeTo = 1.4f;
                        radiusTo = radius = 11f;
                    }},
                    new HaloPart() {{
                        y = 0f;
                        radius = 2.5f;
                        tri = true;
                        color = ExoPal.empyrean;
                        layer = Layer.effect;
                        haloRotateSpeed = -2.5f;
                        haloRadius = haloRadiusTo = 11f;
                        stroke = 0f;
                        strokeTo = 2f;
                        shapes = 2;
                        triLengthTo = triLength = 4f;
                    }}
            );
            weapons.add(new RepairBeamWeapon("prayer") {{
                mirror = rotate = false;
                shootY = 8;
                x = 0;
                laserColor = healColor = ExoPal.empyrean;
                targetBuildings = true;
                beamWidth = 0.8f;
                repairSpeed = 1.7f;
                bullet = new BulletType(){{
                    maxRange = 120f;
                }};
            }});
        }};
        apprise = new UnitType("apprise") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 2.1f;
            speed = 4.4f;
            hitSize = 16f;
            health = 860f;
            flying = true;
            drag = 0.08f;
            accel = 0.09f;
            faceTarget = false;
            circleTarget = true;
            lowAltitude = false;
            armor = 2;
            engineLayer = Layer.effect;
            trailLength = 8;
            trailColor = ExoPal.empyrean;
            rotateSpeed = 3.4f;
            engineSize = 2.5f;
            engineOffset = 10;
            weapons.add(new Weapon("apprise") {{
                minShootVelocity = 0.75f;
                reload = 5f;
                mirror = true;
                shootCone = 180f;
                ejectEffect = Fx.none;
                inaccuracy = 15f;
                ignoreRotation = true;
                x = 4;
                y = -3;
                shootSound = Sounds.none;
                recoil = 0;
                bullet = new BombBulletType(37f, 35f){{
                    width = height = 9f;
                    speed = -0.00001f;
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    lifetime = 16;
                    hitEffect = despawnEffect = ExoFx.colorBombSmaller;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                }};
            }});
        }};
        revelation = new UnitType("revelation") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 2;
            speed = 2.8f;
            hitSize = 15f;
            health = 2160f;
            flying = true;
            drag = 0.06f;
            accel = 0.09f;
            faceTarget = false;
            lowAltitude = true;
            armor = 5;
            rotateSpeed = 4.7f;
            engineSize = 2.5f;
            engineOffset = 12;
            trailLength = 8;
            trailColor = ExoPal.empyrean;
            weapons.add(new Weapon("revelation-zap") {{
                reload = 50f;
                mirror = false;
                y = 18;
                x = 0;
                shootSound = Sounds.spark;
                recoil = 0;
                shake = 1f;
                parts.add(
                new FlarePart () {{
                mirror = false;
                progress = PartProgress.reload;
                layer = Layer.effect;
                y = 0f;
                stroke = 3;
                color1 = ExoPal.empyrean;
                radius = 8.5f;
                }}
                );
                bullet = new PosLightningType(32f){{
                    lightningColor = hitColor = ExoPal.empyrean;
                    maxRange = rangeOverride = 250f;
                    hitEffect = Fx.circleColorSpark;
                    smokeEffect = Fx.none;
                }};
            }});
            weapons.add(new Weapon("zappy"){{
                x = -12;
                reload = 20f;
                shootSound = Sounds.spark;
                recoil = 0;
                mirror = false;
                rotate = true;
                rotateSpeed = 5.5f;
                parts.add(
                        new FlarePart () {{
                            mirror = false;
                            progress = PartProgress.reload;
                            layer = Layer.effect;
                            y = 0f;
                            stroke = 3;
                            color1 = ExoPal.empyrean;
                            radius = 7f;
                        }}
                );
                bullet = new PosLightningType(32f){{
                    lightningColor = hitColor = ExoPal.empyrean;
                    maxRange = rangeOverride = 250f;
                    hitEffect = Fx.circleColorSpark;
                    smokeEffect = Fx.none;
                }};
            }});
            weapons.add(new Weapon("zappy"){{
                x = 12.1f;
                reload = 20f;
                shootSound = Sounds.spark;
                recoil = 0;
                mirror = false;
                rotate = true;
                rotateSpeed = 5.5f;
                parts.add(
                        new FlarePart () {{
                            mirror = false;
                            progress = PartProgress.reload;
                            layer = Layer.effect;
                            y = 0f;
                            stroke = 3;
                            color1 = ExoPal.empyrean;
                            radius = 7f;
                        }}
                );
                bullet = new PosLightningType(32f){{
                    lightningColor = hitColor = ExoPal.empyrean;
                    maxRange = rangeOverride = 250f;
                    hitEffect = Fx.circleColorSpark;
                    smokeEffect = Fx.none;
                }};
            }});
        }};
        enlightenment = new UnitType("enlightenment") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 2;
            speed = 2f;
            hitSize = 40f;
            health = 5650f;
            flying = true;
            drag = 0.07f;
            accel = 0.04f;
            faceTarget = true;
            lowAltitude = true;
            armor = 8;
            trailLength = 8;
            trailColor = engineColor = ExoPal.empyrean;
            rotateSpeed = 1.97f;
            engineSize = 4;
            engineOffset = 15;
            weapons.add(new Weapon("exogenesis-alpha-rocket"){{
                reload = 13f;
                mirror = false;
                x = 0;
                y = -11;
                shootSound = Sounds.missileLarge;
                inaccuracy = 5;
                recoil = 0;
                shake = 1f;
                shoot = new ShootAlternate(){{
                    spread = 6.3f;
                    barrels = 3;
                }};
                bullet = new BasicBulletType(9f, 65){{
                    width =  9;
                    height = 14f;
                    sprite = "missile";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    lifetime = 45f;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = Fx.flakExplosionBig;
                    lightning = 7;
                    lightningLength = 9;
                    lightningColor = ExoPal.empyrean;
                    lightningDamage = 11;
                    shootEffect = Fx.lightningShoot;
                    weaveMag = 7;
                    weaveScale = 2;
                    trailSinScl = 2;
                    trailSinMag = 0.8f;
                    trailParam = 5;
                    trailLength = 6;
                    trailWidth = 3f;
                }};
            }});
        }};
        excelsus = new UnitType("excelsus") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            shadowElevation = 2;
            speed = 1.97f;
            hitSize = 40f;
            health = 25600f;
            flying = true;
            drag = 0.07f;
            accel = 0.04f;
            faceTarget = true;
            lowAltitude = true;
            armor = 8;
            trailLength = 8;
            trailColor = engineColor = ExoPal.empyrean;
            rotateSpeed = 2.4f;
            engineSize = 4;
            engineOffset = 22;
            abilities.add(new EnergyFieldAbility(40f, 65f, 0f){{
                status = StatusEffects.none;
                color = ExoPal.empyrean;
                rotateSpeed = 3;
                effectRadius = 5;
                maxTargets = 0;
            }});
            abilities.add(new EnergyFieldAbility(40f, 65f, 0f){{
                status = StatusEffects.none;
                color = ExoPal.empyrean;
                effectRadius = rotateSpeed = 3;
                x = 15;
                y = -11;
                maxTargets = 0;
            }});
            abilities.add(new EnergyFieldAbility(40f, 65f, 0f){{
                status = StatusEffects.none;
                color = ExoPal.empyrean;
                effectRadius = rotateSpeed = 3;
                x = -15;
                y = -11;
                maxTargets = 0;
            }});
            setEnginesMirror(
                    new UnitEngine(0, -27, 5f, 0f)
            );
            weapons.add(new Weapon("exogenesis-excelsus-mount"){{
                x = 26;
                shootY = 11f;
                recoil = 2f;
                shootSound = Sounds.torch;
                shadow = 15f;
                alternate = false;
                rotationLimit = 45;
                rotate = continuous = alwaysContinuous = mirror = true;
                rotateSpeed = 1.5f;

                bullet = new ContinuousLaserBulletType(){{
                    hitColor = ExoPal.empyrean;
                    damage = 35f;
                    length = 150f;
                    hitEffect = ExoFx.hitMeltColor;
                    drawSize = 420f;
                    width = 7.6f;
                    shake = 1f;
                    largeHit = false;
                    colors = new Color[]{ExoPal.empyreanAlpha, ExoPal.empyrean, Color.white};
                    despawnEffect = Fx.smokeCloud;
                    intervalBullet = new LightningBulletType(){{
                        damage = 10;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = ExoPal.empyrean;
                        lightningLength = 10;
                        lightningLengthRand = 18;
                    }};
                    intervalRandomSpread = 20;
                    intervalBullets = 2;
                    bulletInterval = 3f;
                    smokeEffect = Fx.none;
                    shootEffect = Fx.none;
                }};
            }});
        }};
        orion = new UnitType("orion") {{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("36363c");
            speed = 0.7f;
            hitSize = 13f;
            health = 360f;
            faceTarget = true;
            armor = 2;
            shadowElevation = 0.1f;
            targetAir = false;
            allowLegStep = true;
            hovering = true;
            rotateSpeed = 1.6f;
            legMoveSpace = 1.5f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legPhysicsLayer = false;
            legGroupSize = 4;
            legCount = 8;
            legExtension = -2;
            legContinuousMove = true;
            lockLegBase = true;
            rippleScale = 0.2f;
            legBaseOffset = 5;
            legLength = 9;
            parts.add(
            new RegionPart("-blade"){{
                mirror = true;
                heatColor = Color.valueOf("66B1FF");
                progress = PartProgress.warmup;
                heatProgress = PartProgress.warmup;
                moveRot = -22f;
            }}
            );
            weapons.add(new Weapon("orion") {{
                reload = 100f;
                mirror = false;
                x = 0;
                shootSound = Sounds.artillery;
                showStatSprite = false;
                smoothReloadSpeed = 0.15f;
                shootWarmupSpeed = 0.05f;
                minWarmup = 0.9f;
                shootY = 3;
                recoil = 0;
                shake = 1f;
                        parts.add(
                            new ShapePart() {{
                            mirror = true;
                            progress = PartProgress.warmup;
                            hollow = true;
                            circle = true;
                            layer = Layer.effect;
                            y = 3f;
                            color = Color.valueOf("66B1FF");
                            stroke = 0f;
                            strokeTo = 1f;
                            radiusTo = radius = 3f;
                        }},
                        new HaloPart() {{
                            y = 3f;
                            radius = 2f;
                            tri = true;
                            color = Color.valueOf("66B1FF");
                            layer = Layer.effect;
                            haloRotateSpeed = -1f;
                            haloRadius = haloRadiusTo = 3f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = 3f;
                            triLength = 0f;
                        }},
                        new HaloPart() {{
                            y = 3f;
                            radius = 2f;
                            tri = true;
                            color = ExoPal.genesisDark;
                            layer = Layer.effect;
                            haloRotateSpeed = 1f;
                            haloRadius = haloRadiusTo = 3f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = 3f;
                            triLength = 0f;
                        }}
                        );
                bullet = new EmpBulletType() {{
                    width = 8f;
                    height = 11f;
                    sprite = "circle-bullet";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.genesisDark;
                    lifetime = 40f;
                    speed = 6f;
                    damage = 25f;
                    recoil = 0.6f;
                    splashDamage = 15;
                    splashDamageRadius = 40;
                    shrinkY = shrinkX = 0;
                    radius = 40f;
                    timeIncrease = 0.5f;
                    powerDamageScl = 0.3f;
                    powerSclDecrease = 0.1f;
                    unitDamageScl = 0.3f;
                    status = StatusEffects.freezing;
                    statusDuration = 100;
                    shootEffect = Fx.lightningShoot;
                    homingPower = 0.0678f;
                    homingRange = 40;
                    trailLength = 10;
                    trailWidth = 2f;
                    trailChance = 0.3f;
                    trailEffect = new ParticleEffect() {{
                    particles = 13;
                    length = baseLength = 2.5f;
                    lifetime = 20f;
                    colorFrom = colorTo = trailColor;
                    sizeFrom = 5f;
                    sizeTo = 0f;
                    }};
                }};
            }});
        }};
    }
}