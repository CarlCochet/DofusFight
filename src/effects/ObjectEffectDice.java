package effects;

public class ObjectEffectDice extends ObjectEffect {

    private int diceNum;
    private int diceSide;
    private int diceConst;

    public ObjectEffectDice(int actionId, int diceNum, int diceSide, int diceConst){
        this.diceNum = diceNum;
        this.diceSide = diceSide;
        this.diceConst = diceConst;
    }
}
