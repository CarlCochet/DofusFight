package maps.shapes;

import enums.DirectionsEnum;
import maps.MapPoint;
import maps.MapRecord;

import java.util.ArrayList;
import java.util.List;

public class Line implements IShape{
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

    public Line(byte minRadius, byte radius){
        this.radius = radius;
        this.minRadius = minRadius;
    }
    public Line(byte radius){
        this.radius = radius;
    }

    @Override
    public int getSurface() {
        return (int)(this.getRadius() * 4 + 1);
    }

    @Override
    public byte getMinRadius() {
        return this.minRadius;
    }

    @Override
    public void setMinRadius(byte radius) {
        this.radius = radius;
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

    @Override
    public int[] getCells(int centerCell, MapRecord map) {
        MapPoint mapPoint = new MapPoint(centerCell);
        List<Integer> list = new ArrayList<Integer>();

        for(int i = this.minRadius ; i <= this.radius ; i++){
            switch(this.direction){
                case DIRECTION_EAST:
                    MapPoint.addCellIfValid(mapPoint.getX() + i, mapPoint.getY() +i, map, list);
                    break;
                case DIRECTION_SOUTH_EAST:
                    MapPoint.addCellIfValid(mapPoint.getX() + i, mapPoint.getY() +i, map, list);
                    break;
                case DIRECTION_SOUTH:
                    MapPoint.addCellIfValid(mapPoint.getX() + i, mapPoint.getY() +i, map, list);
                    break;
                case DIRECTION_SOUTH_WEST:
                    MapPoint.addCellIfValid(mapPoint.getX() + i, mapPoint.getY() +i, map, list);
                    break;
                case DIRECTION_WEST:
                    MapPoint.addCellIfValid(mapPoint.getX() + i, mapPoint.getY() +i, map, list);
                    break;
                case DIRECTION_NORTH_WEST:
                    MapPoint.addCellIfValid(mapPoint.getX() + i, mapPoint.getY() +i, map, list);
                    break;
                case DIRECTION_NORTH:
                    MapPoint.addCellIfValid(mapPoint.getX() + i, mapPoint.getY() +i, map, list);
                    break;
                case DIRECTION_NORTH_EAST:
                    MapPoint.addCellIfValid(mapPoint.getX() + i, mapPoint.getY() +i, map, list);
                    break;
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    public boolean isDiagonal() {
        return diagonal;
    }

    public void setDiagonal(boolean diagonal) {
        this.diagonal = diagonal;
    }

    public List<DirectionsEnum> getDisabledDirections() {
        return disabledDirections;
    }

    public void setDisabledDirections(List<DirectionsEnum> disabledDirections) {
        this.disabledDirections = disabledDirections;
    }

    public boolean isOnlyPerpendicular() {
        return onlyPerpendicular;
    }

    public void setOnlyPerpendicular(boolean onlyPerpendicular) {
        this.onlyPerpendicular = onlyPerpendicular;
    }

    public boolean isAllDirections() {
        return allDirections;
    }

    public void setAllDirections(boolean allDirections) {
        this.allDirections = allDirections;
    }

    public IShape getShape() {
        return shape;
    }

    public void setShape(IShape shape) {
        this.shape = shape;
    }

    public char getShapeType() {
        return shapeType;
    }

    public void setShapeType(char shapeType) {
        this.shapeType = shapeType;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }
}
