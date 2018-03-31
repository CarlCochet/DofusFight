package maps.shapes;

import maps.MapRecord;

public interface IShape {
    public int getSurface();
    public byte getMinRadius();
    public void setMinRadius();
    public byte getRadius();
    public void setRadius();
    public int[] getCells(int centerCell, MapRecord map);

}
