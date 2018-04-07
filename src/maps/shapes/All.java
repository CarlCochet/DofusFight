package maps.shapes;

import enums.DirectionsEnum;
import maps.MapRecord;

public class All implements IShape{

    @Override
    public int getSurface() {
        return 0;
    }

    @Override
    public byte getMinRadius() {
        return 0;
    }

    @Override
    public void setMinRadius(byte radius) {

    }

    @Override
    public DirectionsEnum getDirection() {
        return DirectionsEnum.DIRECTION_NORTH;
    }

    @Override
    public void setDirection(DirectionsEnum direction) {

    }

    @Override
    public byte getRadius() {
        return 0;
    }

    @Override
    public void setRadius(byte radius) {

    }

    @Override
    public int[] getCells(int centerCell, MapRecord map) {
        return new int[0];
    }
}
