// Mines by Carter Techel
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements MouseListener, MouseMotionListener
{
    //Instance Variables
    private GameView window;
    private Square[][] board;
    private boolean gameOver;
    private boolean gameWon;
    private int rows;
    private int cols;
    private int totalMines;
    private int squaresLeft;

    // Constructor
    public Game(int rows, int cols)
    {
        this.window = new GameView(this);
        board = new Square[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.totalMines = 1;
        this.squaresLeft = rows * cols - totalMines;
        gameOver = true;
        gameWon = false;

        makeGrid();

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
    }

    // make the grid of squares
    public void makeGrid()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                board[i][j] = new Square(i, j, window);
            }
        }
        // place however many mines there are on the board
        placeMines(totalMines);
    }

    // randomly place the mines somewhere on the board
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

    // Getters and Setters
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

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    // reset the game once a game is over or someone wins
    private void resetGame() {
        gameOver = false;
        gameWon = false;
        squaresLeft = rows * cols - totalMines;
        makeGrid();
        window.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    // when the mine is pressed od whatever it clikcs on
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        // change the number of mines in the game
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
            // restart game button
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
                        // if the player clicks the last diamond
                        if (squaresLeft == 0 && !square.isMine())
                        {
                            gameWon = true;
                            gameOver = true;
                        }
                        // if the player clicks a mine
                        if (square.isMine())
                        {
                            gameOver = true;
                            return;
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
