import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private Ground ground;
    private JButton[][] buttons;
    private static char turn;

    public ButtonListener(Ground ground, JButton[][] buttons) {
        this.ground = ground;
        this.buttons = buttons;
        turn = 'W';
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean selected = false;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (ground.getGround()[i][j].getSelected()) {
                    selected = true;
                }
            }
        if (!selected) {
            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++)
                    if (e.getSource() == buttons[i][j])
                        for (int k = 0; k < 8; k++)
                            for (int h = 0; h < 8; h++)
                                if (ground.getGround()[h][k].getX() == i && ground.getGround()[h][k].getY() == j && !ground.getGround()[h][k].getName().equals("   ") && ground.getGround()[h][k].getName().toCharArray()[0] == turn) {
                                    ground.getGround()[h][k].setSelected(true);
                                    buttons[i][j].setBackground(new Color(54, 75, 0));
                                    for (int f = 0; f < 8; f++)
                                        for (int l = 0; l < 8; l++) {
                                            if (ground.getGround()[h][k].canMove(l, f, ground)) {
                                                buttons[l][f].setBackground(new Color(255, 211, 0));
                                            }
                                        }
                                }
        } else {
            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        for (int k = 0; k < 8; k++)
                            for (int h = 0; h < 8; h++) {
                                if (ground.getGround()[h][k].getSelected()) {
                                    int x = ground.getGround()[h][k].getX();
                                    int y = ground.getGround()[h][k].getY();
                                    if (ground.getGround()[h][k].movement(i, j, ground)) {
                                        buttons[i][j].setIcon(ground.getGround()[h][k].getManIcon());
                                        buttons[x][y].setIcon(null);
                                        ground.getGround()[h][k].setSelected(false);
                                        if (turn == 'W')
                                            turn = 'B';
                                        else
                                            turn = 'W';
                                    } else {
                                        ground.getGround()[h][k].setSelected(false);
                                    }
                                }
                            }
                    }
                    if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1))
                        buttons[j][i].setBackground(new Color(0, 120, 0));
                    else
                        buttons[j][i].setBackground(new Color(200, 255, 200));
                }
            selected = false;
        }
    }
}
