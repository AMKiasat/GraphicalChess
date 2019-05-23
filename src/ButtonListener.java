import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private Ground ground;
    private JButton[][] buttons;
    private static char turn;
    private JButton[] bKnockedMen;
    private JButton[] wKnockedMen;
    private JPanel turnPanel;

    public ButtonListener(Ground ground, JButton[][] buttons, JButton[] bKnockedMen, JButton[] wKnockedMen, JPanel turnPanel) {
        this.ground = ground;
        this.buttons = buttons;
        this.bKnockedMen = bKnockedMen;
        this.wKnockedMen = wKnockedMen;
        this.turnPanel = turnPanel;
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
                                                if (buttons[l][f].getIcon() == null)
                                                    buttons[l][f].setBackground(new Color(255, 211, 0));
                                                else
                                                    buttons[l][f].setBackground(new Color(255, 88, 91));
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
            String[] black = new String[16];
            String[] white = new String[16];
            int j = 0;
            int k = 0;
            for (int i = 0; i < ground.getKnockedChessMan().size(); i++)
                if (ground.getKnockedChessMan().get(i).toCharArray()[0] == 'W') {
                    white[j] = ground.getKnockedChessMan().get(i);
                    j++;
                }
            for (int i = 0; i < ground.getKnockedChessMan().size(); i++)
                if (ground.getKnockedChessMan().get(i).toCharArray()[0] == 'B') {
                    black[k] = ground.getKnockedChessMan().get(i);
                    k++;
                }
            for (int i = 0; i < j; i++) {
                if (white[i].toCharArray()[1] == 'N')
                    wKnockedMen[i].setIcon(new ImageIcon("chess-knightW.png"));
                else if (white[i].toCharArray()[1] == 'P')
                    wKnockedMen[i].setIcon(new ImageIcon("chess-pawnW.png"));
                else if (white[i].toCharArray()[1] == 'Q')
                    wKnockedMen[i].setIcon(new ImageIcon("chess-queenW.png"));
                else if (white[i].toCharArray()[1] == 'R')
                    wKnockedMen[i].setIcon(new ImageIcon("chess-rookW.png"));
                else if (white[i].toCharArray()[1] == 'B')
                    wKnockedMen[i].setIcon(new ImageIcon("chess-bishopW.png"));
            }
            for (int i = 0; i < k; i++) {
                if (black[i].toCharArray()[1] == 'N')
                    bKnockedMen[i].setIcon(new ImageIcon("chess-knightB.png"));
                else if (black[i].toCharArray()[1] == 'P')
                    bKnockedMen[i].setIcon(new ImageIcon("chess-pawnB.png"));
                else if (black[i].toCharArray()[1] == 'Q')
                    bKnockedMen[i].setIcon(new ImageIcon("chess-queenB.png"));
                else if (black[i].toCharArray()[1] == 'R')
                    bKnockedMen[i].setIcon(new ImageIcon("chess-rookB.png"));
                else if (black[i].toCharArray()[1] == 'B')
                    bKnockedMen[i].setIcon(new ImageIcon("chess-bishopB.png"));
            }
            if (turn == 'W') {
                turnPanel.removeAll();
                JLabel a = new JLabel("WHITE'S TURN");
                turnPanel.add(a);
            } else {
                turnPanel.removeAll();
                JLabel a = new JLabel("BLACK'S TURN");
                a.setSize(100,100);
                turnPanel.add(a);
            }
        }
    }
}