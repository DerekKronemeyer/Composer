import java.awt.*;
import javax.swing.*;

public class ControlPanel extends JPanel
{
    Controller controller;

    public ControlPanel(Controller controller)//Generation generation)
    {
        super();
        this.controller = controller;
        setLayout(new GridLayout(0,2));
        for(int i=0; i<30; i++)
        {
            JLabel label = new JLabel("label"+i);
            //label.setMaximumSize(new Dimension(10, 20));
            add(label);
            JTextField text = new JTextField(""+1000+i);
            //text.setMaximumSize(new Dimension(10, 20));
            add(text);
        }
    }

    public void refresh()
    {
        //FIXME
        return;
    }
}
