import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton[][] buttons;
    private Logic game;

    public GUI() {
        game = new Logic();
        buttons = new JButton[3][3];

        // Set up the GUI
        JPanel panel = new JPanel(new GridLayout(3, 3));
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
                buttons[row][col].addActionListener(new ButtonClickListener(row, col));
                panel.add(buttons[row][col]);
            }
        }

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (game.isGameOver() || game.getWinner() != Logic.EMPTY) {
                return;
            }

            if (game.makeMove(row, col)) {
                buttons[row][col].setText(game.getCurrentPlayer() == Logic.X ? "X" : "O");
                if (game.getWinner() != Logic.EMPTY) {
                    JOptionPane.showMessageDialog(GUI.this, "Player " + game.getWinner() + " wins!");
                } else if (game.isGameOver()) {
                    JOptionPane.showMessageDialog(GUI.this, "It's a tie!");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
