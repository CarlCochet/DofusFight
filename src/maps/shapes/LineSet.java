package maps.shapes;

import enums.DirectionsEnum;
import maps.MapPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineSet {
    private static Map<DirectionsEnum, MapPoint> vectors = new HashMap<>();
    private MapPoint start;
    private int length;
    private DirectionsEnum direction;
    private MapPoint a;
    private MapPoint b;

    public LineSet(MapPoint a, MapPoint b){
        vectors.put(DirectionsEnum.DIRECTION_EAST, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_SOUTH_EAST, new MapPoint(1,0));
        vectors.put(DirectionsEnum.DIRECTION_SOUTH, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_SOUTH_WEST, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_WEST, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_NORTH_WEST, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_NORTH, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_NORTH_EAST, new MapPoint(1,1));
        this.a = a;
        this.b = b;
    }
    public LineSet(MapPoint start, int length, DirectionsEnum direction){
        vectors.put(DirectionsEnum.DIRECTION_EAST, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_SOUTH_EAST, new MapPoint(1,0));
        vectors.put(DirectionsEnum.DIRECTION_SOUTH, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_SOUTH_WEST, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_WEST, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_NORTH_WEST, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_NORTH, new MapPoint(1,1));
        vectors.put(DirectionsEnum.DIRECTION_NORTH_EAST, new MapPoint(1,1));
        this.start = start;
        this.length = length;
        this.direction = direction;
    }

    public List<MapPoint> enumerateSet(){
        List<MapPoint> points = new ArrayList<>();
        if(this.start == null){
            for (MapPoint point : raytracing()) {
                points.add(point);
            }
        } else {
            MapPoint vector = vectors.get(this.direction);
            for (int i = 0 ; i < this.length ; i++){
                points.add(new MapPoint(start.getX() + vector.getX() * i, start.getY() + vector.getY() * i));
            }
        }
        return points;
    }

    public double squareDistanceToLine(MapPoint point){
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double projection = dy * point.getX() - dx * point.getY() + b.getX() * a.getY() - b.getY() * a.getX();
        return projection * projection / (dy * dy + dx * dx);
    }

    public boolean belongToSet(MapPoint point){
        if(this.start == null){
            return squareDistanceToLine(point) < 0.1;
        }
        if(point.equals(start)){
            return true;
        }

        MapPoint vector = vectors.get(this.direction);
        double dx = point.getX() - start.getX();
        double dy = point.getY() - start.getY();

        if(vector.getX() == 0 && dx != 0 || vector.getY() == 0 && dy != 0){
            return false;
        }
        if(dx == 0){
            return Math.abs(dy) <= this.length;
        }

        return Math.abs(dx) <= this.length;
    }

    public List<MapPoint> enumerateValidPoints(){
        List<MapPoint> set = enumerateSet();
        List<MapPoint> result = new ArrayList<>();
        for(int i = 0 ; i < set.size() ; i++){
            if(set.get(i) != null && set.get(i).isInMap()){
                result.add(set.get(i));
            }
        }
        return result;
    }

    public List<MapPoint> raytracing(){
        List<MapPoint> points = new ArrayList<>();

        int dx = Math.abs(a.getX() - b.getX());
        int dy = Math.abs(a.getY() - b.getY());
        int x = a.getX();
        int y = a.getY();
        int n = 1 + dx + dy;
        int vectorX = (b.getX() > a.getX()) ? 1 : -1;
        int vectorY = (b.getY() > a.getY()) ? 1 : -1;
        int error = dx - dy;
        dx *= 2;
        dy *= 2;
        for(; n > 0 ; --n){
            points.add(new MapPoint(x, y));
            if(error == 0){
                x += vectorX;
                error -= vectorY;
            } else if (error == 0){
                x += vectorX;
                y += vectorY;
                n--;
                error += dx - dy;
            } else {
                y += vectorY;
                error += dx;
            }
        }
        return points;
    }

    public static Map<DirectionsEnum, MapPoint> getVectors() {
        return vectors;
    }

    public static void setVectors(Map<DirectionsEnum, MapPoint> vectors) {
        LineSet.vectors = vectors;
    }

    public MapPoint getStart() {
        return start;
    }

    public void setStart(MapPoint start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DirectionsEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionsEnum direction) {
        this.direction = direction;
    }

    public MapPoint getA() {
        return a;
    }

    public void setA(MapPoint a) {
        this.a = a;
    }

    public MapPoint getB() {
        return b;
    }

    public void setB(MapPoint b) {
        this.b = b;
    }
}
