package Exogenesis.type.unit;

import Exogenesis.gen.*;

public class DroneUnitType extends ExoUnitType {
    public DroneUnitType(String name) {
        super(name);
        hidden = flying = true;
        playerControllable = logicControllable = false;
        isEnemy = false;
        drawItems = true;
        constructor = DroneUnit::create;
    }
}
