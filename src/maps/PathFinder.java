package maps;

import java.util.ArrayList;
import java.util.PriorityQueue;

import display.Window;

public class PathFinder {

    public PathFinder(int sizeX, int sizeY){
        System.out.println("TAILLE DE LABYRINTHE : "+sizeX+" "+sizeY);
        grid = new Tile[sizeX][sizeY];
    }

    public static final int DIAGONAL_COST = 14;
    public static final int V_H_COST = 10;

    static class Tile{
        int heuristicCost = 0; //Heuristic cost
        int finalCost = 0; //G+H
        int i, j;
        Tile parent;

        Tile(int i, int j){
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        @Override
        public String toString(){
            return "["+this.i+", "+this.j+"]";
        }
    }

    //Blocked Tiles are just null Tile values in grid
    static Tile [][] grid;

    static PriorityQueue<Tile> open;

    static boolean closed[][];
    static int startI, startJ;
    static int endI, endJ;

    public static void setBlocked(int i, int j){
        grid[i][j] = null;
    }

    public static void setStartTile(int i, int j){
        startI = i;
        startJ = j;
    }

    public static void setEndTile(int i, int j){
        endI = i;
        endJ = j;
    }

    static void checkAndUpdateCost(Tile current, Tile t, int cost){
        if(t == null || closed[t.i][t.j])return;
        int t_final_cost = t.heuristicCost+cost;

        boolean inOpen = open.contains(t);
        if(!inOpen || t_final_cost<t.finalCost){
            t.finalCost = t_final_cost;
            t.parent = current;
            if(!inOpen)open.add(t);
        }
    }

    public static void AStar(){

        //add the start location to open list.
        open.add(grid[startI][startJ]);

        Tile current;

        while(true){
            current = open.poll();
            if(current==null)break;
            closed[current.i][current.j]=true;

            if(current.equals(grid[endI][endJ])){
                return;
            }

            Tile t;
            if(current.i-1>=0){
                t = grid[current.i-1][current.j];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST);
            }

            if(current.j-1>=0){
                t = grid[current.i][current.j-1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST);
            }

            if(current.j+1<grid[0].length){
                t = grid[current.i][current.j+1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST);
            }

            if(current.i+1<grid.length){
                t = grid[current.i+1][current.j];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST);
            }
        }
    }

    /*
    Params :
    tCase = test case No.
    x, y = Board's dimensions
    si, sj = start location's x and y coordinates
    ei, ej = end location's x and y coordinates
    int[][] blocked = array containing inaccessible Tile coordinates
    */
    public static int accesPossible(int tCase, int x, int y, int si, int sj, int ei, int ej, int[][] blocked){
        //Reset
        grid = new Tile[x][y];
        closed = new boolean[x][y];
        open = new PriorityQueue<>((Object o1, Object o2) -> {
            Tile c1 = (Tile)o1;
            Tile c2 = (Tile)o2;

            return c1.finalCost<c2.finalCost?-1:
                    c1.finalCost>c2.finalCost?1:0;
        });
        //Set start position
        setStartTile(si, sj);  //Setting to 0,0 by default. Will be useful for the UI part

        //Set End Location
        setEndTile(ei, ej);

        for(int i=0;i<x;++i){
            for(int j=0;j<y;++j){
                grid[i][j] = new Tile(i, j);
                grid[i][j].heuristicCost = Math.abs(i-endI)+Math.abs(j-endJ);
            }
        }
        grid[si][sj].finalCost = 0;

           /*
             Set blocked Tiles. Simply set the Tile values to null
             for blocked Tiles.
           */
        if(blocked != null){
            for(int i=0;i<blocked.length;++i){
                if(!(blocked[i][0] == ei && blocked[i][1] == ej))
                    setBlocked(blocked[i][0], blocked[i][1]);
            }
        }

        AStar();
        int c = 0;

        if(closed[endI][endJ]){
            Tile current = grid[endI][endJ];
            while(current.parent!=null){
                current = current.parent;
                c++;
            }
        }


        if(closed[endI][endJ]){
            return c;
        }else {
            return -1;
        }
    }

    /*
    Params :
    tCase = test case No.
    x, y = Board's dimensions
    si, sj = start location's x and y coordinates
    ei, ej = end location's x and y coordinates
    int[][] blocked = array containing inaccessible Tile coordinates
    */
    public static void test(int tCase, int x, int y, int si, int sj, int ei, int ej, int[][] blocked){
        System.out.println("\n\nTest Case #"+tCase);
        //Reset
        grid = new Tile[x][y];
        closed = new boolean[x][y];
        open = new PriorityQueue<>((Object o1, Object o2) -> {
            Tile c1 = (Tile)o1;
            Tile c2 = (Tile)o2;

            return c1.finalCost<c2.finalCost?-1:
                    c1.finalCost>c2.finalCost?1:0;
        });
        //Set start position
        setStartTile(si, sj);  //Setting to 0,0 by default. Will be useful for the UI part

        //Set End Location
        setEndTile(ei, ej);

        for(int i=0;i<x;++i){
            for(int j=0;j<y;++j){
                grid[i][j] = new Tile(i, j);
                grid[i][j].heuristicCost = Math.abs(i-endI)+Math.abs(j-endJ);
//                  System.out.print(grid[i][j].heuristicCost+" ");
            }
//              System.out.println();
        }
        grid[si][sj].finalCost = 0;

           /*
             Set blocked Tiles. Simply set the Tile values to null
             for blocked Tiles.
           */
        if(blocked != null){
            for(int i=0;i<blocked.length;++i){
                setBlocked(blocked[i][0], blocked[i][1]);
            }
        }


        //Display initial map
        System.out.println("Grid: ");
        for(int i=0;i<x;++i){
            for(int j=0;j<y;++j){
                if(i==si&&j==sj)System.out.print("SO  "); //Source
                else if(i==ei && j==ej)System.out.print("DE  ");  //Destination
                else if(grid[i][j]!=null)System.out.printf("%-3d ", 0);
                else System.out.print("BL  ");
            }
            System.out.println();
        }
        System.out.println();

        AStar();
        System.out.println("\nScores for Tiles: ");
        for(int i=0;i<x;++i){
            for(int j=0;j<y;++j){
                if(grid[i][j]!=null)System.out.printf("%-3d ", grid[i][j].finalCost);
                else System.out.print("BL  ");
            }
            System.out.println();
        }
        System.out.println();

        int c = 0;
        if(closed[endI][endJ]){
            //Trace back the path
            System.out.println("Path: ");
            Tile current = grid[endI][endJ];
            System.out.print(current);

            while(current.parent!=null){
                System.out.print(" -> "+current.parent);
                current = current.parent;
                c++;
            }

        }else System.out.println("No possible path");

        System.out.println("Counter : "+c);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public static void pathFind(int x, int y, int si, int sj, int ei, int ej, int[][] blocked){
        //Reset
        grid = new Tile[x][y];
        closed = new boolean[x][y];
        open = new PriorityQueue<>((Object o1, Object o2) -> {
            Tile c1 = (Tile)o1;
            Tile c2 = (Tile)o2;

            return c1.finalCost<c2.finalCost?-1:
                    c1.finalCost>c2.finalCost?1:0;
        });
        //Set start position
        setStartTile(si, sj);  //Setting to 0,0 by default. Will be useful for the UI part

        //Set End Location
        setEndTile(ei, ej);

        for(int i=0;i<x;++i){
            for(int j=0;j<y;++j){
                grid[i][j] = new Tile(i, j);
                grid[i][j].heuristicCost = Math.abs(i-endI)+Math.abs(j-endJ);
//               System.out.print(grid[i][j].heuristicCost+" ");
            }
//           System.out.println();
        }
        grid[si][sj].finalCost = 0;

        /*
          Set blocked Tiles. Simply set the Tile values to null
          for blocked Tiles.
        */
        if(blocked != null){
            for(int i=0;i<blocked.length;++i){
                setBlocked(blocked[i][0], blocked[i][1]);
            }
        }


        //Display initial map
       /* System.out.println("Grid: ");
         for(int i=0;i<x;++i){
             for(int j=0;j<y;++j){
                if(i==si&&j==sj)System.out.print("SO  "); //Source
                else if(i==ei && j==ej)System.out.print("DE  ");  //Destination
                else if(grid[i][j]!=null)System.out.printf("%-3d ", 0);
                else System.out.print("BL  ");
             }
             System.out.println();
         }
         System.out.println();*/

        AStar();
        /*System.out.println("\nScores for Tiles: ");
        for(int i=0;i<x;++i){
            for(int j=0;j<y;++j){
                if(grid[i][j]!=null)System.out.printf("%-3d ", grid[i][j].finalCost);
                else System.out.print("BL  ");
            }
            System.out.println();
        }
        System.out.println();*/

        int c = 0;
        if(closed[endI][endJ]){
            //Trace back the path
            //System.out.println("Path: ");
            Tile current = grid[endI][endJ];
            //System.out.print(current);

            while(current.parent!=null){
                //System.out.print(" -> "+current.parent);
                //System.out.print(current.i+" "+current.j);
                if(Window.getInstance().getPanel().getPath().getCases()!=null)
                    Window.getInstance().getPanel().getPath().getCases().add(new int[]{current.i,current.j});
                else {
                    Window.getInstance().getPanel().getPath().setCases(new ArrayList<int[]>());
                    Window.getInstance().getPanel().getPath().getCases().add(new int[]{current.i,current.j});
                }
                current = current.parent;
                //System.out.print(FenetreArena.getInstance().getPanneauCombat().getPath().getCases().get(0)[0]);
                c++;
            }
        } else System.out.println("No possible path");
    }
}
