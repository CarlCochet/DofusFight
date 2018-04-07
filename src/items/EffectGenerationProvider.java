package items;

import effects.EffectInstance;
import javafx.scene.effect.Effect;

import java.lang.invoke.MethodHandleInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EffectGenerationProvider {

    private List<EffectGenerationAttribute> handlers = new ArrayList<EffectGenerationAttribute>();

    public EffectGenerationProvider(){

    }

    public static Effect handle(EffectInstance instance){
        return null;
    }

    public static boolean isHandled(int effectid){
        return true;
    }
}
