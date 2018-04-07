package effects;


import items.ObjectEffectInteger;

public class EffectInteger extends Effect {

    private int value;

    public EffectInteger(){

    }

    public EffectInteger(int effectId, int value){
        super(effectId);
        this.value = value;
    }

    @Override
    public ObjectEffect getObjectEffect() {
        return new ObjectEffectInteger(getEffectId(), value);
    }

    public boolean equals(Object object){
        return object instanceof  EffectInteger ?  this.equals((EffectInteger)object) : false;
    }

    public boolean equals(EffectInteger effect){
        return this.getEffectId() == effect.getEffectId() && effect.value == this.value;
    }


}
