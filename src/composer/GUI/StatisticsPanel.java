import java.awt.*;
import javax.swing.*;

public class StatisticsPanel extends JPanel
{
    Controller controller;
    public StatisticsPanel(Controller controller)
    {
        super();
        this.controller = controller;
        //setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Generation Statistics"));
        //add(new JSeparator(SwingConstants.HORIZONTAL));
        add(new JLabel("Average Score: " + controller.getGeneticAlgorithm().getGeneration().getAverageScore()));
        add(new JLabel("Best Score: " + controller.getGeneticAlgorithm().getGeneration().getBestPiece().getScore()));
    }

    public void refresh()
    {
        //FIXME
        return;
    }
}
