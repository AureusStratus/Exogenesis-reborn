package Exogenesis.content;

import arc.Core;
import arc.assets.AssetDescriptor;
import arc.assets.loaders.SoundLoader;
import arc.audio.Sound;
import arc.struct.Seq;
import mindustry.Vars;

import java.lang.reflect.Field;

public class ExoSounds{
    public static Sound
            cannon, laser2, laser3, laser4, laser5, thermo,
            funnylaserloop = new Sound(),
            shockblast = new Sound();

    public static void load(){
        Class<?> c = ExoSounds.class;
        Seq<Field> fields = new Seq<>(c.getFields());
        fields.filter(f -> Sound.class.equals(f.getType()));
        try{
            for(Field f : fields)f.set(null, loadSound(f.getName()));
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }

    private static Sound loadSound(String soundName){
        if(!Vars.headless){
            String name = "sounds/" + soundName;
            String path = Vars.tree.get(name + ".ogg").exists() ? name + ".ogg" : name + ".mp3";

            Sound sound = new Sound();

            AssetDescriptor<?> desc = Core.assets.load(path, Sound.class, new SoundLoader.SoundParameter(sound));
            desc.errored = Throwable::printStackTrace;
            return sound;
        }else return new Sound();
    }
}
