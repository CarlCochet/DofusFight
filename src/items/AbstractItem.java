package items;

import effects.Effect;
import enums.CharacterInventoryPositionEnum;

import java.util.List;

public abstract class AbstractItem {

    private ItemRecord m_template;
    private ItemRecord template;
    private int id;
    private int GId;
    private byte position;
    private CharacterInventoryPositionEnum positionEnum;
    private int quantity;
    private List<Effect> effects;




}
