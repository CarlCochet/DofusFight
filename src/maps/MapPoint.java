package maps;

import enums.DirectionsEnum;

import java.util.ArrayList;
import java.util.List;

public class MapPoint{

    public static int mapWidth = 14;
    public static int mapHeight = 20;
    public static int mapSize = 560;
    private static Point vectorRight = new Point(1, 1);
    private static Point vectorDownRight = new Point(1, 0);
    private static Point vectorDown = new Point(1, -1);
    private static Point vectorDownLeft = new Point(0, -1);
    private static Point vectorLeft = new Point(-1, -1);
    private static Point vectorUpLeft = new Point(-1, 0);
    private static Point vectorUp = new Point(-1, 1);
    private static Point vectorUpRight = new Point(0, 1);
    private static  boolean initialized;
    private static MapPoint[] OrthogonalGridReference = new MapPoint[560];
    private int cellId;
    private int x;
    private int y;

    public MapPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    public MapPoint(int cellId){
        this.cellId = cellId;
    }
    public MapPoint(Point point){
        this.x = point.getX();
        this.y = point.getY();
    }

    public Point coordinates(int x, int y){
        return new Point(x, y);
    }

    public static Point getVectorRight() {
        return vectorRight;
    }

    public static void setVectorRight(Point vectorRight) {
        MapPoint.vectorRight = vectorRight;
    }

    public static Point getVectorDownRight() {
        return vectorDownRight;
    }

    public static void setVectorDownRight(Point vectorDownRight) {
        MapPoint.vectorDownRight = vectorDownRight;
    }

    public static Point getVectorDown() {
        return vectorDown;
    }

    public static void setVectorDown(Point vectorDown) {
        MapPoint.vectorDown = vectorDown;
    }

    public static Point getVectorDownLeft() {
        return vectorDownLeft;
    }

    public static void setVectorDownLeft(Point vectorDownLeft) {
        MapPoint.vectorDownLeft = vectorDownLeft;
    }

    public static Point getVectorLeft() {
        return vectorLeft;
    }

    public static void setVectorLeft(Point vectorLeft) {
        MapPoint.vectorLeft = vectorLeft;
    }

    public static Point getVectorUpLeft() {
        return vectorUpLeft;
    }

    public static void setVectorUpLeft(Point vectorUpLeft) {
        MapPoint.vectorUpLeft = vectorUpLeft;
    }

    public static Point getVectorUp() {
        return vectorUp;
    }

    public static void setVectorUp(Point vectorUp) {
        MapPoint.vectorUp = vectorUp;
    }

    public static Point getVectorUpRight() {
        return vectorUpRight;
    }

    public static void setVectorUpRight(Point vectorUpRight) {
        MapPoint.vectorUpRight = vectorUpRight;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public static MapPoint[] getOrthogonalGridReference() {
        return OrthogonalGridReference;
    }

    public static void setOrthogonalGridReference(MapPoint[] orthogonalGridReference) {
        OrthogonalGridReference = orthogonalGridReference;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
        this.setFromCellId();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private void setFromCellId(){
        if(!initialized){
            initializeStaticGrid();
        }
    }

    private static void initializeStaticGrid(){ // Creates a grid of MapPoints
        initialized = true;
        int num = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;

        while(num4 < 20){
            int num5 = 0;
            while(num5 < 14){
                getOrthogonalGridReference()[num3++] = new MapPoint(num + num5, num2 + num5);
                num5++;
            }
            num2--;
            num4++;
        }
    }

    public MapPoint getPoint(int x, int y){
        return new MapPoint(x,y);
    }

    public static MapPoint getPoint(int cell){
        return new MapPoint(getOrthogonalGridReference()[cell].getX(), getOrthogonalGridReference()[cell].getY());
    }

    public int getHashCode(){  // Create hashcode from cellid
        int num = this.cellId;
        num = (num * 397 ^ this.x);
        return num * 397 ^ this.y;
    }

    public List<MapPoint> getAdjacentCells(){ // Getting all cells around the current cell
        List<MapPoint> mapPoints = new ArrayList<>();
        if(isInMap(this.x + 1, this.y)) {
            mapPoints.add(new MapPoint(this.x + 1, this.y));
        }
        if(isInMap(this.x, this.y - 1)) {
            mapPoints.add(new MapPoint(this.x, this.y - 1));
        }
        if(isInMap(this.x, this.y + 1)) {
            mapPoints.add(new MapPoint(this.x, this.y + 1));
        }
        if(isInMap(this.x - 1, this.y)) {
            mapPoints.add(new MapPoint(this.x - 1, this.y));
        }
        return mapPoints;
     }

    public MapPoint[] getNearPoints(){ // Getting all cells around the current under MapPoint[]
        List<MapPoint> mapPoints = getAdjacentCells();
        MapPoint[] nearPoints = new MapPoint[mapPoints.size()];
        for(int i = 0 ; i < nearPoints.length ; i++){
            nearPoints[i] = mapPoints.get(i);
        }
        return nearPoints;
    }

    public DirectionsEnum orientationTo(MapPoint point, boolean diagonal){
        int num = point.x - this.x;
        int num2 = this.y - point.y;

        double num3 = Math.sqrt(num*num + num2*num2);
        double num4 = Math.acos(num / num3);
        double num5 = num4 * 180.0 / 3.1415926535897931;
        double num6 = num5 * (point.y > this.y ? -1 : 1);
        double num7 = (!diagonal) ? (Math.round(num6/90) * 2.0 + 1.0) : (Math.round(num6/45) * 1.0);

        if(num7 < 0.0){
            num7 += 8.0;
        }

        return DirectionsEnum.values()[num];
    }

    public List<MapPoint> getAllCellsInRectangle(MapPoint oppositeCell, boolean skipStartAndEndCells){
        List<MapPoint> points = new ArrayList<>();

        int num0 = Math.min(oppositeCell.x, this.x);
        int num1 = Math.min(oppositeCell.y, this.y);
        int num2 = Math.max(oppositeCell.x, this.x);
        int num3 = Math.max(oppositeCell.y, this.y);

        for(int i = num0 ; i <= num3 ; i++){
            for(int j = num0 ; j <= num3 ; j++){
                if (!skipStartAndEndCells || (((i != this.x) || (j != this.y)) && ((i != oppositeCell.x) || (j != oppositeCell.y)))){
                    MapPoint point = getPoint(i, j);
                    if(point != null){
                        points.add(point);
                    }
                }
            }
        }

        return points;
    }

    public List<MapPoint> getCellsInLine(MapPoint destination){
        List<MapPoint> points = new ArrayList<>();

        int num0 = Math.abs(destination.x - this.x);
        int num1 = Math.abs(destination.y - this.y);

        int x = this.x;
        int y = this.y;

        int num4 = 1 + num0 + num1;
        int num5 = destination.x > this.x ? 1 : -1;
        int num6 = destination.y > this.y ? 1 : -1;
        int num7 = num0 - num1;

        num0 *= 2;
        num1 *= 2;

        while(num4 > 0){
            points.add(getPoint(x, y));
            if(num7 <= 0){
                if(num7 == 0){
                    x += num5;
                    y += num6;
                    num4++;
                } else {
                    y += num6;
                    num7 += num0;
                }
            }
        }
        return points;
    }

    public MapPoint getCellInDirection(DirectionsEnum direction, int step){
        MapPoint mapPoint = null;

        switch (direction)
        {
            case DIRECTION_EAST:
                mapPoint = this.getPoint(this.x + (int)step, this.y + (int)step);
                break;
            case DIRECTION_SOUTH_EAST:
                mapPoint = this.getPoint(this.x + (int)step, this.y);
                break;
            case DIRECTION_SOUTH:
                mapPoint = this.getPoint(this.x + (int)step, this.y - (int)step);
                break;
            case DIRECTION_SOUTH_WEST:
                mapPoint = this.getPoint(this.x, this.y - (int)step);
                break;
            case DIRECTION_WEST:
                mapPoint = this.getPoint(this.x - (int)step, this.y - (int)step);
                break;
            case DIRECTION_NORTH_WEST:
                mapPoint = this.getPoint(this.x - (int)step, this.y);
                break;
            case DIRECTION_NORTH:
                mapPoint = this.getPoint(this.x - (int)step, this.y + (int)step);
                break;
            case DIRECTION_NORTH_EAST:
                mapPoint = this.getPoint(this.x, this.y + (int)step);
                break;
        }

        MapPoint result;

        if(mapPoint != null){
            if(MapPoint.isInMap(mapPoint.x, mapPoint.y)){
                result = mapPoint;
            } else {
                result = null;
            }
        } else {
            result = null;
        }

        return result;

    }



    public MapPoint[] getCellsOnLineBetween(MapPoint destination){
        List<MapPoint> points = new ArrayList<>();
        DirectionsEnum direction = this.orientationTo(destination, true);
        MapPoint mapPoint = this;
        int num = 0;

        while(num < 140){
            mapPoint = mapPoint.getCellInDirection(direction, 1);
            if(mapPoint == null || mapPoint.cellId == destination.cellId){
                break;
            }
            points.add(mapPoint);
            num++;
        }

        MapPoint[] array = new MapPoint[points.size()];
        for(int i = 0 ; i < array.length ; i++){
            array[i] = points.get(i);
        }

        return array;
    }

    public MapPoint getCellSymetryByPortal(MapPoint target, MapPoint cellExit){

        return null;
    }

    public static int coordToCellId(int x, int y){  // Convert coords to cellid
        if(MapPoint.initialized){
            MapPoint.initializeStaticGrid();
        }

        return (int)((x - y) * 14 + (x + (x - y) / 2));
    }

    public static Point cellIdToCoord(int cellId){  // Convert cellid to coords
        if(MapPoint.initialized){
            MapPoint.initializeStaticGrid();
        }
        MapPoint point = MapPoint.getPoint(cellId);

        return new Point(point.x, point.y);
    }

    public static boolean isInMap(int x, int y){  //Check if the cell is in the map

        return x + y >= 0 && x - y >= 0 && x - y < 40 && x + y < 28;
    }

    public static void addCellIfValid(int x, int y, MapRecord map, List<Integer> container){
        if(MapPoint.isInMap(x, y)){
            container.add((int)MapPoint.coordToCellId(x, y));
        }
    }

}
