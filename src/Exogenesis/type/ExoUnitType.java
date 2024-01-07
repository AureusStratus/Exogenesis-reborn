package Exogenesis.type;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.struct.ObjectMap;
import arc.util.Scaling;
import arc.util.Strings;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.ui.Styles;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import mindustry.world.meta.StatValues;

public class ExoUnitType extends UnitType{
    public float[] multipliers;

    public ExoUnitType(String name, float kinetic, float explosive, float pierce, float energy, float thermal, float cryogenic, float nuclear){
        super(name);
        multipliers = new float[]{kinetic, explosive, pierce, energy, thermal, cryogenic, nuclear};
    }

    @Override
    public void setStats(){
        stats.add(ExoStats.typeDamage, ExoStats.damageTypes(multipliers)); //add the multiplier table to stats

        super.setStats(); //use the setStats() of the class that's being extended, so UnitType

        stats.remove(Stat.weapons);
        stats.add(Stat.weapons, table -> { //StatValues.weapons merged with weapon stats (with a single change)
            table.row();
            for(int i = 0; i < weapons.size; i++){
                Weapon weapon = weapons.get(i);

                if(weapon.flipSprite || !weapon.hasStats(this)){
                    continue;
                }

                TextureRegion region = !weapon.name.isEmpty() ? Core.atlas.find(weapon.name + "-preview", weapon.region) : null;

                table.table(Styles.grayPanel, w -> {
                    w.left().top().defaults().padRight(3).left();
                    if(region != null && region.found() && weapon.showStatSprite) w.image(region).size(60).scaling(Scaling.bounded).left().top();
                    w.row();

                    if(weapon.inaccuracy > 0){
                        w.row();
                        w.add("[lightgray]" + Stat.inaccuracy.localized() + ": [white]" + (int)weapon.inaccuracy + " " + StatUnit.degrees.localized());
                    }
                    if(!weapon.alwaysContinuous && weapon.reload > 0){
                        w.row();
                        w.add("[lightgray]" + Stat.reload.localized() + ": " + (weapon.mirror ? "2x " : "") + "[white]" + Strings.autoFixed(60f / weapon.reload * weapon.shoot.shots, 2) + " " + StatUnit.perSecond.localized());
                    }

                    ExoStats.typedAmmo(ObjectMap.of(this, weapon.bullet)).display(w);
                }).growX().pad(5).margin(10);
                table.row();
            }
        });
    }
}
