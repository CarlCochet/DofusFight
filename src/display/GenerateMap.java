package display;


import javax.swing.*;
import java.awt.event.ActionEvent;


public class GenerateMap extends AbstractAction {
    private static final long serialVersionUID = 1L;
    public static final String NOM_ACTION = "Generate Map";

    public GenerateMap() {
        super(NOM_ACTION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.getInstance().getPanel().getMap().generate();
        Window.getInstance().getPanel().repaint();
    }

}