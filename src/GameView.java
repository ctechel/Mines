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

        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("Click the number of mines you want", 75, 230);
        g.drawString("to play with below. Once you have", 75, 260);
        g.drawString("selected the number of mines you", 75, 290);
        g.drawString("wish to play with click start.", 75, 320);
        g.drawString("Once you are in game you can't exit", 75, 350);
        g.drawString("if you click a mine or win click", 75, 380);
        g.drawString("start to play again. To win click all", 75, 410);
        g.drawString("the diamonds before clicking a mine.", 75, 440);

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

        for (int i = 1; i <= 3; i++)
        {
            int x = 125 + (i - 1) * 125;
            int y = 500;
            int width = 100;
            int height = 100;

            if (game.getTotalMines() == i)
            {
                g.setColor(Color.GREEN);
                g.fillRect(x, y, width, height);
            }
            else
            {
                g.setColor(Color.WHITE);
                g.fillRect(x, y, width, height);
            }

            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.BOLD, 120));
            g.drawString("" + i, x + 20, y + 90);
        }

        if (game.isGameOver())
        {
            if (game.isGameWon())
            {
                g.setColor(Color.GREEN);
                g.setFont(new Font("Serif", Font.BOLD, 120));
                g.drawString("YOU WIN!", 350, 400);
            }
        }
    }
}
