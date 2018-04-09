package maps.shapes;

import enums.DirectionsEnum;
import maps.MapPoint;
import maps.MapRecord;

import java.util.ArrayList;
import java.util.List;

public class Square implements IShape{
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

    public Square(byte minRadius, byte radius){
        this.minRadius = minRadius;
        this.radius = radius;
    }

    @Override
    public int[] getCells(int centerCell, MapRecord map) {
        MapPoint mapPoint = new MapPoint(centerCell);
        List<Integer> list = new ArrayList<>();

        list.add(centerCell);

        for(int i = 1 ; i < this.radius + 1 ; i++){
            MapPoint adj = mapPoint.getCellInDirection(DirectionsEnum.DIRECTION_EAST, i);

            if(adj != null){
                list.add(adj.getCellId());

                MapPoint next = adj;

                for (MapPoint cell : next.getCellsInDirection(DirectionsEnum.DIRECTION_NORTH_WEST, i * 2)) {
                    if(cell == null){
                        return new int[0];
                    }
                    if(!list.contains(cell.getCellId())){
                        MapPoint.addCellIfValid(cell.getX(), cell.getY(), map, list);
                        next = cell;
                    }
                }
                for(MapPoint cell : next.getCellsInDirection(DirectionsEnum.DIRECTION_SOUTH_WEST, i * 2)){
                    if(cell == null){
                        return new int[0];
                    }
                    if(!list.contains(cell.getCellId())){
                        MapPoint.addCellIfValid(cell.getX(), cell.getY(), map, list);
                        next = cell;
                    }
                }
                for (MapPoint cell : next.getCellsInDirection(DirectionsEnum.DIRECTION_NORTH_EAST, i * 2)) {
                    if(cell == null){
                        return new int[0];
                    }
                    if(!list.contains(cell.getCellId())){
                        MapPoint.addCellIfValid(cell.getX(), cell.getY(), map, list);
                        next = cell;
                    }
                }
            } else {
                list.clear();
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    @Override
    public int getSurface() {
        return (int)((this.radius * 2 + 1) * (this.radius * 2 + 1));
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
