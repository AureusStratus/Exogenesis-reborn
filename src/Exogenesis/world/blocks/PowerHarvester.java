package Exogenesis.world.blocks;

import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.world.Block;
import mindustry.world.Tile;

import static mindustry.Vars.tilesize;

public class PowerHarvester extends Block {
    public float range;

    public PowerHarvester(String name) {
        super(name);
        this.update = true;
        this.solid = true;
        this.destructible = true;
        this.range = 50;
    }
    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        super.drawPlace(x, y, rotation, valid);
        Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, Pal.placing);
    }
    public float countCrystal(Tile tile) {
        return 0;
    }
    public class PowerHarvesterBuild extends Building {
        public float sum;
        public void drawSelect(){
            Drawf.dashCircle(x, y, range, team.color);
        }
        public void onProximityAdded() {
            super.onProximityAdded();
            sum = countCrystal(tile);
        }
    }
}