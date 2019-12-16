import java.awt.*;
import javax.swing.*;

public class ControlPanel extends JPanel
{
    //Generation generation;

    public ControlPanel()//Generation generation)
    {
        super();
        //this.generation = generation;
        setLayout(new GridLayout(0,2));
        //add(new JLabel("Control Rules"));
        //add(new JSeparator(SwingConstants.HORIZONTAL));

        //String[] descriptions = {"Population Size: ", "Survival Size: ", "Mutation Size"};
        //int[] values = {1000, 10, 100};
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
}
