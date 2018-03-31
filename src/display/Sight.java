package display;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Sight extends AbstractAction {
    private static final long serialVersionUID = 1L;
    public static final String NOM_ACTION = "Show sight";

    public Sight() {
        super(NOM_ACTION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.getInstance().getPanel().setMode(0);
        Window.getInstance().getPanel().repaint();
    }

}
