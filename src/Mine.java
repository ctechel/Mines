import javax.swing.*;
import java.awt.*;

// Mines by Carter Techel
public class Mine {
    private int row;
    private int col;
    private boolean isClicked;
    private Image mine;


    public Mine()
    {
        this.mine = new ImageIcon("resources/Mine.png").getImage();

    }

    public void draw(Graphics g)
    {

    }
}
