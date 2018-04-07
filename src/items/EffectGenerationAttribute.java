package items;

import enums.EffectsEnum;
import javafx.scene.effect.Effect;

public class EffectGenerationAttribute {

    private EffectsEnum effect;

    public EffectGenerationAttribute(EffectsEnum effect){
        this.effect = effect;
    }

    public EffectsEnum getEffect() {
        return effect;
    }

    public void setEffect(EffectsEnum effect) {
        this.effect = effect;
    }
}
