package Exogenesis.entities.effect;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import arc.util.pooling.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;

import static arc.graphics.g2d.Draw.*;
import static arc.util.Tmp.*;

/**
 * A particle with a trail that falls into the center.
 * When spawning, input the radius into the rotation param.
 * Inputting a negative value makes the particle swirl counter-clockwise instead of clockwise.
 */
public class SwirlEffect extends Effect{
    private static TextureRegion hCircle;

    /** How many points long the trail is. */
    public int length;
    /** Radius of the trail. */
    public float width;
    /** How much the particle will revolve around the center in degrees. */
    public float minRot, maxRot;
    /**
     * If set to values >= 0, the radius will be a random amount between minDst and maxDst,
     * however the sign of the input is still used to determine rotation direction.
     */
    public float minDst, maxDst;
    /** Whether particles emit light. */
    public boolean light;
    public float lightOpacity = 1f;
    /** If true, particle fades from edgeColor to effect color. Else, the particle is constantly the effect color. */
    public boolean lerp;
    public Color edgeColor;
    public Interp fallterp = Interp.pow2Out;
    public Interp spinterp = Interp.pow3Out;
    /** Overrides spin direction from radius provided by bullet rotation. >1 for clockwise, <1 for counter-clockwise */
    public float spinDirectionOverride = 0f;

    public SwirlEffect(float lifetime, float clipsize, Color edgeColor, int length, float width, float minRot, float maxRot, float minDst, float maxDst, boolean light, boolean lerp){
        super();
        this.lifetime = lifetime;
        this.clip = clipsize;
        this.edgeColor = edgeColor;
        this.length = length;
        this.width = width;
        this.minRot = minRot;
        this.maxRot = maxRot;
        this.minDst = minDst;
        this.maxDst = maxDst;
        this.light = light;
        this.lerp = lerp;

        followParent = rotWithParent = true;
    }

    public SwirlEffect(float lifetime, Color edgeColor, int length, float width, float minRot, float maxRot, float minDst, float maxDst, boolean light, boolean lerp){
        this(lifetime, 400f, edgeColor, length, width, minRot, maxRot, minDst, maxDst, light, lerp);
    }

    public SwirlEffect(float lifetime, int length, float width, float minRot, float maxRot, boolean light, boolean lerp){
        this(lifetime, Color.black, length, width, minRot, maxRot, -1, -1, light, lerp);
    }

    public SwirlEffect(float lifetime, int length, float width, float minRot, float maxRot, boolean lerp){
        this(lifetime, length, width, minRot, maxRot, true, lerp);
    }

    public SwirlEffect(){
        super();
    }

    public SwirlEffect setInterps(Interp fallterp, Interp spinterp){
        this.fallterp = fallterp;
        this.spinterp = spinterp;
        return this;
    }

    public SwirlEffect setInterps(Interp interp){
        return setInterps(interp, interp);
    }

    @Override
    public void render(EffectContainer e){
        float lifetime = e.lifetime - length;
        float dst;
        if(minDst < 0 || maxDst < 0){
            dst = Math.abs(e.rotation);
        }else{
            dst = Mathf.randomSeed(e.id, minDst, maxDst);
        }
        float l = Mathf.clamp(e.time / lifetime);
        if(lerp){
            color(edgeColor, e.color, l);
        }else{
            color(e.color);
        }

        int points = (int)Math.min(e.time, length);
        float width = Mathf.clamp(e.time / (e.lifetime - length)) * this.width;
        float size = width / points;
        float dir = spinDirectionOverride != 0 ? Mathf.sign(spinDirectionOverride) : Mathf.sign(e.rotation);
        float baseRot = Mathf.randomSeed(e.id + 1, 360f), addRot = Mathf.randomSeed(e.id + 2, minRot, maxRot) * dir;

        float fout, lastAng = 0f;
        for(int i = 0; i < points; i++){
            fout = 1f - Mathf.clamp((e.time - points + i) / lifetime);
            v1.trns(baseRot + addRot * spinterp.apply(fout), Mathf.maxZero(dst * fallterp.apply(fout)));
            fout = 1f - Mathf.clamp((e.time - points + i + 1) / lifetime);
            v2.trns(baseRot + addRot * spinterp.apply(fout), Mathf.maxZero(dst * fallterp.apply(fout)));

            //Reached center, break
            if(v1.equals(v2)){
                width = i * size;
                break;
            }

            float a2 = -v1.angleTo(v2) * Mathf.degRad;
            float a1 = i == 0 ? a2 : lastAng;

            float
                cx = Mathf.sin(a1) * i * size,
                cy = Mathf.cos(a1) * i * size,
                nx = Mathf.sin(a2) * (i + 1) * size,
                ny = Mathf.cos(a2) * (i + 1) * size;

            Fill.quad(
                e.x + v1.x - cx, e.y + v1.y - cy,
                e.x + v1.x + cx, e.y + v1.y + cy,
                e.x + v2.x + nx, e.y + v2.y + ny,
                e.x + v2.x - nx, e.y + v2.y - ny
            );
            if(light){
                Drawf.light(
                    e.x + v1.x, e.y + v1.y,
                    e.x + v2.x, e.y + v2.y,
                    i * size * 6f, Draw.getColor().cpy(), l * lightOpacity
                );
            }

            lastAng = a2;
        }

        if(hCircle == null) hCircle = Core.atlas.find("hcircle");
        Draw.rect(hCircle, e.x + v2.x, e.y + v2.y, width * 2f, width * 2f, -Mathf.radDeg * lastAng);
    }

    @Override
    protected void add(float x, float y, float rotation, Color color, Object data){
        BlackHoleEffectState entity = BlackHoleEffectState.create();
        entity.effect = this;
        entity.rotation = baseRotation + rotation;
        entity.data = data;
        entity.lifetime = lifetime;
        entity.set(x, y);
        entity.color.set(color);
        if(followParent && data instanceof Posc p){
            entity.parent = p;
            entity.rotWithParent = rotWithParent;
        }
        entity.add();
    }

    public static class BlackHoleEffectState extends EffectState{
        public static BlackHoleEffectState create() {
            return Pools.obtain(BlackHoleEffectState.class, BlackHoleEffectState::new);
        }

        @Override
        public void update(){
            followParent: {
                if(parent != null && parent.isAdded()){
                    if(rotWithParent){
                        if(parent instanceof Rotc r){
                            x = parent.getX() + Angles.trnsx(r.rotation() + offsetPos, offsetX, offsetY);
                            y = parent.getY() + Angles.trnsy(r.rotation() + offsetPos, offsetX, offsetY);
                            //Do not change rotation. It is used for radius.
                            break followParent;
                        }
                    }

                    x = parent.getX() + offsetX;
                    y = parent.getY() + offsetY;
                }
            }

            time = Math.min(time + Time.delta,lifetime);
            if (time >= lifetime) {
                remove();
            }
        }
    }
}
