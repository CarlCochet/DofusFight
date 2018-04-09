package maps.shapes;

import enums.DirectionsEnum;
import maps.MapPoint;
import maps.MapRecord;

import java.util.ArrayList;
import java.util.List;

public class HalfLozenge implements IShape{
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

    public HalfLozenge(byte minRadius, byte radius){
        this.minRadius = minRadius;
        this.radius = radius;
        this.direction = DirectionsEnum.DIRECTION_NORTH;
    }

    @Override
    public int[] getCells(int centerCell, MapRecord map) {
        MapPoint mapPoint = new MapPoint(centerCell);
        List<Integer> list = new ArrayList<Integer>();
        if(this.minRadius == 0){
            list.add(centerCell);
        }
        for(int i = 1 ; i <= this.radius ; i++){
            switch (this.direction){
                case DIRECTION_SOUTH_EAST:
                    MapPoint.addCellIfValid(mapPoint.getX() - i, mapPoint.getY() + i, map, list);
                    MapPoint.addCellIfValid(mapPoint.getX() - i, mapPoint.getY() - i, map, list);
                    break;
                case DIRECTION_SOUTH_WEST:
                    MapPoint.addCellIfValid(mapPoint.getX() - i, mapPoint.getY() + i, map, list);
                    MapPoint.addCellIfValid(mapPoint.getX() - i, mapPoint.getY() - i, map, list);
                    break;
                case DIRECTION_NORTH_WEST:
                    MapPoint.addCellIfValid(mapPoint.getX() - i, mapPoint.getY() + i, map, list);
                    MapPoint.addCellIfValid(mapPoint.getX() - i, mapPoint.getY() - i, map, list);
                    break;
                case DIRECTION_NORTH_EAST:
                    MapPoint.addCellIfValid(mapPoint.getX() - i, mapPoint.getY() + i, map, list);
                    MapPoint.addCellIfValid(mapPoint.getX() - i, mapPoint.getY() - i, map, list);
                    break;
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    @Override
    public int getSurface() {
        return (int)(this.radius * 2 + 1);
    }

    @Override
    public byte getMinRadius() {
        return this.minRadius;
    }

    @Override
    public void setMinRadius(byte radius) {
        this.minRadius = radius;
    }

    @Override
    public DirectionsEnum getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(DirectionsEnum direction) {
        this.direction = direction;
    }

    @Override
    public byte getRadius() {
        return this.radius;
    }

    @Override
    public void setRadius(byte radius) {
        this.radius = radius;
    }


}
