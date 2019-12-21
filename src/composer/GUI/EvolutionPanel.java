import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EvolutionPanel extends JPanel
{
    private Controller controller;
    private JButton cull;
    private JButton repop;
    private JButton eval;
    private JButton sort;
    private JButton next;
    private JTextField genCount;
    private JButton restart;

    public EvolutionPanel(Controller controller)
    {
        super();
        this.controller = controller;
        setLayout(new GridLayout(4,2));
        cull = new JButton("Cull");
        cull.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){cullGeneration();}});
        add(cull);
        repop = new JButton("Repopulate");
        repop.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){repopulateGeneration();}});
        add(repop);
        eval = new JButton("Evaluate");
        eval.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){evaluateGeneration();}});
        add(eval);
        sort = new JButton("Sort");
        sort.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){sortGeneration();}});
        add(sort);
        next = new JButton("Next Generation");
        next.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){nextGeneration();}});
        add(next);
        genCount = new JTextField("1");
        add(genCount);
        restart = new JButton("Restart");
        restart.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){restart();}});
        add(restart);
    }

    public void cullGeneration()
    {
        controller.getGeneration().cull();
        controller.refreshGUI();
    }

    public void repopulateGeneration()
    {
        controller.getGeneration().repopulate();
        controller.refreshGUI();
    }

    public void evaluateGeneration()
    {
        controller.getGeneration().evaluate();
        controller.refreshGUI();
    }

    public void sortGeneration()
    {
        controller.getGeneration().sort();
        controller.refreshGUI();
    }

    public void nextGeneration()
    {
        int count = Integer.valueOf(genCount.getText());
        for(int i=0; i<count; i++)
        {
            controller.getGeneticAlgorithm().advance();
        }
        controller.refreshGUI();
    }

    public void restart()
    {
        controller.restartGeneticAlgorithm();
        controller.refreshGUI();
    }

    public void refresh()
    {
        removeAll();
        //------
        setLayout(new GridLayout(4,2));
        cull = new JButton("Cull");
        cull.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){cullGeneration();}});
        add(cull);
        repop = new JButton("Repopulate");
        repop.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){repopulateGeneration();}});
        add(repop);
        eval = new JButton("Evaluate");
        eval.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){evaluateGeneration();}});
        add(eval);
        sort = new JButton("Sort");
        sort.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){sortGeneration();}});
        add(sort);
        next = new JButton("Next Generation");
        next.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){nextGeneration();}});
        add(next);
        genCount = new JTextField("1");
        add(genCount);
        restart = new JButton("Restart");
        restart.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){restart();}});
        add(restart);
        //------
        revalidate();
        repaint();
    }
}
