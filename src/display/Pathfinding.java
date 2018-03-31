package display;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Pathfinding extends AbstractAction {
    private static final long serialVersionUID = 1L;
    public static final String NOM_ACTION = "Show Pathfinding";

    public Pathfinding() {
        super(NOM_ACTION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.getInstance().getPanel().setMode(1);
        Window.getInstance().getPanel().repaint();
    }

}