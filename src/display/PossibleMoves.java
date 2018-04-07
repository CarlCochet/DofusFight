package display;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PossibleMoves extends AbstractAction {
    private static final long serialVersionUID = 1L;
    public static final String NOM_ACTION = "Show Possible Moves";

    public PossibleMoves() {
        super(NOM_ACTION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.getInstance().getPanel().setMode(2);
        Window.getInstance().getPanel().repaint();
    }
}

