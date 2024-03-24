package Exogenesis.world.draw;

import arc.graphics.*;
import arc.util.*;
import Exogenesis.graphics.*;
import mindustry.gen.*;
import mindustry.world.draw.*;

public class DrawSingularity extends DrawBlock{
    public float x, y, size, edge;
    public @Nullable Color color;
    public boolean warmup = true;

    public DrawSingularity(float size, float edge){
        this.size = size;
        this.edge = edge;
    }

    public DrawSingularity(){
    }

    @Override
    public void draw(Building build){
        float scl = warmup ? build.warmup() : 1f;
        SingularityRenderer.addBlackHole(
            build.x + x, build.y + y,
            size * scl, edge * scl,
            color == null ? build.team.color : color
        );
    }
}
