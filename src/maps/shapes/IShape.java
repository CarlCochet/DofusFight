package maps.shapes;

import enums.DirectionsEnum;
import maps.MapRecord;

public interface IShape {
    public int getSurface();

    public byte getMinRadius();
    public void setMinRadius(byte radius);

    public DirectionsEnum getDirection();
    public void setDirection(DirectionsEnum direction);

    public byte getRadius();
    public void setRadius(byte radius);

    public int[] getCells(int centerCell, MapRecord map);

}
