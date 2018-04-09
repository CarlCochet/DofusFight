package maps.shapes;

import enums.DirectionsEnum;
import maps.MapPoint;
import maps.MapRecord;

import java.util.ArrayList;
import java.util.List;

public class Lozenge implements IShape{
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

    public Lozenge(byte minRadius, byte radius){
        this.minRadius = minRadius;
        this.radius = radius;
    }

    @Override
    public int[] getCells(int centerCell, MapRecord map) {
        MapPoint mapPoint = new MapPoint(centerCell);
        List<Integer> list = new ArrayList<>();
        int[] result;

        if(this.radius == 0){
            if(this.minRadius == 0){
                list.add(centerCell);
            }
            result = list.stream().mapToInt(i->i).toArray();
        } else {
            int k = mapPoint.getX() - (int)this.radius;
            int num = 0;
            int num2 = 1;
            while(k <= mapPoint.getX() + (int)this.radius){
                for(int j = -num ; j <= num ; j++){
                    if(this.minRadius == 0 || Math.abs(mapPoint.getX() - k) + Math.abs(j) >= (int)this.minRadius){
                        MapPoint.addCellIfValid(k, j + mapPoint.getY(), map, list);
                    }
                }
                if(num == (int)this.radius){
                    num2 = -num2;
                }
                num += num2;
                k++;
            }
            result = list.stream().mapToInt(i->i).toArray();
        }
        return result;
    }

    @Override
    public int getSurface() {
        return (int)((this.radius + 1) * (this.radius + 1) + this.radius * this.radius);
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
