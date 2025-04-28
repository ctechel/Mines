import javax.swing.*;
import java.awt.*;

public class Square {
    private boolean isMine;
    private int row;
    private int col;
    private  boolean isClicked;
    private GameView window;
    private Image image;

    public Square(boolean isMine, int row, int col, GameView window)
    {
        this.isMine = isMine;
        this.row = row;
        this.col = col;
        this.isClicked = false;
        this.window = window;

        if (this.isMine)
        {
            this.image = new ImageIcon("resources/Mine.png").getImage();
        }
        else
        {
            this.image = new ImageIcon("resources/Diamond.png").getImage();
        }
    }

    public boolean isMine()
    {
        return isMine;
    }

    public void draw(Graphics g)
    {

    }
}
