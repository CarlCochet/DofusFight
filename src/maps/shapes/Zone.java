package maps.shapes;

import enums.DirectionsEnum;
import maps.MapRecord;

public class Zone implements IShape {

    private IShape shape;
    private char shapeType;
    private byte radius;
    private DirectionsEnum direction;
    private int surface;
    private byte minRadius;

    public Zone(char shape, byte radius){
        this.radius = radius;
        this.shapeType = shape;
    }

    public Zone(char shape, byte radius, DirectionsEnum direction){
        this.radius = radius;
        this.shapeType = shape;
        this.direction = direction;
    }

    @Override
    public int[] getCells(int centerCell, MapRecord map) {
        return this.shape.getCells(centerCell, map);
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
        this.initilizeShape();
    }

    public byte getRadius() {
        return radius;
    }

    public void setRadius(byte radius) {
        this.radius = radius;
        if(this.shape != null){
            this.shape.setRadius(radius);
        }
    }



    public DirectionsEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionsEnum direction) {
        this.direction = direction;
        if(this.shape != null){
            this.shape.setDirection(direction);
        }
    }

    public int getSurface() {
        return this.shape.getSurface();
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public byte getMinRadius() {
        return this.shape.getMinRadius();
    }

    public void setMinRadius(byte minRadius) {
        this.minRadius = minRadius;
    }

    public void initilizeShape(){
        char shapeType = this.shapeType;
        if(shapeType <= '+'){
            if(shapeType == '#') {
                Cross cross = new Cross((byte) 1, this.radius);
                cross.setDiagonal(true);
                this.shape = cross;
            }
            if(shapeType == '*') {
                Cross cross = new Cross((byte) 1, this.radius);
                cross.setDiagonal(true);
                this.shape = cross;
            }
            if(shapeType == '+') {
                Cross cross = new Cross((byte) 1, this.radius);
                cross.setDiagonal(true);
                this.shape = cross;
            }
        } else {
            if(shapeType == '?'){
                shape = new Line(radius);
            }
        }

    }
}
