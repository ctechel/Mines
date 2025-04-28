// Mines by Carter Techel
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements MouseListener, MouseMotionListener, ActionListener {
    //Instance Variables
    private GameView window;
    private Square[][] board;
    private boolean startRound;

    public Game()
    {
        this.window = new GameView(this);
        board = new Square[5][5];
        startRound = false;

        makeGrid();
        runGame();
        window.repaint();
    }

    public void makeGrid()
    {
        int row = (int) Math.random() * 5;
        int col = (int) Math.random() * 5;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (i == row && j == col)
                {
                    board[i][j] = new Square(true, i, j, window);
                }
                else
                {
                    board[i][j] = new Square(false, i , j, window);
                }
            }
        }
    }

    public void runGame()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}
