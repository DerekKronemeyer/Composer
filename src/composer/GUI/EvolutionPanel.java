import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EvolutionPanel extends JPanel
{
    private Controller controller;
    private JButton cull;
    private JTextField genCount;

    public EvolutionPanel(Controller controller)
    {
        super();
        this.controller = controller;
        setLayout(new GridLayout(3,2));

        cull = new JButton("Cull");
        cull.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){cullGeneration();}});
        add(cull);

        JButton repop = new JButton("Repopulate");
        repop.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){repopulateGeneration();}});
        add(repop);

        JButton eval = new JButton("Evaluate");
        eval.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){evaluateGeneration();}});
        add(eval);

        JButton sort = new JButton("Sort");
        sort.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){sortGeneration();}});
        add(sort);

        JButton next = new JButton("Next Generation");
        next.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){nextGeneration();}});
        add(next);

        genCount = new JTextField("1");
        add(genCount);
    }

    public void cullGeneration()
    {                           //FIXME maybe pas in gnetic algorithm instead of gui?
        //Print.a("evo pane");
        //GeneticAlgorithm ga = gui.getGeneticAlgorithm2();//.getGeneration().cull();
        //gui.refresh();
        //Print.a("done");
    }

    public void repopulateGeneration()
    {
        //gui.getGeneticAlgorithm().getGeneration().repopulate();
        //gui.refresh();
    }

    public void evaluateGeneration()
    {
        //gui.getGeneticAlgorithm().getGeneration().evaluate();
        //gui.refresh();
    }

    public void sortGeneration()
    {
        //gui.getGeneticAlgorithm().getGeneration().sort();
        //gui.refresh();
    }

    public void nextGeneration()
    {
        int count = Integer.valueOf(genCount.getText());
        Print.a(""+count);
        for(int i=0; i<count; i++)
        {
            //gui.getGeneticAlgorithm().advance();
        }
        //gui.refresh();
    }

    public void refresh()
    {
        //FIXME
        return;
    }
}
