package maps.shapes;

import enums.DirectionsEnum;
import maps.MapRecord;

import java.util.ArrayList;
import java.util.List;

public class Single implements IShape{
    private boolean diagonal;
    private List<DirectionsEnum> disabledDirections = new ArrayList<DirectionsEnum>();
    private boolean onlyPerpendicular;
    private boolean allDirections;
    private IShape shape;
    private char shapeType;
    private byte radius;
    private DirectionsEnum direction;
    private int surface;
    private byte minRadius;

    public Single(){

    }

    @Override
    public int[] getCells(int centerCell, MapRecord map) {
        return new int[]{centerCell};
    }

    @Override
    public int getSurface() {
        return 1;
    }

    @Override
    public byte getMinRadius() {
        return 1;
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
        return 1;
    }

    @Override
    public void setRadius(byte radius) {

    }
}
