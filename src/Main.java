import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        char turn = 'W';
        Ground chess = new Ground();
        JFrame frame = new JFrame("Elite Chess");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage("Icons\\chess-kingW.png");
        frame.setIconImage(img);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 1900, 1000);
        JPanel chessPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        JPanel blackKnockedMen = new JPanel();
        blackKnockedMen.setLayout(new GridLayout(2, 8));
        JPanel whiteKnockedMen = new JPanel();
        whiteKnockedMen.setLayout(new GridLayout(2, 8));
        JPanel turnPanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3, 1));
        sidePanel.add(whiteKnockedMen);
        sidePanel.add(turnPanel);
        sidePanel.add(blackKnockedMen);
        whiteKnockedMen.setBackground(Color.BLACK);
        blackKnockedMen.setBackground(Color.WHITE);
        frame.setLayout(new GridLayout());
        frame.getContentPane().add(sidePanel);
        frame.getContentPane().add(chessPanel);
        chessPanel.setBackground(Color.WHITE);
        chessPanel.setLayout(new GridLayout(8, 8));
        JButton[][] button = new JButton[8][8];
        JButton[] bKnockedMen = new JButton[16];
        JButton[] wKnockedMen = new JButton[16];
        JLabel a = new JLabel();
        a.setIcon(new ImageIcon("Icons\\W.png"));
        turnPanel.add(a);
        int b = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 8; j++) {
                bKnockedMen[b] = new JButton();
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1))
                    bKnockedMen[b].setBackground(new Color(167, 99, 11));
                else
                    bKnockedMen[b].setBackground(new Color(255, 213, 175));
                blackKnockedMen.add(bKnockedMen[b]);
                b++;
            }
        b = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 8; j++) {
                wKnockedMen[b] = new JButton();
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1))
                    wKnockedMen[b].setBackground(new Color(167, 99, 11));
                else
                    wKnockedMen[b].setBackground(new Color(255, 213, 175));
                whiteKnockedMen.add(wKnockedMen[b]);
                b++;
            }
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++)
                    for (int h = 0; h < 8; h++) {
                        if (chess.getGround()[h][k].getX() == i && chess.getGround()[h][k].getY() == j)
                            button[i][j] = new JButton(chess.getGround()[h][k].getManIcon());
                    }
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1))
                    button[i][j].setBackground(new Color(0, 120, 0));
                else
                    button[i][j].setBackground(new Color(200, 255, 200));
            }
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                chessPanel.add(button[j][i]);
            }
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                button[i][j].addActionListener(new ButtonListener(chess, button, wKnockedMen, bKnockedMen, turnPanel));
        frame.setVisible(true);
    }
}
