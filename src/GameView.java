// Mines by Carter Techel
import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    // Instance Variable
    private Game game;
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 800;
    private Image mine;
    private Image background;
    private Image diamond;

    public GameView(Game game)
    {
        this.game = game;

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Mines");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {

    }
}
