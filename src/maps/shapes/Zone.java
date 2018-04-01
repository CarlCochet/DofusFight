package maps.shapes;

import enums.DirectionsEnum;

public class Zone {

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


}
