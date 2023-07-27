package Exogenesis.content;

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
    public static UnitType orion, lux, glimmer, shine;
    public static void load() {
        lux = new UnitType("lux") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
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
            rotateSpeed = 2.7f;
            engineSize = 3;
            engineOffset = 0;
            weapons.add(new Weapon("lux") {{
                reload = 40f;
                mirror = false;
                x = 0;
                shoot = new  ShootHelix(){{
                    mag = 7.4f;
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
                        stroke = 1f;
                        strokeTo = 1f;
                        radiusTo = 3f;
                        radius = 3f;
                        }},
                        new HaloPart() {{
                            y = 0f;
                            radius = 1.5f;
                            tri = true;
                            color = ExoPal.empyrean;
                            layer = Layer.effect;
                            haloRotateSpeed = -2.5f;
                            haloRadius = 3f;
                            haloRadiusTo = 3f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = 4f;
                            triLength = 4f;
                        }},
                        new HaloPart() {{
                            y = 0f;
                            radius = 1.5f;
                            tri = true;
                            color = ExoPal.empyrean;
                            layer = Layer.effect;
                            haloRotateSpeed = 2.5f;
                            haloRadius = 3f;
                            haloRadiusTo = 3f;
                            stroke = 0f;
                            strokeTo = 2f;
                            shapes = 2;
                            triLengthTo = 4f;
                            triLength = 4f;
                        }}
                );
                bullet = new BasicBulletType(8f, 25){{
                    width = 7f;
                    height = 13f;
                    sprite = "missile";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    lifetime = 22f;
                    shrinkY = shrinkX = 0;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    shootEffect = Fx.lightningShoot;
                    trailLength = 10;
                    trailWidth = 2f;
                }};
            }});
        }};
        glimmer = new UnitType("glimmer") {{
            constructor = UnitEntity::create;
            outlineColor = ExoPal.empyreanOutline;
            speed = 3.4f;
            hitSize = 16f;
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
            rotateSpeed = 2.4f;
            engineSize = 3;
            engineOffset = 5;
            parts.add(
                    new ShapePart() {{
                        mirror = false;
                        progress = PartProgress.warmup;
                        circle = true;
                        layer = Layer.effect;
                        y = -5f;
                        color = ExoPal.empyrean;
                        stroke = 1f;
                        strokeTo = 1f;
                        radiusTo = 3f;
                        radius = 3f;
                    }},
                    new HaloPart() {{
                        y = -5f;
                        radius = 1.5f;
                        tri = true;
                        color = ExoPal.empyrean;
                        layer = Layer.effect;
                        haloRotateSpeed = -2.5f;
                        haloRadius = 3f;
                        haloRadiusTo = 3f;
                        stroke = 0f;
                        strokeTo = 2f;
                        shapes = 2;
                        triLengthTo = 4f;
                        triLength = 4f;
                    }},
                    new HaloPart() {{
                        y = -5f;
                        radius = 1.5f;
                        tri = true;
                        color = ExoPal.empyrean;
                        layer = Layer.effect;
                        haloRotateSpeed = 2.5f;
                        haloRadius = 3f;
                        haloRadiusTo = 3f;
                        stroke = 0f;
                        strokeTo = 2f;
                        shapes = 2;
                        triLengthTo = 4f;
                        triLength = 4f;
                    }}
            );
            weapons.add(new Weapon("glimmer") {{
                reload = 5f;
                mirror = true;
                x = 5;
                y = 5;
                shootSound = Sounds.bolt;
                showStatSprite = false;
                recoil = 0;
                shake = 1f;
                bullet = new BasicBulletType(9f, 25){{
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

                    fragBullet = new BasicBulletType(8f, 15){{
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
            speed = 4f;
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
            trailLength = 8;
            trailColor = ExoPal.empyrean;
            rotateSpeed = 2.7f;
            engineSize = 0;
            engineOffset = 0;
            setEnginesMirror(
            new UnitEngine(3, -6, 2f, 315f)
            );
            weapons.add(new Weapon("shine") {{
                reload = 60f;
                mirror = false;
                x = 0;
                shoot = new  ShootPattern(){{
                    shotDelay = 2f;
                    shots = 3;
                }};
                shootSound = Sounds.laser;
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
                            stroke = 1f;
                            strokeTo = 1f;
                            radiusTo = 4.5f;
                            radius = 4.5f;
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
                            triLengthTo = 4f;
                            triLength = 4f;
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
                            triLengthTo = 5.5f;
                            triLength = 5.5f;
                        }}
                );
                bullet = new BasicBulletType(8f, 25){{
                    width = height = 10f;
                    sprite = "circle-bullet";
                    frontColor = Color.white;
                    backColor = hitColor = trailColor = ExoPal.empyrean;
                    lifetime = 35f;
                    weaveMag = 3;
                    weaveScale = 2;
                    shrinkY = shrinkX = 0;
                    trailEffect = new Effect(13f, e -> {
                        color(ExoPal.empyrean);
                        for(int s : Mathf.signs){
                            Drawf.tri(e.x, e.y, 4f, 20f * e.fslope(), e.rotation + 90f*s);
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
                            radiusTo = 3f;
                            radius = 3f;
                        }},
                        new HaloPart() {{
                            y = 3f;
                            radius = 2f;
                            tri = true;
                            color = Color.valueOf("66B1FF");
                            layer = Layer.effect;
                            haloRotateSpeed = -1f;
                            haloRadius = 3f;
                            haloRadiusTo = 3f;
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
                            haloRadius = 3f;
                            haloRadiusTo = 3f;
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
                    length = 2.5f;
                    baseLength = 2.5f;
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