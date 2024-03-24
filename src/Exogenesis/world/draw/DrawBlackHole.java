package Exogenesis.world.draw;

import arc.graphics.*;
import arc.util.*;
import Exogenesis.graphics.*;
import mindustry.gen.*;
import mindustry.world.draw.*;

public class DrawBlackHole extends DrawBlock{
    public float x, y, size, edge;
    public @Nullable Color color;
    public boolean warmup = true;

    public DrawBlackHole(float size, float edge){
        this.size = size;
        this.edge = edge;
    }

    public DrawBlackHole(){
    }

    @Override
    public void draw(Building build){
        float scl = warmup ? build.warmup() : 1f;
        BlackHoleRenderer.addBlackHole(
            build.x + x, build.y + y,
            size * scl, edge * scl,
            color == null ? build.team.color : color
        );
    }
}
