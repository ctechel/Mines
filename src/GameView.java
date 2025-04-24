// Mines by Carter Techel
import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    // Instance Variable
    private Game game;
    private Image background;
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 900;


    public GameView(Game game)
    {
        this.background = new ImageIcon("resources/Board.png").getImage();

        this.game = game;
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Mines");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.drawImage(background, 225, 100, 700, 700, this);
    }
}
