import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PiecePanel extends JPanel
{
    Controller controller;
    int index;

    public PiecePanel(Controller controller, int index)
    {
        super();
        this.controller = controller;
        this.index = index;
        setLayout(new GridLayout(1, 4));
        add(new JLabel("" + controller.getPiece(index).getName()));
        add(new JLabel("" + controller.getPiece(index).getScore()));
        JButton display = new JButton("display");
        display.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){displayPiece();}});
        add(display);
        JButton play = new JButton("play");
        play.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){controller.playPiece(index);}});
        add(play);
        //setMaximumSize(new Dimension(400,30));
        setPreferredSize(new Dimension(400,30));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public PiecePanel()//for header
    {
        super();
        setLayout(new GridLayout(1, 4));
        setBackground(Color.LIGHT_GRAY);
        //this.piece = null;
        Font font = new Font("Courier", Font.BOLD,12);
        JLabel name = new JLabel("Name");
        name.setFont(font);
        add(name);
        JLabel score = new JLabel("Points");
        score.setFont(font);
        add(score);
        JLabel display = new JLabel("Display Piece");
        score.setFont(font);
        add(display);
        JLabel play = new JLabel("Play Piece");
        play.setFont(font);
        add(play);
        //setMaximumSize(new Dimension(400,30));
        setPreferredSize(new Dimension(400,30));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void displayPiece()
    {
        PieceDisplay pd = new PieceDisplay(controller, index);
    }
}
