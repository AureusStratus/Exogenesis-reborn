package Exogenesis.type.unit;

import Exogenesis.content.ExoItems;
import Exogenesis.graphics.ExoPal;
import Exogenesis.world.meta.ExoEnv;
import mindustry.type.*;
import mindustry.type.ammo.*;

/** Config class for special Erekir unit properties. */
public class AxinUnitType extends UnitType{

    public AxinUnitType(String name){
        super(name);
        outlineColor = ExoPal.genesisOutline;
        envDisabled = ExoEnv.freezing;
        ammoType = new ItemAmmoType(ExoItems.curtuses);
        researchCostMultiplier = 10f;
    }
}