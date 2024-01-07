package Exogenesis.content;

import Exogenesis.type.DamageType;
import Exogenesis.type.unit.TypeMultiplierUnitType;
import Exogenesis.world.meta.ExoStats;
import arc.struct.ObjectMap;
import arc.util.Structs;
import mindustry.Vars;
import mindustry.type.UnitType;

import static mindustry.content.UnitTypes.*;

public class TypeMultipliers{
    public static ObjectMap<UnitType, float[]> map = new ObjectMap<>(32);

    public static void load(){
        addMultipliers(reign, 1f, 1f, 400f, 1f, 1f, 1f, 1f);

        ExoStats.addTypeStatsUnit();
    }

    /**Compatible with other mods.*/
    public static void addMultipliers(String name, float kinetic, float explosive, float pierce, float energy, float thermal, float cryogenic, float radiation){
        if(Vars.content.unit(name) != null){
            map.put(Vars.content.unit(name), new float[]{kinetic, explosive, pierce, energy, thermal, cryogenic, radiation});
        }
    }

    public static void addMultipliers(UnitType unit, float kinetic, float explosive, float pierce, float energy, float thermal, float cryogenic, float radiation){
        map.put(unit, new float[]{kinetic, explosive, pierce, energy, thermal, cryogenic, radiation});
    }

    public static float getMultiplier(UnitType unit, DamageType type){
        int index = Structs.indexOf(DamageType.values(), type);

        if(unit instanceof TypeMultiplierUnitType u){
            return u.multipliers()[index];
        }else if(map.containsKey(unit)){
            return map.get(unit)[index];
        }

        return 1f;
    }

    public static float[] getMultipliers(UnitType unit){
        if(unit instanceof TypeMultiplierUnitType u){
            return u.multipliers();
        }else if(map.containsKey(unit)){
            return map.get(unit);
        }

        return null;
    }
}
