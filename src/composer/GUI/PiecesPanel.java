import java.awt.*;
import javax.swing.*;

public class PiecesPanel extends JPanel
{
    Generation generation;
    public PiecesPanel(Generation generation)
    {
        super();
        this.generation = generation;
        setBorder(BorderFactory.createLineBorder(Color.black));
        //JLabel label = new JLabel("test");
        //add(label);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new PiecePanel());//header
        for(int i=0; i<generation.size(); i++)
        {
                add(new PiecePanel(generation.getPiece(i)));
        }
    }
}
