import javax.swing.*;
import java.awt.*;

public class PiecePanel extends JPanel
{
    Piece piece;

    public PiecePanel(Piece piece)
    {
        super();
        setLayout(new GridLayout(1, 4));
        this.piece = piece;
        add(new JLabel(piece.getName()));
        add(new JLabel(""+piece.getScore()));
        add(new JButton("display"));
        add(new JButton("play"));
        //setMaximumSize(new Dimension(400,30));
        setPreferredSize(new Dimension(400,30));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public PiecePanel()//for header
    {
        super();
        setLayout(new GridLayout(1, 4));
        setBackground(Color.LIGHT_GRAY);
        this.piece = null;
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
}
