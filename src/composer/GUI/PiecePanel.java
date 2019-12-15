import javax.swing.*;
import java.awt.*;

public class PiecePanel extends JPanel
{
    Piece piece;

    public PiecePanel(Piece piece)
    {
        super();
        setLayout(new GridLayout(1, 3));
        this.piece = piece;
        add(new JLabel(piece.getName()));
        add(new JLabel(""+piece.getScore()));
        add(new JButton("play"));
        setMaximumSize(new Dimension(400,30));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public PiecePanel()
    {
        super();
        setLayout(new GridLayout(1, 3));
        setBackground(Color.LIGHT_GRAY);
        this.piece = null;
        Font font = new Font("Courier", Font.BOLD,12);
        JLabel name = new JLabel("Name of Piece");
        name.setFont(font);
        add(name);
        JLabel score = new JLabel("Points of Piece");
        score.setFont(font);
        add(score);
        JLabel play = new JLabel("Play Piece");
        play.setFont(font);
        add(play);
        setMaximumSize(new Dimension(400,30));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
