package maps.shapes;

import enums.DirectionsEnum;
import maps.MapPoint;
import maps.MapRecord;

import java.util.ArrayList;
import java.util.List;

public class Cone implements IShape{
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

    public Cone(byte minRadius, byte radius){
        this.minRadius = minRadius;
        this.radius = radius;
        this.direction = DirectionsEnum.DIRECTION_SOUTH_EAST;
    }

    @Override
    public int[] getCells(int centerCell, MapRecord map) {
        MapPoint mapPoint = new MapPoint(centerCell);
        List<Integer> list = new ArrayList<Integer>();
        int[] result;
        if(this.radius == 0){
            if(this.minRadius == 0){
                list.add(centerCell);
            }

            result = list.stream().mapToInt(i->i).toArray();
        } else {
            int num = 0;
            int num2 = 1;
            switch(this.direction) {
                case DIRECTION_SOUTH_EAST:
                    for (int i = mapPoint.getX(); i <= mapPoint.getX() + this.radius; i++) {
                        for (int j = -num; j <= num; j++) {
                            if (this.minRadius == 0 || Math.abs(mapPoint.getX() - i) + Math.abs(j) >= this.minRadius) {
                                MapPoint.addCellIfValid(i, j + mapPoint.getY(), map, list);
                            }
                        }
                        num += num2;
                    }
                    break;
                case DIRECTION_SOUTH_WEST:
                    for (int i = mapPoint.getX(); i <= mapPoint.getX() + this.radius; i++) {
                        for (int j = -num; j <= num; j++) {
                            if (this.minRadius == 0 || Math.abs(mapPoint.getX() - i) + Math.abs(j) >= this.minRadius) {
                                MapPoint.addCellIfValid(i, j + mapPoint.getY(), map, list);
                            }
                        }
                        num += num2;
                    }
                    break;
                case DIRECTION_NORTH_WEST:
                    for (int i = mapPoint.getX(); i <= mapPoint.getX() + this.radius; i++) {
                        for (int j = -num; j <= num; j++) {
                            if (this.minRadius == 0 || Math.abs(mapPoint.getX() - i) + Math.abs(j) >= this.minRadius) {
                                MapPoint.addCellIfValid(i, j + mapPoint.getY(), map, list);
                            }
                        }
                        num += num2;
                    }
                    break;
                case DIRECTION_NORTH_EAST:
                    for (int i = mapPoint.getX(); i <= mapPoint.getX() + this.radius; i++) {
                        for (int j = -num; j <= num; j++) {
                            if (this.minRadius == 0 || Math.abs(mapPoint.getX() - i) + Math.abs(j) >= this.minRadius) {
                                MapPoint.addCellIfValid(i, j + mapPoint.getY(), map, list);
                            }
                        }
                        num += num2;
                    }
                    break;
            }
            result = list.stream().mapToInt(i->i).toArray();
        }

        return result;
    }

    @Override
    public int getSurface() {
        return (int)((this.radius + 1) * (this.radius + 1));
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
