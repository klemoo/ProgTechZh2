package progtechzh2.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import progtechzh2.model.Field;
import progtechzh2.model.InvalidMoveException;
import progtechzh2.model.KnightModel;

public class KnightFrame extends JFrame {
    
    private static final int SIZE = 5;
    
    private final JButton[][] buttons = new JButton[SIZE][SIZE];
    private final JPanel mainPanel = new JPanel();
    
    private final KnightModel model = new KnightModel(SIZE);
    
    public KnightFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Knight Game");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        
        this.mainPanel.setLayout(new GridLayout(SIZE,SIZE));
        
        for(int i = 0; i < SIZE; ++i) {
            for(int j = 0; j < SIZE; ++j) {
                JButton b = new JButton();
                final int x = i;
                final int y = j;
                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            model.moveTo(x, y);
                        } catch (InvalidMoveException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                            
                        }
                        drawColors();
                        if(model.isVictory()) {
                            JOptionPane.showMessageDialog(null,"WIN!");
                            model.start();
                            
                        }
                    }
                    
                });
                this.buttons[i][j] = b;
                this.mainPanel.add(b);
            }
        }
        
        this.add(this.mainPanel);
        
        this.model.start();
        drawColors();
    }
    
    private void drawColors() {
        for(int i = 0; i < SIZE; ++i) {
            for(int j = 0; j < SIZE; ++j) {
                if(this.model.getFieldStatus(i, j) == Field.EMPTY_FIELD) {
                    this.buttons[i][j].setBackground(Color.WHITE);
                } else if (this.model.getFieldStatus(i, j) == Field.ON_FIELD) {
                    this.buttons[i][j].setBackground(Color.BLACK);
                } else if (this.model.getFieldStatus(i, j) == Field.VISITED_FIELD) {
                    this.buttons[i][j].setBackground(Color.GRAY);
                }
            }
        }
    }
}
