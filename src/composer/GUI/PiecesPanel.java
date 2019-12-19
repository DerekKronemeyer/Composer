import java.awt.*;
import javax.swing.*;

public class PiecesPanel extends JPanel
{
    Controller controller;
    //Generation generation;
    public PiecesPanel(Controller controller)
    {
        super();
        this.controller = controller;
        //this.generation = generation;
        setBorder(BorderFactory.createLineBorder(Color.black));
        //JLabel label = new JLabel("test");
        //add(label);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new PiecePanel());//header
        for(int i=0; i<controller.getGeneticAlgorithm().getGeneration().size(); i++)
        {
            add(new PiecePanel(controller, i));
        }
    }

    public void refresh()
    {
        //FIXME
        return;
    }
}
