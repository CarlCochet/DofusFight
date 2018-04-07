package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Options extends JPanel implements ItemListener {

    private int width;
    private int height;
    private int fontSize;
    private int buttonWidth;
    private int buttonHeight;

    public Options(int width, int height){
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0,0,0));
        this.fontSize = 16;
        this.buttonWidth = 200;
        this.buttonHeight = 50;
        initComponents();
    }

    private void initComponents(){
        setLayout(null);

        JButton button=new JButton(new Sight());
        button.setFont(new Font("Arial", Font.PLAIN, fontSize));
        button.setSize(buttonWidth,buttonHeight);
        button.setLocation(0,0);

        this.add(button);

        button = new JButton(new Pathfinding());
        button.setFont(new Font("Arial", Font.PLAIN, fontSize));
        button.setSize(buttonWidth,buttonHeight);
        button.setLocation(0,50);

        this.add(button);

        button = new JButton(new PossibleMoves());
        button.setFont(new Font("Arial", Font.PLAIN, fontSize));
        button.setSize(buttonWidth,buttonHeight);
        button.setLocation(0,100);

        this.add(button);

        button = new JButton(new GenerateMap());
        button.setFont(new Font("Arial", Font.PLAIN, fontSize));
        button.setSize(buttonWidth,buttonHeight);
        button.setLocation(0,150);

        this.add(button);


    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
