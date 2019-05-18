import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Elite Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 1900, 1000);
        JPanel chessPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        JPanel blackKnockedMen = new JPanel();
        JPanel whiteKnockedMen = new JPanel();
        JPanel turnPanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3,1));
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
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                button[i][j] = new JButton();
                chessPanel.add(button[i][j]);
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1))
                    button[i][j].setBackground(Color.BLACK);
                else
                    button[i][j].setBackground(Color.WHITE);
            }

        frame.setVisible(true);

    }
}