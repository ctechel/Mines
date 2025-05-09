// Mines by Carter Techel
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements MouseListener, MouseMotionListener, ActionListener {
    //Instance Variables
    private GameView window;
    private Square[][] board;
    private boolean gameOver;
    private boolean gameWon;
    private int rows;
    private int cols;
    private int totalMines;
    private int squaresLeft;
    private double multiplier;

    public Game(int rows, int cols)
    {
        this.window = new GameView(this);
        board = new Square[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.totalMines = 1;
        this.squaresLeft = rows * cols;
        this.multiplier = 1.0;
        gameOver = true;
        gameWon = false;

        makeGrid();

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
    }

    public void makeGrid()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                board[i][j] = new Square(i, j, window);
            }
        }
        placeMines(totalMines);
    }

    public void placeMines(int mines)
    {
        int minesLeft = mines;
        while (minesLeft != 0)
        {
            int row = (int) (Math.random() * 5);
            int col = (int) (Math.random() * 5);
            if (!board[row][col].isMine())
            {
                board[row][col].makeMine();
                minesLeft--;
            }
        }
    }

    public Square[][] getBoard() {
        return board;
    }

    public void setBoard(Square[][] board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getTotalMines() {
        return totalMines;
    }

    public void setTotalMines(int totalMines) {
        this.totalMines = totalMines;
    }

    public int getSquaresLeft() {
        return squaresLeft;
    }

    public void setSquaresLeft(int squaresLeft) {
        this.squaresLeft = squaresLeft;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    private void resetGame() {
        gameOver = false;
        squaresLeft = rows * cols;
        makeGrid();
        window.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();


        if (isGameOver()) {
            if (mouseX >= 125 && mouseX <= 225 && mouseY >= 500 && mouseY <= 600) {
                totalMines = 1;
                window.repaint();
                return;
            }

            if (mouseX >= 250 && mouseX <= 350 && mouseY >= 500 && mouseY <= 600) {
                totalMines = 2;
                window.repaint();
                return;
            }

            if (mouseX >= 375 && mouseX <= 475 && mouseY >= 500 && mouseY <= 600) {
                totalMines = 3;
                window.repaint();
                return;
            }
            if (mouseX >= 75 && mouseX <= 525 && mouseY >= 625 && mouseY <= 775) {
                resetGame();
                window.repaint();
            }
            return;
        }

        // Loop through each square to see which was clicked
        {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    Square square = board[row][col];
                    if (!square.getIsClicked() && square.containsPoint(mouseX, mouseY)) {
                        // Mark the square as revealed
                        square.reveal();
                        squaresLeft--;
                        window.repaint();

                        if (square.isMine()) {
                            gameOver = true;
                            return;
                        } else {
                            multiplier += 0.25;
                        }

                        window.repaint();
                        return;
                    }
                }
            }

        }
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
        Game game = new Game(5, 5);
    }
}
