import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class PiecesPanel extends JPanel
{
    Controller controller;
    ArrayList<PiecePanel> panels;

    public PiecesPanel(Controller controller)
    {
        super();
        this.panels = new ArrayList<PiecePanel>();
        this.controller = controller;
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new PiecePanel());//header
        for(int i=0; i<controller.getGeneticAlgorithm().size(); i++)
        {
            panels.add(new PiecePanel(controller, i));
            add(panels.get(i));
        }
    }

    public void refresh()
    {
        removeAll();
        //------
        this.panels = new ArrayList<PiecePanel>();
        //controller isn't changed
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new PiecePanel());//header
        for(int i=0; i<controller.getGeneticAlgorithm().size(); i++)
        {
            panels.add(new PiecePanel(controller, i));
            add(panels.get(i));
        }
        //------
        revalidate();
        repaint();
    }

    public PiecePanel getPiecePanel(int index){return panels.get(index);}
}
