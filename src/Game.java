// Mines by Carter Techel
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements MouseListener, MouseMotionListener, ActionListener {
    //Instance Variables
    private GameView window;
    private Square[][] board;
    private boolean gameOver;
    private int rows;
    private int cols;
    private int totalMines;
    private int sqauresLeft;
    private double multiplier;

    public Game(int rows, int cols, int totalMines)
    {
        this.window = new GameView(this);
        board = new Square[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.totalMines = totalMines;
        this.sqauresLeft = rows * cols;
        this.multiplier = 1.0;
        gameOver = false;

        makeGrid();
        window.repaint();
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
            board[row][col].makeMine();
            minesLeft--;
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

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
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

    public int getSqauresLeft() {
        return sqauresLeft;
    }

    public void setSqauresLeft(int sqauresLeft) {
        this.sqauresLeft = sqauresLeft;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
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
        Game game = new Game(5, 5, 1);
    }
}
