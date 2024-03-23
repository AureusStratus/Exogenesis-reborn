package Exogenesis.content;
import mindustry.world.meta.Attribute;

public class ExoAttribute {
    public static Attribute
    power;
    public static void load() {
        power = Attribute.add("power");
    }
}
