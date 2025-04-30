// Mines by Carter Techel
import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    // Instance Variable
    private Game game;
    private Image background;
    private static final int WINDOW_WIDTH = 1500;
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
        g.drawImage(background, 600, 75, 750, 750, this);

        g.setColor(Color.MAGENTA);
        g.fillRect(75, 625, 450, 150);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 80));
        g.drawString("START", 165, 725);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 120));
        g.drawString("MINES", 100, 175);

        for (int i = 0; i < game.getBoard().length; i++)
        {
            for (int j = 0; j < game.getBoard()[0].length; j++)
            {
                if (game.getBoard()[i][j].getIsClicked())
                {
                    game.getBoard()[i][j].draw(g);
                }
            }
        }
    }
}
