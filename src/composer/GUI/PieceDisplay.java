import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;

public class PieceDisplay extends JFrame
{
    Controller controller;
    int index;

    public PieceDisplay(Controller controller, int index)
    {
        super("Piece");
        this.controller = controller;
        this.index = index;
        Piece piece = controller.getGeneticAlgorithm().getGeneration().getPiece(index);
        setSize(250, 900);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(100, 1));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //panel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        panel.add(new JLabel("----------"));
        for(int i=0; i<piece.size(); i++)
        {
            for(int j=0; j<piece.getBar(i).size(); j++)
            {
                panel.add(new JLabel(""+piece.getBar(i).getNote(j).getString()));
            }
            panel.add(new JLabel("----------"));
        }
        JScrollPane sp = new JScrollPane(panel);
        add(sp);
        setVisible(true);
    }
}
