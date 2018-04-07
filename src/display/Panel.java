package display;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import maps.Map;
import maps.Path;
import maps.PathFinder;

public class Panel extends JPanel implements MouseListener, MouseMotionListener{
    private static final long serialVersionUID = 1L;

    private Map map;
    private int cellSize;

    private int width;
    private int height;

    private int mode;

    private int maxPO;
    private int maxPM;

    private int[] start;
    private int[] end;
    private Path path;

    private List<int[]> possibleMoves = new ArrayList<>();

    public Panel(int width, int height) {
        this.mode = 0;
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(this.width, this.height));
        this.map = new Map();
        this.start = new int[2];
        this.maxPO = 10;
        this.maxPM = 6;
        start[0] = 15;
        start[1] = 15;
        this.end = new int[2];
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        this.cellSize = width/map.getCells().length;

        g2d.setColor(new Color(255,255,255));
        g2d.fillRect(0,0, width, height);

        for(int i = 0 ; i < map.getCells().length ; i++){
            g2d.setColor(new Color(0, 0 ,0));
            g2d.drawLine(i * cellSize, 0, i * cellSize, height);
            if(i <= map.getCells()[0].length) {
                g2d.drawLine(0, i * cellSize, width, i * cellSize);
            }
            for(int k = 0 ; k < map.getCells()[0].length ; k++){
                if(map.getCells()[i][k].getCelltype() == 0){
                    g2d.setColor(new Color(128, 128, 128));
                } else if (map.getCells()[i][k].getCelltype() == 1){
                    g2d.setColor(new Color(0, 0, 0));
                } else if(map.getCells()[i][k].getTargeted() && this.mode == 0){
                    g2d.setColor(new Color(66, 192, 255));
                    map.getCells()[i][k].setTargeted(false);
                } else if(map.getCells()[i][k].getPossibleMove() && this.mode == 2){
                    g2d.setColor(new Color(60,255,60));
                    map.getCells()[i][k].setPossibleMove(false);
                } else {
                    g2d.setColor(new Color(255, 255, 255));
                }
                g2d.fillRect(i * cellSize + 1, k * cellSize + 1, cellSize - 1, cellSize - 1);
            }
        }
        if(this.mode == 1){
            g2d.setColor(new Color(255, 0, 0));
            g2d.fillRect(start[0] * cellSize + 1, start[1] * cellSize + 1, cellSize - 1, cellSize - 1);
            g2d.setColor(new Color(60,255,60));
            if(this.getPath() != null) {
                for (int i = 0; i < this.getPath().getCases().size(); i++) {
                    int posX = (int) (path.getCases().get(i)[0]);
                    int posY = (int) (path.getCases().get(i)[1]);

                    if (posX > -1 && posY > -1 && posX < this.getMap().getCells().length && posY < this.getMap().getCells()[0].length) {
                        if (Window.getInstance().getPanel().getMap().getCells()[posX][posY].getCelltype() > 1) {
                            g2d.fillRect(posX * cellSize + 1, posY * cellSize + 1, cellSize - 1, cellSize - 1);
                        }
                    }

                }
            }
        }
        if(this.mode == 2){
            g2d.setColor(new Color(255, 0, 0));
            g2d.fillRect(start[0] * cellSize + 1, start[1] * cellSize + 1, cellSize - 1, cellSize - 1);
            g2d.setColor(new Color(60,255,60));

        }
        g2d.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()/cellSize;
        int y = e.getY()/cellSize;
        if(this.mode == 1){
            this.start[0] = x;
            this.start[1] = y;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX()/cellSize;
        int y = e.getY()/cellSize;
        if(this.mode == 0) {
            for (int a = 0; a < map.getCells().length; a++) {
                for (int b = 0; b < map.getCells()[0].length; b++) {
                    map.getCells()[a][b].setTargeted(map.visibility(x, y, a, b, this.maxPO));
                }
            }
        } else if(this.mode == 1){
            this.end[0] = x;
            this.end[1] = y;
            if(map.getCells()[start[0]][start[1]].getCelltype() > 1 && (Math.abs(end[0]-start[0])+Math.abs(end[1]-start[1])) <= this.maxPM) {
                calculatePath(start[0], start[1], end[0], end[1], this.maxPM);
            }
        } else if(this.mode == 2){ // This mode gets all cells reachable from 1 point with a given amount of PM
            this.start[0] = x;
            this.start[1] = y;
            for(int i = -this.maxPM ; i <= this.maxPM ; i++){
                for(int k = -this.maxPM ; k <= this.maxPM ; k++){
                    this.end[0] = x + i;
                    this.end[1] = y + k;
                    if(x + i >= 0 && x + i < 34 && y + k >= 0 && y + k < 34) { // Checking it's not out of the map
                        map.getCells()[end[0]][end[1]].setPossibleMove(calculatePath(start[0], start[1], end[0], end[1], this.maxPM));
                    }
                }
            }
        }
        this.repaint();
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int[] getStart() {
        return start;
    }

    public void setStart(int[] start) {
        this.start = start;
    }

    public int[] getEnd() {
        return end;
    }

    public void setEnd(int[] end) {
        this.end = end;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public boolean calculatePath(int x1, int y1, int x2, int y2, int maxLength){
        if(map.getCells()[x1][y1].getCelltype() > 1 && (Math.abs(x2-x1)+Math.abs(y2-y1)) <= maxLength) {
            this.setPath(new Path(new int[]{1, 1}, new int[]{x2, y2}));
            this.getPath().setCases(new ArrayList<int[]>());
            PathFinder.pathFind(map.getCells().length, map.getCells()[0].length, x1, y1, x2, y2, this.getMap().getBlock());
            if (this.getPath().getCases().size() <= maxLength) {
                System.out.println(this.getPath().getCases().size());
                this.repaint();
                return true;
            } else {
                this.setPath(new Path(new int[]{5, 5}, new int[]{-1, -1}));
                return false;
            }

        }
        return false;
    }

}