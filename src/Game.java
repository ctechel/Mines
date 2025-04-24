// Mines by Carter Techel
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements MouseListener, MouseMotionListener, ActionListener {
    //Instance Variables
    private GameView window;
    private Mine[][] board;

    public Game()
    {
        this.window = new GameView(this);

        window.repaint();
    }

    public static void main(String[] args) {
        Game game = new Game();
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
}
