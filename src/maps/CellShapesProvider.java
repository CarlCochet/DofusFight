package maps;

import enums.DirectionsEnum;
import enums.MapScrollEnum;

import java.util.ArrayList;
import java.util.List;

public class CellShapesProvider {
    public static int[] mapBorders;

    public CellShapesProvider(){
        initialize();
    }

    public static void initialize(){
        mapBorders = getMapBorders().stream().mapToInt(i->i).toArray();
    }

    private static List<Integer> getMapBorders(){
        List<Integer> results = new ArrayList<>();

        results.addAll(getMapBorder(MapScrollEnum.Top));
        results.addAll(getMapBorder(MapScrollEnum.Left));
        results.addAll(getMapBorder(MapScrollEnum.Bottom));
        results.addAll(getMapBorder(MapScrollEnum.Right));

        return results;
    }

    public static boolean isMapBorder(int cellid){
        return getMapBorders().contains(cellid);
    }

    public static List<Integer> getMapBorder(MapScrollEnum borderType){
        List<Integer> results = new ArrayList<>();

        switch(borderType){
            case Top:
                results.addAll(getLineFromDirection(0, 14, DirectionsEnum.DIRECTION_EAST));
                results.addAll(getLineFromDirection(14, 14, DirectionsEnum.DIRECTION_EAST));
                break;
            case Left:
                results.addAll(getLineFromDirection(14, 19, DirectionsEnum.DIRECTION_SOUTH));
                results.addAll(getLineFromDirection(0, 19, DirectionsEnum.DIRECTION_SOUTH));
                break;
            case Bottom:
                results.addAll(getLineFromDirection(546, 14, DirectionsEnum.DIRECTION_WEST));
                results.addAll(getLineFromDirection(560, 14, DirectionsEnum.DIRECTION_WEST));
                break;
            case Right:
                results.addAll(getLineFromDirection(27, 19, DirectionsEnum.DIRECTION_SOUTH));
                results.addAll(getLineFromDirection(13, 19, DirectionsEnum.DIRECTION_SOUTH));
                break;
            default:
                break;
        }

        return results;
    }

    public static void verify(List<Integer> cells){
        cells.removeIf((Integer x) -> x < 0 || x > 560);
    }

    public static List<Integer> getRightCells(int startcell, int movedcellamount){
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i < movedcellamount + 1 ; i++){
            list.add((int)(startcell + i));
        }
        verify(list);

        return list;
    }
    public static List<Integer> getLeftCells(int startcell, int movedcellamount){
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i < movedcellamount + 1 ; i++){
            list.add((int)(startcell - i));
        }
        verify(list);

        return list;
    }
    public static List<Integer> getUpCells(int startcell, int movedcellamount){
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i < movedcellamount + 1 ; i++){
            list.add((int)(startcell - 28 * i));
        }
        verify(list);

        return list;
    }
    public static List<Integer> getDownCells(int startcell, int movedcellamount){
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i < movedcellamount + 1 ; i++){
            list.add((int)(startcell + 28 * i));
        }
        verify(list);

        return list;
    }

    public static List<Integer> getFrontDownLeftCells(int startcell, int movedcellamount){
        List<Integer> list = new ArrayList<>();
        int checker = (int)(Math.floor(startcell / 14));
        int remainder = checker % 2;

        if(remainder == 0){
            list.add((int)startcell + 13);
            boolean check = true;

            for(int i = 0 ; i < movedcellamount ; i++){
                if (check) {
                    list.add((int)list.get(i) + 14);
                    check = false;
                } else {
                    list.add((int)list.get(i) + 13);
                    check = true;
                }
            }
        } else {
            list.add((int)startcell + 14);
            boolean check = true;

            for(int i = 0 ; i < movedcellamount ; i++){
                if (check) {
                    list.add((int)list.get(i) + 13);
                    check = false;
                } else {
                    list.add((int)list.get(i) + 14);
                    check = true;
                }
            }
        }
        list.remove(list.size() - 1);
        verify(list);

        return list;
    }

    public static List<Integer> getFrontDownRightCells(int startcell, int movedcellamount){
        List<Integer> list = new ArrayList<>();
        int checker = (int)(Math.floor(startcell / 14));
        int remainder = checker % 2;

        if(remainder == 0){
            list.add((int)startcell + 14);
            boolean check = true;

            for(int i = 0 ; i < movedcellamount ; i++){
                if (check) {
                    list.add((int)list.get(i) + 15);
                    check = false;
                } else {
                    list.add((int)list.get(i) + 14);
                    check = true;
                }
            }
        } else {
            list.add((int)startcell + 15);
            boolean check = true;

            for(int i = 0 ; i < movedcellamount ; i++){
                if (check) {
                    list.add((int)list.get(i) + 14);
                    check = false;
                } else {
                    list.add((int)list.get(i) + 15);
                    check = true;
                }
            }
        }
        list.remove(list.size() - 1);
        verify(list);

        return list;
    }

    public static List<Integer> getFrontUpLeftCells(int startcell, int movedcellamount){
        List<Integer> list = new ArrayList<>();
        int checker = (int)(Math.floor(startcell / 14));
        int remainder = checker % 2;

        if(remainder == 0){
            list.add((int)startcell - 15);
            boolean check = true;

            for(int i = 0 ; i < movedcellamount ; i++){
                if (check) {
                    list.add((int)list.get(i) - 14);
                    check = false;
                } else {
                    list.add((int)list.get(i) - 15);
                    check = true;
                }
            }
        } else {
            list.add((int)startcell - 14);
            boolean check = true;

            for(int i = 0 ; i < movedcellamount ; i++){
                if (check) {
                    list.add((int)list.get(i) - 15);
                    check = false;
                } else {
                    list.add((int)list.get(i) - 14);
                    check = true;
                }
            }
        }
        list.remove(list.size() - 1);
        verify(list);

        return list;
    }

    public static List<Integer> getFrontUpRightCells(int startcell, int movedcellamount){
        List<Integer> list = new ArrayList<>();
        int checker = (int)(Math.floor(startcell / 14));
        int remainder = checker % 2;

        if(remainder == 0){
            list.add((int)startcell - 14);
            boolean check = true;

            for(int i = 0 ; i < movedcellamount ; i++){
                if (check) {
                    list.add((int)list.get(i) - 13);
                    check = false;
                } else {
                    list.add((int)list.get(i) - 14);
                    check = true;
                }
            }
        } else {
            list.add((int)startcell - 13);
            boolean check = true;

            for(int i = 0 ; i < movedcellamount ; i++){
                if (check) {
                    list.add((int)list.get(i) - 14);
                    check = false;
                } else {
                    list.add((int)list.get(i) - 13);
                    check = true;
                }
            }
        }
        list.remove(list.size() - 1);
        verify(list);

        return list;
    }



    public static List<Integer> getLineFromDirection(int startcell, int movecellamount, DirectionsEnum direction){
        switch(direction){
            case DIRECTION_EAST:
                return getRightCells(startcell, movecellamount);
            case DIRECTION_SOUTH_EAST:
                return getFrontDownRightCells(startcell, movecellamount);
            case DIRECTION_SOUTH:
                return getDownCells(startcell, movecellamount);
            case DIRECTION_SOUTH_WEST:
                return getFrontDownLeftCells(startcell, movecellamount);
            case DIRECTION_WEST:
                return getLeftCells(startcell, movecellamount);
            case DIRECTION_NORTH_WEST:
                return getFrontUpLeftCells(startcell, movecellamount);
            case DIRECTION_NORTH:
                return getUpCells(startcell, movecellamount);
            case DIRECTION_NORTH_EAST:
                return getFrontUpRightCells(startcell, movecellamount);
            default:
                return null;
        }

    }

}
