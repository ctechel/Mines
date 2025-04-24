import javax.swing.*;
import java.awt.*;

// Mines by Carter Techel
public class Diamond {
    private int row;
    private int col;
    private boolean isClicked;
    private Image diamond;

    public Diamond()
    {
        this.diamond = new ImageIcon("resources/Diamond.png").getImage();
    }

    public void draw(Graphics g)
    {

    }
}
