package Exogenesis.content;

import Exogenesis.content.ExoUnitTypes;
import Exogenesis.world.turrets.SpeedupTurret;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.Seq;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import Exogenesis.graphics.ExoPal;
import mindustry.entities.part.*;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootPattern;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.UnitFactory;
import Exogenesis.entities.bullet.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static arc.Core.*;
import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
public class ExoBlocks{
 public static Block
         //Empyrean
         focalPoint, gale, light, bliss, tanons, glory, essence, purger,
         excalibur, emanator, godsent, eminence, grandeur, eather, aeon, arbiter, phoss,
         genesisFactory, empyreanFactory;
public static void load(){
 focalPoint = new ContinuousTurret ("focal-point"){{
  requirements(Category.turret, with(Items.copper, 60));
  range = 100f;
  recoil = 0f;
  shootEffect = ExoFx.colorBombSmaller;
  smokeEffect = Fx.none;
  heatColor = Color.red;
  outlineColor = ExoPal.empyreanOutline;
  shootY = 4;
  size = 2;
  scaledHealth = 280;
  targetAir = false;
  shootSound = Sounds.none;
  loopSoundVolume = 1f;
  loopSound = Sounds.laserbeam;

  shootWarmupSpeed = 0.08f;
  shootCone = 360f;

  aimChangeSpeed = 2.5f;
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
  shootType = new PointLaserBulletType(){{
   hitColor = trailColor = ExoPal.empyreanLight;
   color = Color.white;
   sprite = "exogenesis-focal-point-laser";
   beamEffect = Fx.none;
   trailLength = 8;
   damage = 10;
   hitEffect = ExoFx.hitMeltColor;
   smokeEffect = Fx.colorSparkBig;
  }};
 }};
 gale = new PowerTurret ("gale"){{
  requirements(Category.turret, with(Items.copper, 60));
  range = 130f;
  recoil = 2f;
  reload = 50;
  shootEffect = Fx.colorSparkBig;
  smokeEffect = Fx.none;
  outlineColor = ExoPal.empyreanOutline;
  size = 2;
  scaledHealth = 280;
  targetAir = false;
  shootSound = Sounds.bolt;
  inaccuracy = 6;
  shootWarmupSpeed = 0.08f;
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
  shootType = new FlakBulletType(){{
   backColor = hitColor = trailColor = ExoPal.empyrean;
   frontColor = Color.white;
   trailWidth = 2f;
   trailLength = 6;
   width = height = 25f;
   shrinkX = shootY = 0;
   lifetime = 40;
   speed = 6;
   spin = 4;
   splashDamageRadius = 15;
   splashDamage = 6;
   sprite = "large-bomb";
   damage = 15;
   hitEffect = despawnEffect = Fx.flakExplosion;
   fragRandomSpread = 360f;
   fragBullets = 5;
   fragVelocityMin = 1f;

   fragBullet = new BasicBulletType(8f, 9){{
    sprite = "missile";
    width = 4f;
    pierce = true;
    pierceCap = 1;
    homingRange = 30;
    homingPower = 0.075f;
    homingDelay = 2;
    height = 13f;
    lifetime = 8f;
    backColor = hitColor = trailColor = ExoPal.empyrean;
    frontColor = Color.white;
    trailWidth = 1.3f;
    trailLength = 6;
    hitEffect = despawnEffect = Fx.hitBulletColor;
   }};
  }};
 }};
 light = new SpeedupTurret("light"){{
  requirements(Category.turret, with(Items.copper, 60));
  range = 130f;
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
  targetAir = false;
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
  shootType = new RailBulletType(){{
   length = 130f;
   damage = 8f;
   hitColor = ExoPal.empyrean;
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
  requirements(Category.turret, with(Items.copper, 60));
  range = 200f;
  recoil = 2f;
  reload = 40;
  smokeEffect = Fx.none;
  outlineColor = ExoPal.empyreanOutline;
  size = 2;
  scaledHealth = 280;
  targetAir = false;
  shootSound = Sounds.laser;
  shootCone = 30f;
  shoot = new ShootSpread(){{
   shots = 5;
   spread = 10;
  }};
  rotateSpeed = 2.5f;
  coolant = consumeCoolant(0.2f);
  consumePower(6f);
  drawer = new DrawTurret("elecian-"){{
   parts.addAll(
   new FlarePart(){{
    progress = PartProgress.reload;
    color1 = ExoPal.empyrean;
    y = 6;
    radius = 10;
    radiusTo = 0;
    stroke = 2.5f;
   }}
   );
  }};
  shootType = new BasicBulletType(7f, 25f){{
   homingRange = 100;
   homingPower = 0.075f;
   homingDelay = 6;
   parts.addAll(
   new FlarePart(){{
    progress = PartProgress.life;
    color1 = ExoPal.empyrean;
    radius = 16;
    radiusTo = 16;
    stroke = 2.5f;
   }}
   );
   lifetime = 35;
   hitColor = trailColor = ExoPal.empyrean;
   trailWidth = 2f;
   trailLength = 6;
   hitEffect = despawnEffect = ExoFx.colorBombSmall;
   smokeEffect = Fx.colorSpark;
  }};
 }};
 tanons = new PowerTurret("tanons"){{
  requirements(Category.turret, with(Items.copper, 60, Items.lead, 70, Items.silicon, 60, Items.titanium, 30));
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
  targetAir = false;
  shootSound = Sounds.spark;
  coolant = consumeCoolant(0.2f);

  consumePower(6f);
  drawer = new DrawTurret("elecian-"){{
  }};
  shootType = new PosLightningType(50f){{
   lightningColor = hitColor = ExoPal.empyrean;
   maxRange = rangeOverride = 250f;
   hitEffect = Fx.circleColorSpark;
   smokeEffect = Fx.shootBigSmoke2;
  }};
 }};
 glory = new PowerTurret("glory"){{
  requirements(Category.turret, with(Items.copper, 60, Items.lead, 70, Items.silicon, 60, Items.titanium, 30));
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
  shootType = new PointBulletType(){{
   shootEffect = ExoFx.lightEnrCircleSplash;
   hitEffect = ExoFx.colorBomb;
   smokeEffect = Fx.smokeCloud;
   trailEffect = Fx.instTrail;
   despawnEffect = ExoFx.colorBombSmall;
   hitColor = ExoPal.empyrean;
   trailSpacing = 20f;
   damage = 150;
   buildingDamageMultiplier = 0.2f;
   speed = range;
   hitShake = 4f;
  }};
 }};
 essence = new SpeedupTurret("essence"){{
  requirements(Category.turret, with(Items.copper, 60));
  range = 230f;
  recoil = 2f;
  reload = 40;
  smokeEffect = Fx.none;
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
  shootType = new BasicBulletType(8f, 17){{
   lifetime = 30f;
   width = 7;
   height = 15;
   sprite = "missile-large";
   pierceArmor = true;
   shootEffect = Fx.shootBigColor;
   backColor = hitColor = trailColor = ExoPal.empyrean;
   frontColor = Color.white;
   trailWidth = 2f;
   trailLength = 6;
   hitEffect = despawnEffect = Fx.hitBulletColor;
  }};
 }};
 purger = new PowerTurret("purger"){{
  requirements(Category.turret, with(Items.copper, 60));
  range = 210f;
  recoil = 1f;
  reload = 25;
  smokeEffect = Fx.none;
  outlineColor = ExoPal.empyreanOutline;
  size = 3;
  scaledHealth = 280;
  recoils = 2;
  shootSound = Sounds.shotgun;
  inaccuracy = 1;
  shootCone = 30f;
  shootY = 10;
  shoot = new ShootAlternate(){{
   barrels = 2;
   spread = 9;
  }};
  rotateSpeed = 2f;
  coolant = consumeCoolant(0.2f);
  consumePower(6f);
  drawer = new DrawTurret("elecian-"){{
   for(int i = 0; i < 2; i ++){
    int f = i;
    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
     progress = PartProgress.recoil;
     recoilIndex = f;
     under = true;
     moveY = -3.5f;
    }});
   }
  }};
  shootType = new LaserBulletType(){{
   damage = 75f;
   sideAngle = 40f;
   sideWidth = 1.5f;
   sideLength = 50f;
   width = 25f;
   length = 210f;
   hitColor = ExoPal.empyrean;
   shootEffect = ExoFx.colorBombSmaller;
   colors = new Color[]{Color.valueOf("fee76190"), Color.valueOf("fee761"), Color.white};
  }};
 }};
 excalibur = new PowerTurret("excalibur"){{
  requirements(Category.turret, with(Items.copper, 60, Items.lead, 70, Items.silicon, 60, Items.titanium, 30));
  range = 270f;
  recoil = 2f;
  reload = 80f;
  shake = 2f;
  shootEffect = Fx.colorSparkBig;
  smokeEffect = Fx.none;
  heatColor = Color.red;
  outlineColor = ExoPal.empyreanOutline;
  size = 4;
  scaledHealth = 280;
  targetAir = false;
  shootSound = Sounds.laser;
  coolant = consumeCoolant(0.2f);

  consumePower(6f);
  drawer = new DrawTurret("elecian-"){{
   parts.addAll(
   new RegionPart("-body"){{
   progress = PartProgress.recoil;
   moveY = -5;
   mirror = false;
   }},
   new RegionPart("-plate"){{
   progress = PartProgress.recoil;
   moveRot = -8;
   mirror = true;
   }}
   );
  }};
  shootType = new LaserBulletType(){{
   damage = 175f;
   sideAngle = 20f;
   sideWidth = 1.5f;
   sideLength = 50f;
   width = 45f;
   length = 270f;
   hitColor = ExoPal.empyrean;
   shootEffect = ExoFx.colorBombSmall;
   colors = new Color[]{Color.valueOf("fee76190"), Color.valueOf("fee761"), Color.white};
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