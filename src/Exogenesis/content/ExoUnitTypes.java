package Exogenesis.content;

import Exogenesis.type.*;
import Exogenesis.graphics.*;
import Exogenesis.type.bullet.*;
import Exogenesis.type.bullet.DelayedPointBulletType;
import Exogenesis.type.bullet.PosLightningType;
import Exogenesis.type.bullet.vanilla.*;
import Exogenesis.type.unit.ExoUnitType;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import mindustry.ai.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.content.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.stroke;

public class ExoUnitTypes {
    public static UnitType
    ursa, ullr, empire, heimdall, avicularia, vidar, twilight, notodoris, thor,
    //erekir
    //red
    nkarnt, stratiotis, naitis, protathlitis, vasilias,
    prometheus, atlas, nemesis, hyperion, rhea, cronus, gaia,
    //empyrean
    soul, pneuma, psyche, pemptousia, myalo, lux, glimmer, shine, auric, radiance, prayer, apprise, revelation, enlightenment, excelsus, orion;

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
                shootSound = Sounds.railgun;
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
                    progress = PartProgress.warmup;
                    moves.add(new PartMove(PartProgress.recoil, 0f, 0f, 13f));
                    moveRot = 50f;
                }},
                new RegionPart("-spine1"){{
                    mirror = under = true;
                    x = 9;
                    y = 62;
                    progress = PartProgress.warmup;
                    moves.add(new PartMove(PartProgress.recoil, 0f, 0f, 16f));
                    moveRot = 68f;
                }},
                new RegionPart("-spine2"){{
                    mirror = under = true;
                    x = 9;
                    y = 68;
                    progress = PartProgress.warmup;
                    moves.add(new PartMove(PartProgress.recoil, 0f, 0f, 18f));
                    moveRot = 83f;
                }}
                );
                bullet = new RailBulletType(){{
                    damage = 1500f;
                    length = 530;
                    lightColor = hitColor = lightningColor = Color.valueOf("feb380");
                    shootEffect = ExoFx.shootShockWave;
                    pierceEffect = ExoFx.ColorRailHit;
                    hitEffect = Fx.massiveExplosion;
                    smokeEffect = Fx.shootBig2;
                    endEffect = new Effect(24f, e -> {
                        color(e.color);
                        Drawf.tri(e.x, e.y, e.fout() * 10f, 8f, e.rotation);
                    });
                    lineEffect = new Effect(30f, e -> {
                        if(!(e.data instanceof Vec2 v)) return;

                        color(e.color);
                        stroke(e.fout() * 1.1f + 0.6f);

                        Fx.rand.setSeed(e.id);
                        for(int i = 0; i < 7; i++){
                            Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                            Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                        }
                        e.scaled(30f, b -> {
                            stroke(b.fout() * 7f);
                            color(Color.white);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                        e.scaled(30f, b -> {
                            stroke(b.fout() *
                                    10f);
                            color(e.color);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                    });
                    pierceDamageFactor = 0.3f;
                    collidesTiles = true;
                }};
            }});
            weapons.add(new Weapon("exogenesis-prometheus-machine-gun") {{
                reload = 60f;
                mirror = rotate = true;
                cooldownTime = 80;
                rotateSpeed = 1.5f;
                x = 30;
                y = 24;
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
                x = 38;
                y = -15;
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
                shootStatusDuration = 150;
                shoot.firstShotDelay = 150;
                shootSound = ExoSounds.bigLaserShoot;
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
                            stroke = 3f;
                            phase = 170;
                            radius = 28;
                            layer = Layer.effect;
                            y = 2.5f;
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
                            radius = 10f;
                            radiusTo = 1.5f;
                            layer = 114;
                            y = 2.5f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.recoil;
                            color = Color.valueOf("aec6ff");
                            circle = true;
                            radius = 20;
                            radiusTo = 3;
                            layer = Layer.effect;
                            y = 2.5f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.recoil;
                            color = Color.valueOf("8ca9e855");
                            circle = true;
                            radius = 26;
                            radiusTo = 4;
                            layer = Layer.effect;
                            y = 2.5f;
                        }},
                        new ShapePart() {{
                            progress = PartProgress.recoil;
                            color = Color.valueOf("597cff45");
                            circle = true;
                            radius = 29f;
                            radiusTo = 4.2f;
                            layer = Layer.effect;
                            y = 2.5f;
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
                    smokeEffect = Fx.none;
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
                        sizeFrom = 3f;
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
            rotateSpeed = 0.7f;
            armor = 20f;
            speed = 0.88f;
            accel = 0.04f;
            drag = 0.04f;
            range = 200;
            flying = true;
            hitSize = lightRadius = 80f;
            engineSize = 0f;
            faceTarget = singleTarget = lowAltitude = true;
            abilities.add(new EnergyFieldAbility(25f, 45f, 280f){{
                statusDuration = 60f * 6f;
                sectors = 6;
                status = StatusEffects.sapped;
                color = Color.valueOf("a393fe");
                rotateSpeed = 2f;
                y = 25.5f;
                maxTargets = 35;
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
            new RegionPart("-glow1"){{
                mirror = false;
                under = true;
                layer = Layer.effect;
                color = colorTo = Color.valueOf("9681fb");
                blending = Blending.additive;
                outline = false;
                progress = PartProgress.warmup;
            }},
            new HoverPart(){{
                color = Color.valueOf("a393fe");
                circles = 3;
                phase = 50;
                radius = 15;
                mirror = false;
                layer = Layer.effect;
                y = 25.5f;
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
                mirror = true;
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
                mirror = true;
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
                mirror = true;
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
                baseRotation = - 21;
                layerOffset = -1;
                x = 60;
                y = 8f;
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
                            effect = Fx.none;
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
                    shootEffect = new MultiEffect(Fx.explosion, Fx.colorSparkBig);
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
            constructor = ElevationMoveUnit::create;
            speed = 0.78f;
            hitSize = 90f;
            health = 32000f;
            faceTarget = false;
            fogRadius = 50;
            armor = 45;
            rotateMoveFirst = true;
            hovering = true;
            singleTarget = true;
            useEngineElevation = false;
            flying = false;
            shadowElevation = 0.1f;
            groundLayer = Layer.groundUnit;
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
                x = 30f;
                y = 20f;
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
                recoils = 2;
                recoil = 0f;
                parts.add(
                        new RegionPart("-barrel-l"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 1;
                            progress = PartProgress.recoil;
                            moveY = -5f;
                        }},
                        new RegionPart("-barrel-r"){{
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
                bullet = new BasicBulletType(6.5f, 60){{
                    width = height = 13f;
                    splashDamage = 57;
                    splashDamageRadius = 40;
                    lifetime = 35f;
                    hitColor = trailColor = backColor = Pal.surge;
                    status = StatusEffects.blasted;
                    statusDuration = 100;
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBig2;
                    hitEffect = Fx.flakExplosion;
                    buildingDamageMultiplier = 0.5f;
                    trailLength = 10;
                    trailWidth = 2.5f;
                    fragBullets = 6;
                    fragLifeMin = 0.3f;
                    fragBullet = new BasicBulletType(8.5f, 6){{
                        width = 5;
                        height = 9f;
                        splashDamage = 30;
                        splashDamageRadius = 25;
                        lifetime = 5f;
                        hitColor = trailColor = backColor = Pal.surge;
                        status = StatusEffects.blasted;
                        statusDuration = 100;
                        smokeEffect = Fx.shootBigSmoke;
                        shootEffect = Fx.shootBig2;
                        hitEffect = Fx.flakExplosion;
                        buildingDamageMultiplier = 0.5f;
                        trailLength = 10;
                        trailWidth = 2.5f;
                    }};
                }};
            }});
        }};
        rhea = new ErekirUnitType("rhea") {{
            constructor = UnitEntity::create;
            defaultCommand = UnitCommand.repairCommand;
            buildSpeed = 2.6f;
            rotateSpeed = 0.9f;
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
            faceTarget = false;
            singleTarget = true;
            lowAltitude = true;
            abilities.add(new RegenAbility(){{
                //fully regen in 70 seconds
                percentAmount = 1f / (70f * 60f) * 100f;
            }});
            abilities.add(new StatusFieldAbility(ExoStatusEffects.RheaBuff, 110f, 100f, 260f){{
                parentizeEffects = true;
                effectY = 14.25f;
                activeEffect = new WaveEffect(){{
                    colorFrom = Color.valueOf("ffcbdd");
                    colorTo = ExoPal.erekirPink;
                    interp = Interp.circle;
                    sizeFrom = 0;
                    sizeTo = 160f;
                    lifetime = 95f;
                    strokeTo = 0;
                    strokeFrom = 8f;
                }};

                applyEffect = Fx.none;
            }});
            immunities.add(ExoStatusEffects.RheaBuff);
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
                        stroke = 6;
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
                x = 0f;
                y = 14.25f;
                shootCone = 25;
                mirror = false;
                reload = 500;
                shootSound = ExoSounds.bigLaserShoot;
                shootY = 0f;
                rotateSpeed = 5;
                rotate = true;
                minWarmup = 0.8f;
                smoothReloadSpeed = 0.15f;
                recoil = 0f;
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
                            layer = 110;
                            radiusTo = 0;
                            radius = 13;
                            color = Color.valueOf("ffcbdd");
                            progress = PartProgress.reload;
                        }},
                        new ShapePart() {{
                            circle = true;
                            layer = 110;
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
                            triLength = 4;
                            triLengthTo = 4;
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
                        trailLength = 9;
                        trailWidth = 2;
                        despawnHit = true;
                        hitEffect = ExoFx.colorBombSmall;
                    }};
                    fragRandomSpread = 0f;
                    fragBullets = 1;
                    fragBullet = new BasicBulletType(0f, 9){{
                        parts.addAll(
                                new ShapePart() {{
                                    circle = true;
                                    layer = 114;
                                    radiusTo = 0;
                                    radius = 10;
                                    color = Color.white;
                                }},
                                new ShapePart() {{
                                    circle = true;
                                    layer = Layer.effect;
                                    radiusTo = 0;
                                    radius = 17;
                                    color = Color.valueOf("ffcbdd");
                                }},
                                new ShapePart() {{
                                    circle = true;
                                    layer = Layer.effect;
                                    radiusTo = 0;
                                    radius = 20;
                                    color = ExoPal.erekirPink;
                                }},
                                new HoverPart(){{
                                    color = ExoPal.erekirPink;
                                    circles = 2;
                                    phase = 100;
                                    radius = 68f;
                                    mirror = false;
                                    layer = Layer.effect;
                                }},
                                new HoverPart(){{
                                    color = ExoPal.erekirPink;
                                    circles = 2;
                                    phase = 100;
                                    radius = 88f;
                                    mirror = false;
                                    layer = Layer.effect;
                                }}
                        );
                        hitSound = Sounds.largeExplosion;
                        width = height = 0f;
                        lifetime = 240f;
                        hitSize = 4f;
                        splashDamage = 576;
                        splashDamageRadius = 60;
                        scaledSplashDamage = true;
                        backColor = hitColor = trailColor = ExoPal.erekirPink;
                        collidesGround = collidesTiles = collidesAir = false;
                        trailWidth = 2f;
                        trailLength = 6;
                        hitEffect = despawnEffect = new MultiEffect(
                        new ParticleEffect(){{
                            lightOpacity = 0.5f;
                            line = true;
                            particles = 35;
                            length = 275;
                            offset = 40;
                            strokeFrom = 5;
                            strokeTo = 0;
                            lifetime = 60;
                            lenFrom = 20;
                            lenTo = 10;
                            lightColor = colorFrom = Color.valueOf("ffcbdd");
                            colorTo = ExoPal.erekirPink;
                        }},
                        new WaveEffect(){{
                            colorFrom = Color.valueOf("ffcbdd");
                            colorTo = ExoPal.erekirPink;
                            sizeFrom = 70;
                            sizeTo = 0f;
                            lifetime = 55f;
                            strokeTo = 19;
                            strokeFrom = 0f;
                        }},
                        new WaveEffect(){{
                            colorFrom = Color.valueOf("ffcbdd");
                            colorTo = ExoPal.erekirPink;
                            sizeFrom = 50;
                            sizeTo = 0f;
                            lifetime = 55f;
                            strokeTo = 7;
                            strokeFrom = 0f;
                        }}
                        );
                        bulletInterval = 1;
                        intervalRandomSpread = 360;
                        intervalBullet = new BasicBulletType(5, 35){{
                            parts.addAll(
                                    new ShapePart() {{
                                        circle = true;
                                        layer = 114;
                                        radiusTo = radius = 2;
                                        color = Color.white;
                                    }},
                                    new ShapePart() {{
                                        circle = true;
                                        layer = Layer.effect;
                                        radiusTo = radius = 3;
                                        color = Color.valueOf("ffcbdd");
                                    }},
                                    new ShapePart() {{
                                        circle = true;
                                        layer = Layer.effect;
                                        radiusTo = radius = 4;
                                        color = ExoPal.erekirPink;
                                    }}
                            );
                            hitSound = Sounds.bolt;
                            hitColor = trailColor = ExoPal.erekirPink;
                            weaveMag = 30;
                            weaveScale = 14;
                            weaveRandom = false;
                            pierceBuilding = pierce = true;
                            hitEffect = new MultiEffect(
                                    new ParticleEffect(){{
                                        lightOpacity = 0.5f;
                                        line = true;
                                        particles = 10;
                                        length = 45;
                                        offset = 40;
                                        strokeFrom = 2;
                                        strokeTo = 0;
                                        lifetime = 30;
                                        lenFrom = 7;
                                        lenTo = 3;
                                        lightColor = colorFrom = Color.valueOf("ffcbdd");
                                        colorTo = ExoPal.erekirPink;
                                    }},
                                    new WaveEffect(){{
                                        colorFrom = Color.valueOf("ffcbdd");
                                        colorTo = ExoPal.erekirPink;
                                        interp = Interp.circleOut;
                                        sizeFrom = 0;
                                        sizeTo = 20f;
                                        lifetime = 35f;
                                        strokeTo = 0;
                                        strokeFrom = 2f;
                                    }}
                            );
                            pierceCap = 5;
                            lifetime = 65;
                            width = height = 1;
                            drag = -0.017f;
                            trailLength = 9;
                            trailWidth = 2;
                            despawnHit = true;
                            spawnBullets.add(new BasicBulletType(7, 12){{
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
                                fragRandomSpread = 0f;
                                fragSpread = 120;
                                fragBullets = 3;
                                fragBullet = new ShrapnelBulletType(){{
                                    damage = 35f;
                                    width = 10f;
                                    serrations = 0;
                                    length = 3f;
                                    lifetime = 25;
                                    toColor = fromColor = ExoPal.erekirPink;
                                }};
                                hitSound = Sounds.bolt;
                                drag = -0.0015f;
                                width = height = 0f;
                                lifetime = 42f;
                                pierceCap = 5;
                                pierce = true;
                                pierceBuilding = true;
                                hitColor = trailColor = ExoPal.erekirPink;
                                trailWidth = 2f;
                                trailLength = 9;
                                weaveScale = 5;
                                weaveMag = 30;
                                despawnHit = true;
                                hitEffect = ExoFx.colorBombSmall;
                            }});
                            fragRandomSpread = 0f;
                            fragBullets = 1;
                            fragBullet = new LaserBulletType(){{
                                damage = 35f;
                                sideWidth = 0f;
                                width = 25f;
                                length = 80f;
                                hitColor = ExoPal.erekirPink;
                                colors = new Color[]{ExoPal.erekirPink.cpy().a(0.4f), ExoPal.erekirPink, Color.white};
                            }};
                        }};
                    }};
                }};
            }});
            weapons.add(new RepairBeamWeapon("exogenesis-rhea-mount") {{
                mirror = rotate = true;
                alternate = controllable = false;
                rotateSpeed = 5;
                y = 0;
                x = 61.75f;
                laserColor = healColor = ExoPal.erekirPink;
                targetBuildings = true;
                targetUnits = false;
                beamWidth = 1f;
                repairSpeed = 0.9f;
                fractionRepairSpeed = 0.03f;
                shootY = 10;
                shootCone = 15;
                pulseRadius = 10;
                pulseStroke = 3;
                bullet = new BulletType(){{
                    shootEffect = new WaveEffect(){{
                        colorFrom = Color.valueOf("ffcbdd");
                        colorTo = ExoPal.erekirPink;
                        sizeFrom = 0;
                        sizeTo = 7f;
                        lifetime = 25f;
                        strokeTo = 4;
                        strokeFrom = 0f;
                    }};
                    maxRange = 260f;
                }};
            }});
            weapons.add(new RepairBeamWeapon("exogenesis-rhea-mount") {{
                mirror = rotate = true;
                alternate = controllable = false;
                rotateSpeed = 5;
                y = 14;
                x = 41.75f;
                laserColor = healColor = ExoPal.erekirPink;
                targetBuildings = true;
                targetUnits = false;
                beamWidth = 1f;
                repairSpeed = 0.9f;
                fractionRepairSpeed = 0.03f;
                shootY = 10;
                shootCone = 15;
                pulseRadius = 10;
                pulseStroke = 3;
                bullet = new BulletType(){{
                    shootEffect = new WaveEffect(){{
                        colorFrom = Color.valueOf("ffcbdd");
                        colorTo = ExoPal.erekirPink;
                        sizeFrom = 0;
                        sizeTo = 7f;
                        lifetime = 25f;
                        strokeTo = 4;
                        strokeFrom = 0f;
                    }};
                    maxRange = 260f;
                }};
            }});
            weapons.add(new RepairBeamWeapon("exogenesis-rhea-mount") {{
                mirror = rotate = true;
                alternate = controllable = false;
                rotateSpeed = 5;
                y = 35;
                x = 27f;
                laserColor = healColor = ExoPal.erekirPink;
                targetBuildings = true;
                targetUnits = false;
                beamWidth = 1f;
                repairSpeed = 0.9f;
                fractionRepairSpeed = 0.03f;
                shootY = 10;
                shootCone = 15;
                pulseRadius = 10;
                pulseStroke = 3;
                bullet = new BulletType(){{
                    shootEffect = new WaveEffect(){{
                        colorFrom = Color.valueOf("ffcbdd");
                        colorTo = ExoPal.erekirPink;
                        sizeFrom = 0;
                        sizeTo = 7f;
                        lifetime = 25f;
                        strokeTo = 4;
                        strokeFrom = 0f;
                    }};
                    maxRange = 260f;
                }};
            }});
        }};
        cronus = new ErekirUnitType("cronus") {{
            constructor = LegsUnit::create;
            fogRadius = 50;
            speed = 0.8f;
            hitSize = 76f;
            health = 78000f;
            faceTarget = singleTarget = true;
            armor = 38;
            shadowElevation = 0.3f;
            allowLegStep = hovering = true;
            rotateSpeed = 0.8f;
            legSpeed = 0.6f;
            legMoveSpace = 0.7f;
            baseLegStraightness = 0.8f;
            legPhysicsLayer = false;
            legLength = 120;
            
            legCount = 8;
            legExtension = -6;
            legContinuousMove = lockLegBase = true;
            legStraightness = 0.3f;
            rippleScale = 2.8f;
            legPairOffset = 2;
            legBaseOffset = 36;
            legSplashDamage = 156;
            legSplashRange = 10;
            groundLayer = 77;
            range = 300;
            abilities.add(new StatusFieldAbility(ExoStatusEffects.CronusBuff, 110f, 90f, 200f){{
                parentizeEffects = true;
                effectY = 20f;
                activeEffect = new WaveEffect(){{
                    colorFrom = ExoPal.cronusRedlight;
                    colorTo = ExoPal.cronusRed;
                    interp = Interp.circle;
                    sizeFrom = 0;
                    sizeTo = 160f;
                    lifetime = 95f;
                    strokeTo = 0;
                    strokeFrom = 8f;
                }};
                applyEffect = Fx.none;
            }});
            immunities.add(ExoStatusEffects.CronusBuff);
            parts.addAll(
                    new ShapePart() {{
                        circle = true;
                        layer = 114;
                        y = 22;
                        radiusTo = radius = 8;
                        color = Color.white;
                    }},
                    new ShapePart() {{
                        circle = true;
                        layer = Layer.effect;
                        y = 22;
                        radiusTo = radius = 10;
                        color = ExoPal.cronusRedlight;
                    }},
                    new ShapePart() {{
                        circle = true;
                        layer = Layer.effect;
                        y = 22;
                        radiusTo = radius = 14;
                        color = ExoPal.cronusRed;
                    }},
                    new HoverPart(){{
                        color = ExoPal.cronusRed;
                        circles = 4;
                        stroke = 3;
                        phase = 100;
                        radius = 25f;
                        mirror = false;
                        layer = Layer.effect;
                        y = 22f;
                    }},
                    //main
                    new HaloPart() {{
                        tri = true;
                        y = 22;
                        radius = 6f;
                        layer = Layer.effect;
                        haloRadius = haloRadiusTo = 12;
                        haloRotateSpeed = -2.5f;
                        shapeRotation = 38;
                        strokeTo = 2;
                        shapes = 4;
                        triLength = triLengthTo = 17;
                        color = ExoPal.cronusRed;
                    }},
                    new HaloPart() {{
                        tri = true;
                        y = 22;
                        radius = 6f;
                        layer = Layer.effect;
                        haloRadius = haloRadiusTo = 12;
                        haloRotateSpeed = -2.5f;
                        shapeRotation = 218;
                        strokeTo = 2;
                        shapes = 4;
                        triLength = triLengthTo = 4;
                        color = ExoPal.cronusRed;
                    }},
                    new HaloPart() {{
                        tri = true;
                        y = 22;
                        radius = 6f;
                        layer = Layer.effect;
                        haloRadius = haloRadiusTo = 12;
                        haloRotateSpeed = -2.5f;
                        haloRotation = 45;
                        shapeRotation = 38;
                        strokeTo = stroke = 2;
                        shapes = 4;
                        triLength = triLengthTo = 19;
                        color = ExoPal.cronusRed;
                    }},
                    new HaloPart() {{
                        tri = true;
                        y = 22;
                        radius = 6f;
                        layer = Layer.effect;
                        haloRadius = haloRadiusTo = 12;
                        haloRotateSpeed = -2.5f;
                        haloRotation = 45;
                        shapeRotation = 218;
                        strokeTo = stroke = 2;
                        shapes = 4;
                        triLength = triLengthTo = 6;
                        color = ExoPal.cronusRed;
                    }},
                    new RegionPart("-wing-2"){{
                        mirror = true;
                        x = 46;
                        y = 25;
                        layerOffset = -0.002f;
                        progress = PartProgress.warmup;
                        moveRot = 30f;
                    }},
                    new RegionPart("-wing-2"){{
                        mirror = true;
                        x = 50;
                        y = 0;
                        layerOffset = -0.002f;
                        rotation = -20;
                        progress = PartProgress.warmup.delay(0.1f);
                        moveRot = 30f;
                    }},
                    new RegionPart("-wing-1"){{
                        mirror = true;
                        x = 43;
                        y = -30;
                        layerOffset = -0.002f;
                        rotation = -30;
                        progress = PartProgress.warmup.delay(0.2f);
                        moveRot = 50f;
                    }}
            );
            weapons.add(new Weapon("disk") {{
                reload = 80f;
                mirror = rotate = true;
                alternate = true;
                shootCone = 45;
                cooldownTime = 80;
                layerOffset = 2;
                rotateSpeed = 9;
                x = 0;
                y = 22f;
                shoot = new ShootSpread() {{
                    shots = 6;
                    spread = 7;
                }};
                shootSound = Sounds.laser;
                recoil = shake = shootY = 0f;
                bullet = new BasicBulletType(9, 20){{
                    parts.addAll(
                            new ShapePart() {{
                                circle = true;
                                layer = 114;
                                radiusTo = radius = 3.5f;
                                color = Color.white;
                            }},
                            new ShapePart() {{
                                circle = true;
                                layer = Layer.effect;
                                radiusTo = radius = 6;
                                color = ExoPal.cronusRed;
                            }},
                            new HaloPart() {{
                                tri = true;
                                radius = 4f;
                                layer = Layer.effect;
                                haloRadius = haloRadiusTo = 5;
                                haloRotateSpeed = -4.4f;
                                shapeRotation = 38;
                                strokeTo = stroke = 2;
                                shapes = 8;
                                triLength = triLengthTo = 4;
                                color = ExoPal.cronusRed;
                            }},
                            new HaloPart() {{
                                tri = true;
                                radius = 4f;
                                layer = Layer.effect;
                                haloRadius = haloRadiusTo = 5;
                                haloRotateSpeed = -4.4f;
                                shapeRotation = 218;
                                strokeTo = stroke = 2;
                                shapes = 8;
                                triLength = triLengthTo = 14;
                                color = ExoPal.cronusRed;
                            }}
                    );
                    trailColor = hitColor = lightningColor = ExoPal.cronusRed;
                    pierce = pierceBuilding = true;
                    pierceCap = 8;
                    width = height = 0;
                    lifetime = 90;
                    homingRange = 40;
                    homingDelay = 10;
                    homingPower = 0.8f;
                    despawnHit = true;
                    trailWidth = 3;
                    trailLength = 10;
                    hitEffect = Fx.circleColorSpark;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                }};
            }});
            weapons.add(new Weapon("exogenesis-cronus-rocket-launcher") {{
                reload = 50f;
                mirror = true;
                rotate = false;
                rotateSpeed = 1.5f;
                x = 40;
                y = 31f;
                shootSound = Sounds.missile;
                baseRotation = -45;
                shoot = new ShootMulti(new ShootAlternate(){{
                    spread = 5;
                    shots = 3;
                    barrels = 3;
                }}, new ShootPattern(){{
                    shots = 5;
                    shotDelay = 1.5f;
                }});
                velocityRnd = 0.2f;
                shootCone = 165;
                layerOffset = -0.001f;
                recoil = 0;
                shake = 0.5f;
                bullet = new BasicBulletType(9f, 65){{
                    width = 6f;
                    height = 29f;
                    sprite = "missile-large";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.cronusRed;
                    lifetime = 40f;
                    hitEffect = Fx.blastExplosion;
                    shrinkY = shrinkX = 0;
                    shootEffect = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);
                    buildingDamageMultiplier = 0.8f;
                    despawnHit = true;
                    weaveMag = weaveScale = 2;
                    keepVelocity = false;
                    homingRange = 100;
                    homingDelay = 3;
                    homingPower = 0.08f;
                    trailLength = 10;
                    trailWidth = 2f;
                }};
            }});
            weapons.add(new Weapon("exogenesis-cronus-repulser") {{
                reload = 40f;
                mirror = rotate = alternate = true;
                rotateSpeed = 2f;
                x = 36;
                y = 13;
                shootSound = Sounds.laser;
                shootStatus = StatusEffects.slow;
                shootStatusDuration = 40;
                shoot = new ShootSpread(){{
                    spread = 4;
                    shots = 3;
                }};
                shootCone = 45;
                recoil = 2;
                shake = 1.5f;
                bullet = new LaserBulletType(){{
                    damage = 140f;
                    sideWidth = 1f;
                    sideAngle = 35;
                    sideLength = 17;
                    shootEffect = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);
                    width = 40f;
                    length = 200f;
                    hitColor = ExoPal.cronusRed;
                    colors = new Color[]{ExoPal.cronusRed.cpy().a(0.4f), ExoPal.cronusRed, Color.white};
                }};
            }});
            weapons.add(new Weapon("exogenesis-cronus-ion-blaster") {{
                reload = 80f;
                mirror = rotate = alternate = top = true;
                rotateSpeed = 2.2f;
                x = 50;
                y = -15.5f;
                shootSound = Sounds.shootSmite;
                shootStatus = StatusEffects.slow;
                shootStatusDuration = 40;
                cooldownTime = 120;
                heatColor = Color.red;
                parts.addAll(
                        new RegionPart("-blade"){{
                            mirror = true;
                            moveX = 3;
                            heatColor = Color.red;
                            moves.add(new PartMove(PartProgress.recoil, 4f, 0f, 0f));
                            progress = PartProgress.warmup;
                        }}
                );
                shoot = new ShootSpread(){{
                    spread = 5;
                    shots = 7;
                }};
                shootCone = 45;
                layerOffset = 0.001f;
                recoil = 3.5f;
                shake = 0.5f;
                bullet = new BasicBulletType(8.5f, 207){{
                    lifetime = 60f;
                    backColor = lightColor = lightningColor = trailColor = hitColor = ExoPal.cronusRed;
                    impact = true;
                    knockback = 3f;
                    sprite = "circle-bullet";
                    trailSinScl = 2;
                    trailSinMag = 1.2f;
                    trailWidth = 5.5f;
                    trailLength = 10;
                    hitSize = 12f;
                    drag = 0.017f;
                    width = 105f;
                    height = 7;
                    shrinkX = 0.45f;
                    shrinkY = -2.48f;
                    pierceDamageFactor = 0.3f;
                    shrinkInterp = Interp.reverse;
                    pierce = pierceBuilding = laserAbsorb = true;
                    pierceCap = 6;
                    splashDamage = 50;
                    splashDamageRadius = 20;
                    shootEffect = new MultiEffect(Fx.shootBigColor, Fx.shootBigSmoke);
                    intervalBullet = new LightningBulletType(){{
                        damage = 3;
                        lightningColor = ExoPal.cronusRed;
                        lightningLength = 4;
                        lightningLengthRand = 6;
                        buildingDamageMultiplier = 0.25f;
                    }};
                    bulletInterval = 1f;
                    hitEffect = Fx.circleColorSpark;
                    despawnEffect = new Effect(35f, 70f, e -> {
                        Draw.color(e.color, Color.white, e.fout() * 0.7f);
                        for(int i : Mathf.signs){

                            Drawf.tri(e.x, e.y, height * 1.5f * e.fout(), width * 0.885f * e.fout(), e.rotation + i * 90);
                            Drawf.tri(e.x, e.y, height * 0.8f * e.fout(), width * 0.252f * e.fout(), e.rotation + 90 + i * 90);
                        }
                    });
                }};
            }});
        }};
        gaia = new ErekirUnitType("gaia"){{
            constructor = UnitEntity::create;
            health = 54000f;
            speed = 2.1f;
            rotateSpeed = 1f;
            accel = 0.08f;
            drag = 0.07f;
            lightRadius = 80;
            fogRadius = 50;
            armor = 26f;
            hitSize = 137.5f;
            engineSize = -1f;
            flying = true;
            lowAltitude = true;
            }};

        nkarnt = new ErekirUnitType("nkarnt"){{
            constructor = LegsUnit::create;
            speed = 0.8f;
            health = 100;
            hitSize = 7.75f * 1.7f;
            range = 250f;
            lockLegBase = true;
            legContinuousMove = true;
            allowLegStep = true;
            baseLegStraightness = 0.6f;
            legMoveSpace= 1.5f;
            legPhysicsLayer = false;
            legCount = 8;
            legPairOffset = 1;
            legBaseOffset = 7;
            legExtension = -6;
            legLength = 13f;

            weapons.add(new Weapon("zap"){{
                reload = 100;
                x = 0f;
                y = -1f;
                shootY = 0f;
                mirror = false;
                rotate = false;
                shootSound = Sounds.spark;
                bullet = new PosLightningType(100f){{
                    lightningColor = hitColor = ExoPal.cronusRed;
                    maxRange = rangeOverride = 250f;
                    hitShake = 2.5f;
                    shootEffect = Fx.colorSparkBig;
                    hitEffect = ExoFx.colorBombSmaller;
                    smokeEffect = Fx.none;
                }};
            }});
        }};
        stratiotis = new ErekirUnitType("stratiotis"){{
            constructor= LegsUnit::create;
            outlineColor = Color.valueOf("36363c");
            rotateSpeed = 1.2f;
            speed = 0.7f;
            health = 640;
            hitSize = 9.5f * 1.7f;
            range = 350f;
            allowLegStep = true;
            legCount = 4;
            legGroupSize = 2;
            legMoveSpace = 0.5f;
            legLength = 28f;
            legExtension = -4.3f;

            weapons.add( new Weapon("exogenesis-red-missile-launcher"){{
                reload = 50f;
                x = 6.25f;
                shoot = new ShootPattern() {{
                shots = 6;
                shotDelay = 3;
                }};
                inaccuracy = 4f;
                rotate = true;
                bullet = new MissileBulletType(5f, 25f){{
                    speed = 5f;
                    width = 7f;
                    height = 12f;
                    shrinkY = 0f;
                    backColor = trailColor = ExoPal.cronusRed;
                    frontColor = ExoPal.cronusRed;
                    weaveMag = 3f;
                    weaveScale = 4f;
                }};
            }});
        }};
        naitis = new ErekirUnitType("naitis"){{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("36363c");
            rotateSpeed = 0.8f;
            speed = 0.7f;
            health = 1220;
            hitSize = 17.85f;
            range = 350f;
            allowLegStep = true;
            legMoveSpace = 0.6f;
            legGroupSize = 3;
            legPairOffset = 1;
            legCount = 4;
            legLength = 36f;
            legExtension = -9.3f;

            weapons.add(new Weapon("exogenesis-red-missile-launcher"){{
                        x = 17.25f;
                        y = 0f;
                        rotate = true;
                        reload = 50;
                        inaccuracy = 1f;
                        bullet = new BasicBulletType(7f, 45f){{
                            width = 5f;
                            height = 7f;
                            shrinkY = 0f;
                            shrinkX = 0f;
                            trailWidth = 1f;
                            trailLength = 6;
                            backColor = trailColor = ExoPal.cronusRed;
                            frontColor = ExoPal.cronusRed;
                        }};
                    }});
            weapons.add(new Weapon("exogenesis-red-missile-launcher"){{
                x = 10.25f;
                y = 9.25f;
                rotate = true;
                reload = 49;
                inaccuracy = 1f;
                bullet = new BasicBulletType(7f, 45f){{
                    width = 5f;
                    height = 7f;
                    shrinkY = 0f;
                    shrinkX = 0f;
                    trailWidth = 1f;
                    trailLength = 6;
                    backColor = trailColor = ExoPal.cronusRed;
                    frontColor = ExoPal.cronusRed;
                }};
            }});
            weapons.add(new Weapon("exogenesis-red-missile-launcher"){{
                x = 12.25f;
                y = -12.25f;
                rotate = true;
                reload = 48;
                inaccuracy = 1f;
                bullet = new BasicBulletType(7f, 45f){{
                    width = 5f;
                    height = 7f;
                    shrinkY = 0f;
                    shrinkX = 0f;
                    trailWidth = 1f;
                    trailLength = 6;
                    backColor = trailColor = ExoPal.cronusRed;
                    frontColor = ExoPal.cronusRed;
                }};
            }});
            weapons.add(new Weapon("exogenesis-red-flak-turret"){{
                x = 0f;
                y = -3f;
                rotateSpeed = 2.5f;
                reload = 6f;
                shootSound = Sounds.shootBig;
                ejectEffect = Fx.casing2;
                rotationLimit = 80;
                shootCone = 40;
                layerOffset = 1;
                shadow = 7f;
                rotate = true;
                mirror = false;
                alternate = false;
                recoils = 2;
                recoil = 0f;
                parts.add(
                        new RegionPart("-barrel-l"){{
                            mirror = false;
                            under = true;
                            recoilIndex = 1;
                            progress = PartProgress.recoil;
                            moveY = -5f;
                        }},
                        new RegionPart("-barrel-r"){{
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
                bullet = new BasicBulletType(6.5f, 60){{
                    width = 7;
                    height = 12f;
                    lifetime = 35f;
                    hitColor = trailColor = backColor = ExoPal.cronusRed;
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBig2;
                    hitEffect = Fx.flakExplosion;
                    buildingDamageMultiplier = 0.5f;
                    trailLength = 10;
                    trailWidth = 2.5f;
                }};
            }});
        }};
        protathlitis = new ErekirUnitType("protathlitis"){{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("36363c");
            rotateSpeed = 0.9f;
            speed = 0.6f;
            health = 9400;
            hitSize = 36f;
            range = 360f;
            allowLegStep = true;
            legMoveSpace = 0.53f;
            armor = 4f;
            legBaseOffset = 6;
            legCount = 4;
            legLength = 41f;
            legExtension = -9.3f;
            legSplashDamage = 20f;
            legSplashRange = 30f;

            groundLayer = Layer.legUnit;

            weapons.add(new Weapon("exogenesis-red-large-launcher"){{
                x = 13.5f;
                y = -6.5f;
                shootY = 5f;
                shadow = 8f;
                rotateSpeed = 5f;
                rotate = true;
                reload = 80f;
                shake = 1f;
                shoot = new ShootSpread() {{
                    shots = 12;
                    spread = 3;
                    shotDelay = 1;
                }};
                inaccuracy = 5f;
                velocityRnd = 0.2f;
                xRand = 1.2f;
                shootSound = Sounds.missile;

                bullet = new MissileBulletType(5f, 95f){{
                    width = 7f;
                    height = 17f;
                    shrinkY = 0;
                    shrinkX = 0;
                    backColor = trailColor = ExoPal.cronusRed;
                    frontColor = ExoPal.cronusRed;
                    weaveMag = 3f;
                    weaveScale = 4f;
                }};

            }},
                new Weapon("exogenesis-red-artillery"){{
                    x = 13.5f;
                    y = -6.5f;
                    shootY = 5f;
                    shadow = 8f;
                    rotateSpeed = 1f;
                    rotationLimit = 60;
                    rotate = true;
                    reload = 80f;
                    shake = 1f;
                    shoot = new ShootSpread(3, 12f);
                    shootSound = Sounds.shootBig;

                    bullet = new ShrapnelBulletType(){{
                        length = 17f;
                        damage = 80f;
                        width = 10f;
                        serrationLenScl = 7f;
                        serrationSpaceOffset = 60f;
                        serrationFadeOffset = 0f;
                        serrations = 6;
                        serrationWidth = 5f;
                        fromColor = ExoPal.cronusRed;
                        toColor = ExoPal.cronusRedDark;
                        shootEffect = smokeEffect = Fx.sparkShoot;
                    }};
            }},
                new Weapon("exogenesis-red-railgun"){{
                x = 7f;
                y = -9.25f;
                shootY = 10.75f;
                rotateSpeed = 2f;
                rotate = true;
                shadow = 12f;
                reload = 30;
                shootSound = Sounds.laser;

                bullet = new LaserBulletType(){{
                    damage = 140f;
                    sideWidth = 1f;
                    sideAngle = 35;
                    sideLength = 17;
                    shootEffect = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);
                    width = 30f;
                    length = 200f;
                    hitColor = ExoPal.cronusRed;
                    colors = new Color[]{ExoPal.cronusRed.cpy().a(0.4f), ExoPal.cronusRed, Color.white};
                }};
            }});
        }};
        vasilias = new ErekirUnitType("vasilias"){{
            constructor = LegsUnit::create;
            speed = 0.55f;
            health = 23000;
            hitSize = 47.5f;
            range = 390f;
            allowLegStep = true;
            rotateSpeed = 1f;
            armor = 12f;

            hovering = true;
            groundLayer = Layer.legUnit + 0.01f;
            legCount = 8;
            legLength = 50f;
            legExtension = -9.5f;
            legSplashDamage = 90f;
            legSplashRange = 65f;
            legBaseOffset = 18;
            legMoveSpace = 0.57f;
            legPairOffset = 0.8f;

            weapons.add(new Weapon(name + "-laser-weapon"){{
                x = 30.25f;
                y = -12.25f;
                shootY = 7f;
                top = true;
                reload = 30f;
                rotateSpeed = 2;
                rotate = true;
                shoot = new ShootPattern() {{
                    shots = 2;
                    shotDelay = 4;
                }};
                shake = 2;
                shootSound = Sounds.railgun;
                bullet = new PosLightningType(2000f){{
                    lightningColor = hitColor = ExoPal.cronusRed;
                    maxRange = rangeOverride = 390f;
                    hitShake = 4;
                    shootEffect = Fx.colorSparkBig;
                    hitEffect = ExoFx.colorBomb;
                    smokeEffect = Fx.none;
                }};
            }}, new Weapon("exogenesis-red-large-launcher"){{
                x = 12.25f;
                y = 13f;
                shootY = 5f;
                xRand = 2.2f;
                shadow = 8f;
                rotateSpeed = 5f;
                rotate = true;
                reload = 4f;
                inaccuracy = 5f;

                bullet = new BasicBulletType(6f, 12f){{
                    lifetime = 35f;
                    width = 7f;
                    height = 12f;
                    backColor = hitColor = ExoPal.cronusRed;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 2;
                }};
            }}, new Weapon("exogenesis-red-large-launcher"){{
                x = 15.75f;
                y = -17.5f;
                shootY = 5f;
                shadow = 8f;
                rotateSpeed = 5f;
                rotate = true;
                reload = 85f;
                shake = 1f;
                shoot = new ShootSpread() {{
                    shots = 9;
                    shotDelay = 1;
                }};
                inaccuracy = 7f;
                velocityRnd = 0.2f;
                xRand = 1.2f;
                shootSound = Sounds.missile;

                bullet = new MissileBulletType(5f, 95f){{
                    width = 7f;
                    height = 17f;
                    shrinkY = 0;
                    shrinkX = 0;
                    backColor = trailColor = ExoPal.cronusRed;
                    frontColor = ExoPal.cronusRed;
                    weaveMag = 3f;
                    weaveScale = 4f;
                }};
            }}, new Weapon("exogenesis-red-large-launcher"){{
                x = 9.25f;
                y = -13.75f;
                shootY = 5f;
                shadow = 8f;
                rotateSpeed = 5f;
                rotate = true;
                reload = 90f;
                shake = 1f;
                shoot = new ShootSpread() {{
                    shots = 9;
                    shotDelay = 1;
                }};
                inaccuracy = 7f;
                velocityRnd = 0.2f;
                xRand = 1.2f;
                shootSound = Sounds.missile;

                bullet = new MissileBulletType(5f, 95f){{
                    width = 7f;
                    height = 17f;
                    shrinkY = 0;
                    shrinkX = 0;
                    backColor = trailColor = ExoPal.cronusRed;
                    frontColor = ExoPal.cronusRed;
                    weaveMag = 3f;
                    weaveScale = 4f;
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
        ullr = new UnitType("ullr"){{
            constructor = LegsUnit::create;
            speed = 0.20f;
            hitSize = 56f;
            health = 65000f;
            faceTarget = singleTarget = true;
            armor = 15;
            shadowElevation = 0.3f;
            allowLegStep = hovering = true;
            rotateSpeed = 1.6f;
            legSpeed = 0.6f;
            legLength = 33;
            legCount = 4;
            legMoveSpace = 0.8f;
            lockLegBase = true;
            legContinuousMove = false;
            legMaxLength = 36;
            rippleScale = 6.8f;
            legGroupSize = 1;
            legPairOffset = 1;
            legBaseOffset = 20;
            legSplashDamage = 156;
            legSplashRange = 60;
            groundLayer = 77;
            weapons.add(new Weapon("ullr-piercer") {{
                reload = 1000f;
                mirror = false;
                x = 0;
                y = 2f;
                shootY = 0;
                shootStatus = StatusEffects.unmoving;
                shootStatusDuration = 560;
                shoot.firstShotDelay = 280;
                shootSound = ExoSounds.funnylaserloop;
                recoilTime = 285;
                cooldownTime = 105;
                continuous = true;
                recoil = 0;
                shake = 1f;
                parts.addAll(
                        // weapon parts
                        new FlarePart(){{
                            progress = PartProgress.recoil;
                            color1 = Pal.heal;
                            color2 = Color.white;
                            spinSpeed = 0.6f;
                            radius = 0f;
                            stroke = 5;
                            radiusTo = 280f;
                            layer = 109;
                            y = 0;
                        }},
                        new FlarePart(){{
                            progress = PartProgress.heat;
                            color1 = Pal.heal;
                            color2 = Color.white;
                            sides = 2;
                            rotation = 90;
                            followRotation = true;
                            radius = 0f;
                            stroke = 12;
                            radiusTo = 380f;
                            layer = 109;
                            y = 0;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.recoil;
                            color = Color.white;
                            circle = true;
                            radius = 6f;
                            radiusTo = 0f;
                            layer = 114;
                            y = 0f;
                        }},
                        new ShapePart(){{
                            progress = PartProgress.recoil;
                            color = Pal.heal;
                            circle = true;
                            radius = 10;
                            radiusTo = 0;
                            layer = Layer.effect;
                            y = 0f;
                        }}
                );
                bullet = new AcceleratingLaserBulletType(230f){{
                    lifetime = 280f;
                    maxLength = 830f;
                    maxRange = 830f;
                    oscOffset = 0.3f;
                    shootEffect = ExoFx.blastcolor;
                    chargeEffect = new MultiEffect(ExoFx.ullrChargeBegin, ExoFx.ullrChargeEffect);
                    width = 30f;
                    damageType = DamageType.energy;
                    collisionWidth = 10f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                    pierceCap = 3;
                    hitEffect = ExoFx.ullarTipHit;
                    hitColor = Pal.heal;
                }};
            }});
            weapons.add(new Weapon("exogenesis-energy-mount") {{
                reload = 82f;
                mirror = true;
                rotate = true;
                rotateSpeed = 1.5f;
                x = 27;
                y = 0;
                shootY = 9;
                shoot = new ShootPattern() {{
                    shotDelay = 3f;
                    shots = 4;
                }};
                shootSound = Sounds.bolt;
                shake = 1f;
                bullet = new PosLightningType(32f){{
                    lightningColor = hitColor = Pal.heal;
                    damageType = DamageType.energy;
                    maxRange = rangeOverride = 250f;
                    lightning = 4;
                    lightningLength = 6;
                    lightningDamage = 20;
                    shootEffect = Fx.colorSparkBig;
                    hitEffect = ExoFx.hitMeltColor;
                    smokeEffect = Fx.none;
                }};
            }});

        }};
        empire = new UnitType("empire"){{
                constructor = MechUnit::create;
                speed = 0.35f;
                hitSize = 49f;
                rotateSpeed = 1.5f;
                health = 78000f;
                armor = 35f;
                mechStepParticles = singleTarget = true;
                stepShake = 1f;
                canDrown = false;
                mechFrontSway = 2f;
                mechSideSway = 0.7f;
                mechStride = (4f + (hitSize - 8f) / 2.1f) / 1.25f;
                immunities.add(StatusEffects.blasted);

                weapons.add(new Weapon(name + "-weapon") {{
                    top = false;
                    layerOffset = -0.001f;
                    x = 35.25f;
                    y = 0f;
                    rotate = true;
                    rotationLimit = 50;
                    rotateSpeed = 1.4f;
                    shootY = 30.25f;
                    cooldownTime = 100;
                    reload = 2.5f;
                    recoil = 1f;
                    shake = 2f;
                    shoot = new ShootMulti(new ShootAlternate() {{
                        spread = 1f;
                        barrels = 5;
                    }}, new ShootPattern() {{
                        shots = 3;
                        shotDelay = 1;
                    }});
                    inaccuracy = 9;
                    velocityRnd = 0.2f;
                    ejectEffect = Fx.casing4;
                    shootSound = Sounds.shootBig;

                    bullet = new ExoBasicBulletType(25f, 80f) {{
                        lifetime = 17f;
                        hitEffect = despawnEffect = Fx.blastExplosion;
                        shootEffect = Fx.shootBig;
                        damageType = DamageType.kinetic;
                        trailWidth = 3f;
                        trailLength = 8;
                        width = 10f;
                        height = 17f;
                        shrinkY = 0f;
                        shrinkX = 0f;
                        pierceArmor = true;
                        pierceCap = 1;
                    }};
                }});
            }};
        heimdall = new UnitType("heimdall"){{
            constructor = MechUnit::create;
            speed = 0.25f;
            hitSize = 49f;
            rotateSpeed = 1.25f;
            health = 180000f;
            armor = 80f;
            mechStepParticles = true;
            singleTarget = true;
            stepShake = 3f;
            canDrown = targetAir = false;
            mechStride = (4f + (hitSize - 8f) / 2.1f) / 1.3f;
            immunities.addAll(StatusEffects.blasted, StatusEffects.melting);
            abilities.add(new MoveLightningAbility(10, -1, 1f, 12, 0.33f, 4, Pal.meltdownHit, "exogenesis-bash-heat") {{
                display = false;
                bullet = new BasicBulletType(22, 0){{
                    lifetime = 2;
                    hitEffect = despawnEffect = shootEffect = smokeEffect = Fx.none;
                    width = height = 0f;
                    despawnShake = 4;
                    knockback = 10;
                    impact = true;
                    hitShake = 7;
                    scaledSplashDamage = true;
                    splashDamage = 250;
                    splashDamageRadius = 70;
                }};
                color = Pal.turretHeat;
                shootSound = Sounds.none;
            }});
            weapons.add(new Weapon(name + "-weapon"){{
                x = 36.5f;
                y = 2.75f;
                shootY = 26;
                top = true;
                layerOffset = -0.001f;
                alternate = true;
                rotate = true;
                recoil = 6;
                rotationLimit = 50;
                rotateSpeed = 1f;
                reload = 30f;
                shootCone = 60f;
                velocityRnd = 0.35f;
                inaccuracy = 23;
                ejectEffect = ExoFx.casing5;
                shootSound = Sounds.shotgun;
                shoot.shots = 18;
                bullet = new ExoBasicBulletType(10f, 250f) {{
                    lifetime = 15f;
                    hitEffect = despawnEffect = Fx.blastExplosion;
                    shootEffect = Fx.shootBig;
                    damageType = DamageType.kinetic;
                    status = StatusEffects.blasted;
                    statusDuration = 130;
                    trailWidth = 4f;
                    trailLength = 8;
                    knockback = 6;
                    impact = true;
                    width = 16f;
                    height = 26f;
                    shrinkY = 0f;
                    shrinkX = 0f;
                    pierceArmor = true;
                    pierceBuilding = false;
                    pierceCap = 1;
                }};
            }});
            weapons.add(new Weapon("enginemain"){{
                parentizeEffects = continuous = ignoreRotation = true;
                alternate = display = rotate = false;
                baseRotation = 180;
                shootStatus = StatusEffects.unmoving;
                shootStatusDuration = 140;
                shootCone = 360;
                parts.addAll(
                        new RegionPart("-engine"){{
                            mirror = false;
                            layer = 109;
                            color = Color.valueOf("000000");
                            colorTo = Pal.meltdownHit;
                            blending = Blending.additive;
                            outline = false;
                            progress = PartProgress.recoil;
                        }}
                );
                x = 0;
                y = -10;
                shootY = 0;
                reload = 400;
                shootSound = Sounds.none;
                bullet = new ContinuousFlameBulletType(){{
                    maxRange = 150;
                    lifetime = 140;
                    damage = 4;
                    width = 8.3f;
                    layer = 110;
                    drawFlare = collides = collidesTiles = false;
                    recoil = -0.5f;
                    length = 40;
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
                            length = 105f;
                            lifetime = 25f;
                            baseLength = 8;
                            cone = 65;
                            interp = Interp.circleOut;
                            colorFrom = colorTo = Color.valueOf("ff9c5a");
                            strokeFrom = 2.5f;
                            lenFrom = 9;
                            lenTo = 0f;
                        }};
                    }};
                    colors = new Color[]{Color.valueOf("ec745855"), Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                }};
            }});
            weapons.add(new Weapon("engine-1"){{
                parentizeEffects = continuous = ignoreRotation = true;
                alternate = display = rotate = false;
                mirror = true;
                baseRotation = 147.7f;
                x = -12.5f;
                y = -8;
                reload = 400;
                shootCone  = 360;
                shootY = 0;
                shootSound = Sounds.none;
                bullet = new ContinuousFlameBulletType(){{
                    recoil = -0.1f;
                    maxRange = 150;
                    lifetime = 140;
                    damage = 4;
                    width = 6.3f;
                    layer = Layer.effect;
                    drawFlare = collides = collidesTiles = false;
                    length = 25;
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
                            lifetime = 25f;
                            baseLength = 8;
                            cone = 25;
                            interp = Interp.circleOut;
                            colorFrom = colorTo = Color.valueOf("ff9c5a");
                            strokeFrom = 2;
                            lenFrom = 6;
                            lenTo = 0f;
                        }};
                    }};
                    colors = new Color[]{Color.valueOf("ec745855"), Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                }};
            }});
            weapons.add(new Weapon("engine-2"){{
                parentizeEffects = continuous = ignoreRotation = true;
                alternate = display = rotate = false;
                reload = 400;
                mirror = true;
                baseRotation = 162.7f;
                shootStatus = StatusEffects.unmoving;
                shootStatusDuration = 200;
                shootCone = 360;
                x = -19.5f;
                y = -6.25f;
                shootY = 0;
                shootSound = Sounds.none;
                bullet = new ContinuousFlameBulletType(){{
                    maxRange = 150;
                    lifetime = 140;
                    recoil = -0.1f;
                    damage = 4;
                    width = 3.3f;
                    layer = Layer.effect;
                    drawFlare = collides = collidesTiles = false;
                    length = 13;
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
                            lifetime = 25f;
                            baseLength = 8;
                            cone = 25;
                            interp = Interp.circleOut;
                            colorFrom = colorTo = Color.valueOf("ff9c5a");
                            strokeFrom = 2;
                            lenFrom = 6;
                            lenTo = 0f;
                        }};
                    }};
                    colors = new Color[]{Color.valueOf("ec745855"), Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
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
                    reload = 32f;
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
                    bullet = new ExoLaserBulletType() {{
                        damage = 115f;
                        sideWidth = 0f;
                        sideLength = 0f;
                        lightningSpacing = 17f;
                        lightningDelay = 0.12f;
                        lightningDamage = 10f;
                        lightningLength = 4;
                        lightningLengthRand = 2;
                        lightningAngleRand = 15f;
                        damageType = DamageType.energy;
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
                bullet = new ExoContinuousLaserBulletType(){{
                    hitColor = Pal.sapBullet;
                    damage = 35f;
                    damageType = DamageType.energy;
                    length = 220f;
                    hitEffect = ExoFx.hitMeltColor;
                    drawSize = 420f;
                    width = 8.6f;
                    shake = 1f;
                    largeHit = true;
                    colors = new Color[]{Pal.sapBulletBack.cpy().a(0.4f), Pal.sapBullet, Color.white};
                    despawnEffect = Fx.smokeCloud;
                    intervalBullet = new ExoLightningBulletType(){{
                        damage = 30;
                        damageType = DamageType.energy;
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
        vidar = new UnitType("vidar"){{
            constructor = LegsUnit::create;
            speed = 0.4f;
            drag = 0.12f;
            hitSize = 49f;
            hovering = true;
            allowLegStep = true;
            health = 78750;
            armor = 18f;
            rotateSpeed = 1.3f;
            legCount = 14;
            legGroupSize = 2;
            legMoveSpace = 0.7f;
            legPairOffset = 0.2f;
            legLength = 176f;
            legExtension = -24f;
            legBaseOffset = 9f;
            shadowElevation = 1f;
            groundLayer = Layer.legUnit + 0.02f;
            rippleScale = 3.4f;
            legSplashDamage = 130f;
            legSplashRange = 60f;
            targetAir = false;

            weapons.add(new Weapon(name + "-purple-mount"){{
                x = 15f;
                y = 8.75f;
                shootY = 6.25f - 1f;
                reload = 57f;
                recoil = 3f;
                rotate = true;
                shootCone = 20f;
                shootSound = Sounds.shootBig;
                shoot = new ShootSpread(4, 14f);
                parts.addAll(
                        new RegionPart("-glow"){{
                            color = Color.purple;
                            colorTo = Color.purple;
                            blending = Blending.additive;
                            outline = mirror = false;
                        }});
                bullet = new ExoShrapnelBulletType(){{
                    length = 130f;
                    damage = 310f;
                    width = 29f;
                    damageType = DamageType.thermal;
                    serrationLenScl = 7f;
                    serrationSpaceOffset = 60f;
                    serrationFadeOffset = 0f;
                    serrations = 10;
                    serrationWidth = 6f;
                    fromColor = Pal.sapBullet;
                    toColor = Pal.sapBulletBack;
                    shootEffect = smokeEffect = Fx.sparkShoot;
                }};
            }},
                    new Weapon(name + "-plasma-gunner"){{
                        x = 36.25f;
                        y = 1.25f;
                        shootY = 6.25f - 1f;
                        reload = 7f;
                        recoil = 1f;
                        rotate = true;
                        shootCone = 20f;
                        inaccuracy = 25f;
                        shoot.shots = 2;
                        shootSound = Sounds.missile;

                        bullet = new ExoMissileBulletType(){{
                            width = 10f;
                            height = 12f;
                            shrinkY = 0f;
                            speed = 3.7f;
                            damage = 15;
                            damageType = DamageType.explosive;
                            drag = -0.01f;
                            splashDamageRadius = 30f;
                            splashDamage = 55f;
                            ammoMultiplier = 5f;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                            backColor = trailColor = Pal.sapBulletBack;
                            frontColor = lightningColor = lightColor = Pal.sapBullet;
                            trailLength = 13;
                            homingRange = 80f;
                            weaveScale = 8f;
                            weaveMag = 2f;
                            lightning = 2;
                            lightningLength = 2;
                            lightningLengthRand = 1;
                            lightningCone = 15f;

                            status = StatusEffects.blasted;
                            statusDuration = 60f;
                        }};
                    }},
                new Weapon(name + "-laser"){{
                x = 26.25f;
                y = -2.25f;
                shootY = 20.5f - 4f;
                shootSound = Sounds.cannon;
                rotate = true;
                alternate = true;
                rotateSpeed = 0.9f;
                cooldownTime = 90f;
                reload = 90f;
                shake = 6f;
                recoil = 8f;
                bullet = new ExoArtilleryBulletType(){{
                    width = height = 30f;
                    damageType = DamageType.explosive;
                    splashDamage = 200;
                    damage = 100;
                    splashDamageRadius = 70;
                    sprite = "shell";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = Pal.sapBulletBack;
                    speed = 3;
                    collidesTiles = collides = true;
                    scaleLife = true;
                    lifetime = 120f;
                    hitEffect = despawnEffect = Fx.sapExplosion;
                    shootEffect = Fx.sapExplosion;
                    trailChance = 0.6f;
                    trailSize = 5;
                    trailLength = 10;
                    trailWidth = 5f;
                    hitShake = 10f;
                    lightRadius = 40f;
                    lightColor = Pal.sap;
                    lightOpacity = 0.6f;

                    status = StatusEffects.sapped;
                    statusDuration = 60f * 10;
                    fragLifeMin = 0.3f;
                    fragBullets = 14;
                    fragBullet = new ExoArtilleryBulletType(){{
                        hitEffect = Fx.sapExplosion;
                        knockback = 0.8f;
                        lifetime = 120f;
                        damageType = DamageType.explosive;
                        damage = 30;
                        speed = 2.3f;
                        width = height = 25f;
                        collidesTiles = false;
                        splashDamageRadius = 70f;
                        splashDamage = 70f;
                        backColor = Pal.sapBulletBack;
                        frontColor = lightningColor = Pal.sapBullet;
                        lightning = 2;
                        lightningLength = 5;
                        smokeEffect = Fx.shootBigSmoke2;
                        hitShake = 5f;
                        lightRadius = 30f;
                        lightColor = Pal.sap;
                        lightOpacity = 0.5f;

                        status = StatusEffects.sapped;
                        statusDuration = 60f * 10;
                    }};
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
                bullet = new ExoBasicBulletType(9f, 90){{
                width = 11f;
                height = 20f;
                damageType = DamageType.kinetic;
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
                bullet = new ExoBasicBulletType(7f, 70){{
                    width = 11f;
                    height = 20f;
                    damageType = DamageType.kinetic;
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
                bullet = new ExoBasicBulletType(7f, 70){{
                    width = 11f;
                    height = 20f;
                    damageType = DamageType.kinetic;
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
                bullet = new ExoEmpBulletType(){{
                    width = 17f;
                    height = 28f;
                    speed = 9;
                    damageType = DamageType.energy;
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
                bullet = new ExoBasicBulletType(2f, 75){{
                    width = height = 16f;
                    sprite = "mine-bullet";
                    maxRange = 50f;
                    ignoreRotation = true;
                    damageType = DamageType.explosive;
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
        thor = new ExoUnitType("thor", 1.2f, 0.85f, 1f, 0.3f, 1.1f, 1f, 1) {{
            constructor = UnitWaterMove::create;
            trailLength = 90;
            waveTrailX = 39f;
            waveTrailY = -56f;
            trailScl = 9.5f;
            health = 84000f;
            omniMovement = true;
            armor = 25f;
            speed = 0.53f;
            accel = 0.2f;
            drag = 0.4f;
            hitSize = 80f;
            rotateSpeed = 0.5f;
            faceTarget = false;
            weapons.add(new Weapon("exogenesis-thor-hammer-mount"){{
                reload = 36f;
                mirror = alternate = false;
                rotate = true;
                rotateSpeed = 1.5f;
                x = -23.25f;
                y = -12;
                layerOffset = 1;
                shoot = new ShootBarrel(){{
                    shots = 2;
                    barrels = new float[]{
                            5.5f, 15.5f, 0f,
                            -5.5f, 15.5f, 0f,
                    };
                }};
                shootSound = Sounds.bolt;
                recoil = 0;
                shake = 1f;
                parts.add(
                        new RegionPart("-barrels"){{
                            mirror = false;
                            recoilIndex = 1;
                            progress = PartProgress.recoil;
                            moveY = -3f;
                        }}
                );
                bullet = new ExoRailBulletType(){{
                    length = 300f;
                    damage = 138f;
                    damageType = DamageType.pierce;
                    hitColor = Pal.heal;
                    shootEffect = Fx.shootBigColor;
                    hitEffect = Fx.hitBulletColor;
                    pierceDamageFactor = 0.8f;
                    smokeEffect = Fx.colorSpark;
                    endEffect = new Effect(14f, e -> {
                        color(e.color);
                        Drawf.tri(e.x, e.y, e.fout() * 3f, 5f, e.rotation);
                    });
                    lineEffect = new Effect(20f, e -> {
                        if(!(e.data instanceof Vec2 v)) return;

                        color(e.color);
                        stroke(e.fout() * 1.1f + 0.6f);

                        Fx.rand.setSeed(e.id);
                        for(int i = 0; i < 7; i++){
                            Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                            Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                        }

                        e.scaled(14f, b -> {
                            stroke(b.fout() * 3f);
                            color(e.color);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                    });
                }};
            }});
            weapons.add(new Weapon("exogenesis-thor-hammer-mount"){{
                reload = 36.1f;
                mirror = alternate = false;
                rotate = true;
                rotateSpeed = 1.5f;
                x = -23.25f;
                y = 24.75f;
                layerOffset = 1;
                shoot = new ShootBarrel(){{
                    shots = 2;
                    barrels = new float[]{
                            5.5f, 15.5f, 0f,
                            -5.5f, 15.5f, 0f,
                    };
                }};
                shootSound = Sounds.bolt;
                recoil = 0;
                shake = 1f;
                parts.add(
                        new RegionPart("-barrels"){{
                            mirror = false;
                            recoilIndex = 1;
                            progress = PartProgress.recoil;
                            moveY = -3f;
                        }}
                );
                bullet = new ExoRailBulletType(){{
                    length = 300f;
                    damage = 138f;
                    damageType = DamageType.pierce;
                    hitColor = Pal.heal;
                    shootEffect = Fx.shootBigColor;
                    hitEffect = endEffect = Fx.hitBulletColor;
                    pierceDamageFactor = 0.8f;
                    smokeEffect = Fx.colorSpark;
                    endEffect = new Effect(14f, e -> {
                        color(e.color);
                        Drawf.tri(e.x, e.y, e.fout() * 3f, 5f, e.rotation);
                    });
                    lineEffect = new Effect(20f, e -> {
                        if(!(e.data instanceof Vec2 v)) return;

                        color(e.color);
                        stroke(e.fout() * 1.1f + 0.6f);

                        Fx.rand.setSeed(e.id);
                        for(int i = 0; i < 7; i++){
                            Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                            Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                        }

                        e.scaled(14f, b -> {
                            stroke(b.fout() * 3f);
                            color(e.color);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                    });
                }};
            }});
            weapons.add(new Weapon("exogenesis-thor-hammer-mount"){{
                reload = 36.2f;
                mirror = alternate = false;
                rotate = true;
                rotateSpeed = 1.5f;
                x = -23.25f;
                y = 51.5f;
                layerOffset = 1;
                shoot = new ShootBarrel(){{
                    shots = 2;
                    barrels = new float[]{
                            5.5f, 15.5f, 0f,
                            -5.5f, 15.5f, 0f,
                    };
                }};
                shootSound = Sounds.bolt;
                recoil = 0;
                shake = 1f;
                parts.add(
                        new RegionPart("-barrels"){{
                            mirror = false;
                            recoilIndex = 1;
                            progress = PartProgress.recoil;
                            moveY = -3f;
                        }}
                );
                bullet = new ExoRailBulletType(){{
                    length = 300f;
                    damage = 138f;
                    damageType = DamageType.pierce;
                    hitColor = Pal.heal;
                    shootEffect = Fx.shootBigColor;
                    hitEffect = endEffect = Fx.hitBulletColor;
                    pierceDamageFactor = 0.8f;
                    smokeEffect = Fx.colorSpark;
                    endEffect = new Effect(14f, e -> {
                        color(e.color);
                        Drawf.tri(e.x, e.y, e.fout() * 3f, 5f, e.rotation);
                    });
                    lineEffect = new Effect(20f, e -> {
                        if(!(e.data instanceof Vec2 v)) return;

                        color(e.color);
                        stroke(e.fout() * 1.1f + 0.6f);

                        Fx.rand.setSeed(e.id);
                        for(int i = 0; i < 7; i++){
                            Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                            Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                        }

                        e.scaled(14f, b -> {
                            stroke(b.fout() * 3f);
                            color(e.color);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                    });
                }};
            }});
            weapons.add(new Weapon("exogenesis-thor-hammer-mount"){{
                reload = 36.3f;
                mirror = alternate = false;
                rotate = true;
                rotateSpeed = 1.5f;
                x = -23.25f;
                y = 71.5f;
                layerOffset = 1;
                shoot = new ShootBarrel(){{
                    shots = 2;
                    barrels = new float[]{
                            5.5f, 15.5f, 0f,
                            -5.5f, 15.5f, 0f,
                    };
                }};
                shootSound = Sounds.bolt;
                recoil = 0;
                shake = 1f;
                parts.add(
                        new RegionPart("-barrels"){{
                            mirror = false;
                            recoilIndex = 1;
                            progress = PartProgress.recoil;
                            moveY = -3f;
                        }}
                );
                bullet = new ExoRailBulletType(){{
                    length = 300f;
                    damage = 138f;
                    damageType = DamageType.pierce;
                    hitColor = Pal.heal;
                    shootEffect = Fx.shootBigColor;
                    hitEffect = endEffect = Fx.hitBulletColor;
                    pierceDamageFactor = 0.8f;
                    smokeEffect = Fx.colorSpark;
                    endEffect = new Effect(14f, e -> {
                        color(e.color);
                        Drawf.tri(e.x, e.y, e.fout() * 3f, 5f, e.rotation);
                    });
                    lineEffect = new Effect(20f, e -> {
                        if(!(e.data instanceof Vec2 v)) return;

                        color(e.color);
                        stroke(e.fout() * 1.1f + 0.6f);

                        Fx.rand.setSeed(e.id);
                        for(int i = 0; i < 7; i++){
                            Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                            Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                        }

                        e.scaled(14f, b -> {
                            stroke(b.fout() * 3f);
                            color(e.color);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                    });
                }};
            }});
            weapons.add(new Weapon("exogenesis-thor-weapon") {{
                reload = 360f;
                mirror = false;
                x = -21.5f;
                y = -46;
                rotateSpeed = 0.5f;
                shootSound = ExoSounds.funnylaserloop;
                shootY = 5;
                recoil = 4;
                rotate = continuous = true;
                cooldownTime = 200;
                shake = 4f;
                parts.addAll(
                        new FlarePart(){{
                            progress = PartProgress.life;
                            color1 = Pal.heal;
                            color2 = Color.white;
                            spinSpeed = 0.6f;
                            radius = 0f;
                            stroke = 4;
                            radiusTo = 100f;
                            layer = 109;
                            y = 5;
                        }}
                );
                bullet = new AcceleratingLaserBulletType(90f){{
                    lifetime = 280f;
                    maxLength = 430f;
                    maxRange = 430f;
                    oscOffset = 0.3f;
                    shootEffect = ExoFx.colorBomb;
                    width = 16f;
                    damageType = DamageType.energy;
                    collisionWidth = 7f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                    pierceCap = 3;
                    hitEffect = ExoFx.ullarTipHit;
                    hitColor = Pal.heal;
                }};
            }});
        }};

        soul = new ExoUnitType("soul", 1.2f, 0.85f, 1f, 0.3f, 1.1f, 1f, 1) {{
            constructor = MechUnit::create;
            outlineColor = ExoPal.empyreanOutline;
            speed = 2.8f;
            hitSize = 10f;
            health = 760f;
            drag = 0.08f;
            mechStepParticles = true;
            singleTarget = true;
            stepShake = 1f;
            drawCell = false;
            faceTarget = true;
            armor = 5;
            rotateSpeed = 2.7f;
            weapons.add(new Weapon("soulx") {{
                reload = 20f;
                mirror = true;
                x = y = 0;
                shootSound = Sounds.bolt;
                recoil = 1;
                shake = 1f;
                parts.addAll(
                        new RegionPart("-arm"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            moveRot = 8;
                            x = 2f;
                            y = 0f;
                            layerOffset = -0.0001f;
                        }}
                );
                bullet = new ExoBasicBulletType(8,15){{
                    width = 7f;
                    height = 13f;
                    sprite = "missile";
                    homingPower = 0.0878f;
                    homingRange = 60;
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyreanblueLight;
                    lifetime = 16f;
                    damageType = DamageType.kinetic;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    shootEffect = ExoFx.colorSparkShoot;
                    trailLength = 10;
                    trailWidth = 2f;
                }};
            }});
            weapons.add(new Weapon("soulx") {{
                reload = 20.1f;
                mirror = true;
                x = y = 0;
                shootSound = Sounds.bolt;
                recoil = 1;
                shake = 1f;
                parts.addAll(
                        new RegionPart("-arm"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            moveRot = 15;
                            x = 2f;
                            y = 0f;
                            layerOffset = -0.0001f;
                        }}
                );
                bullet = new ExoBasicBulletType(8,15){{
                    width = 7f;
                    height = 13f;
                    sprite = "missile";
                    homingPower = 0.0878f;
                    homingRange = 60;
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyreanblueLight;
                    lifetime = 16f;
                    damageType = DamageType.kinetic;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    shootEffect = ExoFx.colorSparkShoot;
                    trailLength = 10;
                    trailWidth = 2f;
                }};
            }});
            weapons.add(new Weapon("soulx") {{
                reload = 20.2f;
                mirror = true;
                x = y = 0;
                shootSound = Sounds.bolt;
                recoil = 1;
                shake = 1f;
                parts.addAll(
                        new RegionPart("-arm"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            moveRot = 21;
                            x = 2f;
                            y = 0f;
                            layerOffset = -0.0001f;
                        }}
                );
                bullet = new ExoBasicBulletType(8,15){{
                    width = 7f;
                    height = 13f;
                    sprite = "missile";
                    homingPower = 0.0878f;
                    homingRange = 60;
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyreanblueLight;
                    lifetime = 16f;
                    damageType = DamageType.kinetic;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    shootEffect = ExoFx.colorSparkShoot;
                    trailLength = 10;
                    trailWidth = 2f;
                }};
            }});
        }};
        pneuma = new ExoUnitType("pneuma", 1.2f, 1.1f, 0.6f, 0.6f, 1.1f, 1f, 1){{
            constructor = MechUnit::create;
            outlineColor = ExoPal.empyreanOutline;
            speed = 2.4f;
            hitSize = 17f;
            health = 1460f;
            drag = 0.08f;
            drawCell = false;
            faceTarget = true;
            armor = 7;
            rotateSpeed = 2.3f;
            weapons.add(new Weapon("glimmer") {{
                reload = 5f;
                mirror = true;
                x = 4;
                y = 3;
                shootSound = Sounds.bolt;
                showStatSprite = false;
                recoil = 0;
                shake = 1f;
                bullet = new ExoBasicBulletType(9f, 12){{
                    width = 8f;
                    height = 17f;
                    damageType = DamageType.energy;
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
        psyche = new ExoUnitType("psyche", 1.1f, 0.85f, 1f, 0.1f, 1.1f, 1f, 1){{
            constructor = MechUnit::create;
            outlineColor = ExoPal.empyreanOutline;
            speed = 2.2f;
            hitSize = 27f;
            health = 2060f;
            drag = 0.08f;
            drawCell = false;
            faceTarget = true;
            armor = 10;
            rotateSpeed = 2.3f;
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
                bullet = new ExoBasicBulletType(8f, 45){{
                    width = height = 10f;
                    sprite = "circle-bullet";
                    damageType = DamageType.energy;
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
        pemptousia = new ExoUnitType("pemptousia", 1.3f, 0.35f, 1f, 0.7f, 1.3f, 1f, 1){{
            constructor = MechUnit::create;
            outlineColor = ExoPal.empyreanOutline;
            speed = 2.2f;
            hitSize = 37f;
            health = 8860f;
            drag = 0.08f;
            drawCell = false;
            faceTarget = true;
            armor = 14;
            rotateSpeed = 2.3f;
            weapons.add(new Weapon("auric-blast") {{
                reload = 220f;
                mirror = false;
                x = 0;
                y = 6;
                shoot.firstShotDelay = 80;
                shootStatusDuration = 90;
                shootStatus = StatusEffects.unmoving;
                shootSound = Sounds.malignShoot;
                showStatSprite = false;
                recoil = 0;
                shake = 1f;
                bullet = new ExoBasicBulletType(1.5f, 185){{
                    width = height = 45;
                    sprite = "exogenesis-plasma";
                    scaleLife = false;
                    chargeEffect = ExoFx.auricCharge;
                    damageType = DamageType.energy;
                    hitSound = Sounds.explosionbig;
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    trailEffect = new Effect(13f, e -> {
                        color(ExoPal.empyrean);
                        for(int s : Mathf.signs){
                            Drawf.tri(e.x, e.y, 2.5f, 26f * e.fslope(), e.rotation + 90f*s);
                            Drawf.tri(e.x, e.y, 1.8f, 14f * e.fslope(), e.rotation + 50f*s);
                            Drawf.tri(e.x, e.y, 1.8f, 14f * e.fslope(), e.rotation + -50f*s);
                        }
                    });
                    trailRotation = true;
                    trailInterval = 3f;
                    lifetime = 165f;
                    splashDamage = 100;
                    splashDamageRadius = 70;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = new MultiEffect(ExoFx.empyreanExplosion, ExoFx.blastcolor);
                    intervalBullet = new ExoBasicBulletType(4f, 25){{
                        width = height = 7f;
                        damageType = DamageType.energy;
                        sprite = "circle-bullet";
                        frontColor = Color.white;
                        backColor = hitColor = trailColor = ExoPal.empyrean;
                        lifetime = 24f;
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
                    intervalBullet = new ChainLightningBulletType() {{
                        lightningColor = ExoPal.empyrean;
                        damageType = DamageType.energy;
                        range = 215;
                        targetRange = 160;
                        damage = 50;
                        distanceDamageFalloff = 4;
                        chainLightning = 2;
                        segmentLength = 6;
                    }};
                    lightning = 7;
                    lightningLength = 9;
                    lightningColor = ExoPal.empyrean;
                    lightningDamage = 11;
                    shootEffect = Fx.lightningShoot;
                    trailSinScl = 2;
                    trailSinMag = 0.8f;
                    trailParam = 5;
                    trailLength = 10;
                    trailWidth = 10f;
                }};
            }});
        }};
        myalo = new ExoUnitType("myalo", 0.3f, 0.85f, 0.3f, 1.3f, 0.6f, 1f, 1){{
            constructor = MechUnit::create;
            outlineColor = ExoPal.empyreanOutline;
            speed = 2f;
            hitSize = 37f;
            health = 28560f;
            drag = 0.08f;
            drawCell = false;
            faceTarget = true;
            armor = 19;
            rotateSpeed = 2.2f;
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
        lux = new ExoUnitType("lux", 1.2f, 0.85f, 1f, 0.3f, 1.1f, 1f, 1) {{
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
                bullet = new ExoBasicBulletType(8,15){{
                    width = 7f;
                    height = 13f;
                    sprite = "missile";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    lifetime = 16f;
                    damageType = DamageType.energy;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    shootEffect = ExoFx.colorSparkShoot;
                    trailLength = 10;
                    trailWidth = 2f;
                }};
            }});
        }};
        glimmer = new ExoUnitType("glimmer", 1.2f, 1.1f, 0.6f, 0.6f, 1.1f, 1f, 1){{
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
                bullet = new ExoBasicBulletType(9f, 12){{
                    width = 8f;
                    height = 17f;
                    damageType = DamageType.energy;
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
        shine = new ExoUnitType("shine", 1.1f, 0.85f, 1f, 0.1f, 1.1f, 1f, 1){{
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
                bullet = new ExoBasicBulletType(8f, 45){{
                    width = height = 10f;
                    sprite = "circle-bullet";
                    damageType = DamageType.energy;
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
        auric = new ExoUnitType("auric", 1.3f, 0.35f, 1f, 0.7f, 1.3f, 1f, 1){{
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
            lowAltitude = false;
            armor = 8;
            trailLength = 8;
            trailColor = engineColor = ExoPal.empyrean;
            rotateSpeed = 2.6f;
            engineSize = 0;
            engineOffset = 0;
            parts.addAll(
            new RegionPart("-mandible"){{
              moves.add(new PartMove(PartProgress.charge.curve(Interp.circleIn), 0, 0, -50));
              moves.add(new PartMove(PartProgress.recoil.curve(Interp.pow2In), 0, 0, -50));
              mirror = true;
              under = true;
              x = 20.75f;
              y = 1.25f;
              layerOffset = -0.0001f;
              heatProgress = PartProgress.charge.curve(Interp.circleIn);
              }}
              );
            setEnginesMirror(
                    new UnitEngine(19.5f, -18, 5f, 315f),
                    new UnitEngine(9.5f, -25, 3f, 315f)
            );
            weapons.add(new Weapon("auric-blast") {{
                reload = 220f;
                mirror = false;
                x = 0;
                y = 6;
                shoot.firstShotDelay = 80;
                shootStatusDuration = 90;
                shootStatus = StatusEffects.unmoving;
                shootSound = Sounds.malignShoot;
                showStatSprite = false;
                recoil = 0;
                shake = 1f;
                bullet = new ExoBasicBulletType(1.5f, 185){{
                    width = height = 45;
                    sprite = "exogenesis-plasma";
                    scaleLife = false;
                    chargeEffect = ExoFx.auricCharge;
                    damageType = DamageType.energy;
                    hitSound = Sounds.explosionbig;
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    trailEffect = new Effect(13f, e -> {
                        color(ExoPal.empyrean);
                        for(int s : Mathf.signs){
                            Drawf.tri(e.x, e.y, 2.5f, 26f * e.fslope(), e.rotation + 90f*s);
                            Drawf.tri(e.x, e.y, 1.8f, 14f * e.fslope(), e.rotation + 50f*s);
                            Drawf.tri(e.x, e.y, 1.8f, 14f * e.fslope(), e.rotation + -50f*s);
                        }
                    });
                    trailRotation = true;
                    trailInterval = 3f;
                    lifetime = 165f;
                    splashDamage = 100;
                    splashDamageRadius = 70;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = new MultiEffect(ExoFx.empyreanExplosion, ExoFx.blastcolor);
                    intervalBullet = new ExoBasicBulletType(4f, 25){{
                        width = height = 7f;
                        damageType = DamageType.energy;
                        sprite = "circle-bullet";
                        frontColor = Color.white;
                        backColor = hitColor = trailColor = ExoPal.empyrean;
                        lifetime = 24f;
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
                    intervalBullet = new ChainLightningBulletType() {{
                        lightningColor = ExoPal.empyrean;
                        damageType = DamageType.energy;
                        range = 215;
                        targetRange = 160;
                        damage = 50;
                        distanceDamageFalloff = 4;
                        chainLightning = 2;
                        segmentLength = 6;
                    }};
                    lightning = 7;
                    lightningLength = 9;
                    lightningColor = ExoPal.empyrean;
                    lightningDamage = 11;
                    shootEffect = Fx.lightningShoot;
                    trailSinScl = 2;
                    trailSinMag = 0.8f;
                    trailParam = 5;
                    trailLength = 10;
                    trailWidth = 10f;
                }};
            }});
        }};
        radiance = new ExoUnitType("radiance", 0.3f, 0.85f, 0.3f, 1.3f, 0.6f, 1f, 1){{
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
        prayer = new ExoUnitType("prayer", 1.2f, 0.85f, 1f, 1f, 1.1f, 1f, 1){{
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
            trailColor = engineColor = ExoPal.empyreanIndigo;
            rotateSpeed = 3.7f;
            engineSize = 1.7f;
            engineOffset = 8;
            parts.add(
                    new ShapePart() {{
                        mirror = true;
                        progress = PartProgress.warmup;
                        circle = true;
                        hollow = true;
                        layer = Layer.effect;
                        y = 0f;
                        color = ExoPal.empyreanIndigo;
                        stroke = strokeTo = 1.4f;
                        radiusTo = radius = 11f;
                    }},
                    new HaloPart() {{
                        y = 0f;
                        radius = 2.5f;
                        tri = true;
                        color = ExoPal.empyreanIndigo;
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
                laserColor = healColor = ExoPal.empyreanIndigo;
                targetBuildings = true;
                beamWidth = 0.8f;
                repairSpeed = 1.7f;
                bullet = new BulletType(){{
                    maxRange = 120f;
                }};
            }});
        }};
        apprise = new ExoUnitType("apprise", 1.3f, 0.85f, 1f, 1f, 1.1f, 1f, 1) {{
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
            trailColor = engineColor = ExoPal.empyreanIndigo;
            rotateSpeed = 3.4f;
            engineSize = 2.5f;
            engineOffset = 13;
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
                    backColor = hitColor = trailColor = ExoPal.empyreanIndigo;
                    lifetime = 16;
                    hitEffect = despawnEffect = ExoFx.colorBombSmaller;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                }};
            }});
        }};
        revelation = new ExoUnitType("revelation", 1.2f, 0.85f, 1f, 0.3f, 1.1f, 1f, 1) {{
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
            engineOffset = 15;
            trailLength = 8;
            trailColor = engineColor = ExoPal.empyreanIndigo;
            weapons.add(new Weapon("revelation-zap") {{
                reload = 50f;
                mirror = false;
                y = 18;
                x = 0;
                rotate = true;
                rotateSpeed = 5.5f;
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
                color1 = ExoPal.empyreanIndigo;
                radius = 8.5f;
                }}
                );
                bullet = new ChainLightningBulletType() {{
                    lightningColor = ExoPal.empyreanIndigo;
                    damageType = DamageType.energy;
                    range = 250;
                    targetRange = 100;
                    damage = 40;
                    distanceDamageFalloff = 4;
                    chainLightning = 2;
                    segmentLength = 6;
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
                            color1 = ExoPal.empyreanIndigo;
                            radius = 7f;
                        }}
                );
                bullet = new ChainLightningBulletType() {{
                    lightningColor = ExoPal.empyreanIndigo;
                    damageType = DamageType.energy;
                    range = 250;
                    targetRange = 100;
                    damage = 40;
                    distanceDamageFalloff = 4;
                    chainLightning = 2;
                    segmentLength = 6;
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
                            color1 = ExoPal.empyreanIndigo;
                            radius = 7f;
                        }}
                );
                bullet = new ChainLightningBulletType() {{
                    lightningColor = ExoPal.empyreanIndigo;
                    damageType = DamageType.energy;
                    range = 250;
                    targetRange = 100;
                    damage = 40;
                    distanceDamageFalloff = 4;
                    chainLightning = 2;
                    segmentLength = 6;
                }};
            }});
        }};
        enlightenment = new ExoUnitType("enlightenment", 1.2f, 0.85f, 1f, 0.3f, 1.1f, 1.1f, 1) {{
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
            trailColor = engineColor = ExoPal.empyreanIndigo;
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
                    backColor = hitColor = trailColor = ExoPal.empyreanIndigo;
                    lifetime = 45f;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = Fx.flakExplosionBig;
                    lightning = 7;
                    lightningLength = 9;
                    lightningColor = ExoPal.empyreanIndigo;
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
        excelsus = new ExoUnitType("excelsus", 0.9f, 0.9f, 1.3f, 0.2f, 1.15f, 1f, 1f) {{
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
            trailColor = engineColor = ExoPal.empyreanIndigo;
            rotateSpeed = 2.4f;
            engineSize = 4;
            engineOffset = 22;
            abilities.add(new EnergyFieldAbility(40f, 65f, 0f){{
                status = StatusEffects.none;
                color = ExoPal.empyreanIndigo;
                rotateSpeed = 3;
                effectRadius = 5;
                maxTargets = 0;
            }});
            abilities.add(new EnergyFieldAbility(40f, 65f, 0f){{
                status = StatusEffects.none;
                color = ExoPal.empyreanIndigo;
                effectRadius = rotateSpeed = 3;
                x = 15;
                y = -11;
                maxTargets = 0;
            }});
            abilities.add(new EnergyFieldAbility(40f, 65f, 0f){{
                status = StatusEffects.none;
                color = ExoPal.empyreanIndigo;
                effectRadius = rotateSpeed = 3;
                x = -15;
                y = -11;
                maxTargets = 0;
            }});
            setEnginesMirror(
                    new UnitEngine(0, -29, 5f, 0f)
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
                    hitColor = ExoPal.empyreanIndigo;
                    damage = 35f;
                    length = 150f;
                    hitEffect = ExoFx.hitMeltColor;
                    drawSize = 420f;
                    width = 7.6f;
                    shake = 1f;
                    largeHit = false;
                    colors = new Color[]{ExoPal.empyreanIndigoDark.a(0.4f), ExoPal.empyreanIndigo, Color.white};
                    despawnEffect = Fx.smokeCloud;
                    intervalBullet = new ChainLightningBulletType() {{
                        lightningColor = ExoPal.empyreanIndigo;
                        damageType = DamageType.energy;
                        range = 155;
                        collidesTeam = false;
                        targetRange = 155;
                        damage = 100;
                        distanceDamageFalloff = 4;
                        chainLightning = 2;
                        segmentLength = 6;
                    }};
                    intervalRandomSpread = 20;
                    intervalBullets = 1;
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