import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private Ground ground;
    private JButton[][] buttons;

    public ButtonListener(Ground ground, JButton[][] buttons) {
        this.ground = ground;
        this.buttons = buttons;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (e.getSource() == buttons[j][i])
                    for (int k = 0; k < 8; k++)
                        for (int l = 0; l < 8; l++)
                            if (ground.getGround()[k][l].getX() == i && ground.getGround()[k][l].getY() == j && !ground.getGround()[l][k].getName().equals("   ")) {
                                buttons[j][i].setBackground(new Color(54, 75, 0));
                                for (int f = 0; f < 8; f++)
                                    for (int h = 0; h < 8; h++) {
                                        if (ground.getGround()[l][k].canMove(h, f, ground)) {
                                            buttons[h][f].setBackground(new Color(255, 211, 0));
                                        }
                                    }
                            }
    }
}
