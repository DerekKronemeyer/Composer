import java.awt.*;
import javax.swing.*;

public class StatisticsPanel extends JPanel
{
    Generation generation;
    public StatisticsPanel(Generation generation)
    {
        super();
        this.generation = generation;
        //setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Generation Statistics"));
        //add(new JSeparator(SwingConstants.HORIZONTAL));
        add(new JLabel("Average Score: " + generation.getAverageScore()));
        add(new JLabel("Best Score: " + generation.getBestPiece().getScore()));
    }
}
