package Exogenesis.type;

import mindustry.type.*;

public class ExoUnitType extends UnitType{
    public float[] multipliers;
    public ExoUnitType(String name, float kinetic, float explosive, float pierce, float energy, float thermal, float cryogenic){
        super(name);
        multipliers = new float[]{kinetic, explosive, pierce, energy, thermal, cryogenic};
    }
}