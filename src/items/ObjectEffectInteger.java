package items;

import effects.ObjectEffect;

public class ObjectEffectInteger extends ObjectEffect {
    public static int id = 70;

    private int typeId;

    private int value;

    public ObjectEffectInteger(){

    }

    public ObjectEffectInteger(int actionId, int value){
        super(actionId);
        this.value = value;
    }

}
