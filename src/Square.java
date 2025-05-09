import javax.swing.*;
import java.awt.*;

public class Square {
    private boolean isMine;
    private int row;
    private int col;
    private  boolean isClicked;
    private GameView window;
    private Image mineImage;
    private Image diamondImage;
    private final int IMAGE_ROW_CHANGE = 150;
    private final int IMAGE_ROW_START = 602;
    private final int IMAGE_COL_CHANGE = 150;
    private final int IMAGE_COL_START = 78;
    private final int IMAGE_DIMENSIONS = 147;

    public Square(int row, int col, GameView window)
    {
        this.isMine = false;
        this.row = row;
        this.col = col;
        this.isClicked = false;
        this.window = window;
        this.mineImage = new ImageIcon("resources/Mine.png").getImage();
        this.diamondImage = new ImageIcon("resources/Diamond.png").getImage();
    }

    public boolean isMine()
    {
        return isMine;
    }

    public void reveal()
    {
        this.isClicked = true;
    }

    public boolean getIsClicked()
    {
        return this.isClicked;
    }

    public void makeMine()
    {
        this.isMine = true;
    }

    public boolean containsPoint(int x, int y) {
        int squareX = row * IMAGE_ROW_CHANGE + IMAGE_ROW_START;
        int squareY = col * IMAGE_COL_CHANGE + IMAGE_COL_START;
        return (x >= squareX && x <= squareX + 147 &&
                y >= squareY && y <= squareY + 147);
    }

    public void draw(Graphics g)
    {
        if (this.isMine)
        {
            g.drawImage(this.mineImage, row * IMAGE_ROW_CHANGE + IMAGE_ROW_START, col * IMAGE_COL_CHANGE + IMAGE_COL_START, IMAGE_DIMENSIONS, IMAGE_DIMENSIONS, window);
        }
        else
        {
            g.drawImage(this.diamondImage, row * IMAGE_ROW_CHANGE + IMAGE_ROW_START, col * IMAGE_COL_CHANGE + IMAGE_COL_START, IMAGE_DIMENSIONS, IMAGE_DIMENSIONS, window);
        }
    }
}
