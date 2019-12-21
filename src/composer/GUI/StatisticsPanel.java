import java.awt.*;
import javax.swing.*;

public class StatisticsPanel extends JPanel
{
    Controller controller;
    JLabel title;
    JLabel genNum;
    JLabel size;
    JLabel avgScore;
    JLabel bestScore;

    public StatisticsPanel(Controller controller)
    {
        super();
        this.controller = controller;

        //setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = new JLabel("Gneration Statistics");
        add(title);
        //add(new JSeparator(SwingConstants.HORIZONTAL));
        genNum = new JLabel("Generation: " + controller.getGeneticAlgorithm().getGeneration().number());
        add(genNum);
        size = new JLabel("Size: " + controller.getGeneticAlgorithm().getGeneration().size());
        add(size);
        avgScore = new JLabel("Average Score: " + controller.getGeneticAlgorithm().getGeneration().getAverageScore());
        add(avgScore);
        bestScore = new JLabel("Best Score: " + controller.getGeneticAlgorithm().getGeneration().getBestPiece().getScore());
        add(bestScore);
    }

    public void refresh()
    {
        removeAll();
        //------
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = new JLabel("Gneration Statistics");
        add(title);
        genNum = new JLabel("Generation: " + controller.getGeneticAlgorithm().getGeneration().number());
        add(genNum);
        size = new JLabel("Size: " + controller.getGeneticAlgorithm().getGeneration().size());
        add(size);
        avgScore = new JLabel("Average Score: " + controller.getGeneticAlgorithm().getGeneration().getAverageScore());
        add(avgScore);
        bestScore = new JLabel("Best Score: " + controller.getGeneticAlgorithm().getGeneration().getBestPiece().getScore());
        add(bestScore);
        //------
        revalidate();
        repaint();
    }

}
