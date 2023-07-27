package Exogenesis.content;

import Exogenesis.content.ExoUnitTypes;
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
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static arc.Core.*;
import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
public class ExoBlocks{
 public static Block
         excalibur,
         genesisFactory, empyreanFactory;
public static void load(){
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
   shootType = new LaserBulletType(140){{
   colors = new Color[]{ExoPal.empyrean.cpy().a(0.4f), ExoPal.empyrean, Color.white};
   buildingDamageMultiplier = 0.25f;
   hitEffect = Fx.colorSparkBig;
   hitColor = ExoPal.empyrean;
   hitSize = 4;
   lifetime = 126f;
   collidesAir = false;
   length = 270f;
  }};
 }};
 genesisFactory = new UnitFactory("genesis-factory"){{
  requirements(Category.units, with(Items.copper, 50, Items.lead, 120, Items.silicon, 80));
  plans = Seq.with(
          new UnitPlan(ExoUnitTypes.orion, 60f * 15, with(Items.silicon, 10, Items.lead, 10))
  );
  size = 3;
  consumePower(1.2f);
 }};
 empyreanFactory = new UnitFactory("empyrean-factory"){{
  requirements(Category.units, with(Items.copper, 50, Items.lead, 120, Items.silicon, 80));
  plans = Seq.with(
          new UnitPlan(ExoUnitTypes.lux, 60f * 15, with(Items.silicon, 10, Items.lead, 10))
  );
  size = 3;
  consumePower(1.2f);
 }};
}
}