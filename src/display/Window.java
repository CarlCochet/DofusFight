package display;

import java.awt.Color;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import display.Panel;
import display.Options;

public class Window extends JFrame{

    private static final long serialVersionUID = 1L;

    private static int width = 660;
    private static int height = 898;
    private static int panelHeight = 646;

    private static Window instance;
    private Panel panel;
    private Options options;

    public Window() {
        this.setTitle("Dofus");
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setLocation(10, 100);
        this.setResizable(false);
        this.setLayout(null);
        panel = new Panel(width, panelHeight);
        panel.setBackground(Color.BLACK);
        panel.setLocation(0, 0);
        panel.setSize(width, panelHeight);
        options = new Options(width, height-panelHeight);
        options.setBackground(Color.WHITE);
        options.setLocation(0, panelHeight);
        options.setSize(width, height-panelHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.add(options);
        this.setVisible(true);
    }

    public static Window getInstance() {
        if(instance == null) {
            instance = new Window();
        }
        return instance;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

}