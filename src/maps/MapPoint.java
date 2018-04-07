package maps;

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
    private boolean initialized;
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

    private void initializeStaticGrid(){
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

    public MapPoint getPoint(int cell){
        return new MapPoint(getOrthogonalGridReference()[cell].getX(), getOrthogonalGridReference()[cell].getY());
    }

    public int getHashCode(){
        int num = this.cellId;
        num = (num * 397 ^ this.x);
        return num * 397 ^ this.y;
    }

    public List<MapPoint> getAdjacentCells(){
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

    public MapPoint[] getNearPoints(){
        List<MapPoint> mapPoints = getAdjacentCells();
        MapPoint[] nearPoints = new MapPoint[mapPoints.size()];
        for(int i = 0 ; i < nearPoints.length ; i++){
            nearPoints[i] = mapPoints.get(i);
        }
        return nearPoints;
    }

    public MapPoint getCellSymetryByPortal(MapPoint target, MapPoint cellExit){

        return null;
    }

    public boolean isInMap(int x, int y){
        return x + y >= 0 && x - y >= 0 && x - y < 40 && x + y < 28;
    }
}
