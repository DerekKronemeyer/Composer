import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;
import java.awt.event.*;

public class GUI extends JFrame
{
    private Controller controller;
    private PiecesPanel piecesPanel;
    private StatisticsPanel stats;
    private EvolutionPanel evolution;
    private ControlPanel control;

    public GUI(Controller controller)
    {
        super("Composer");
        this.controller = controller;
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new GridLayout(1, 2));

        JMenuBar menuBar = new JMenuBar();
            JMenu file = new JMenu("file");
                JMenuItem reset = new JMenuItem("Reset");
                reset.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){reset();}});
                file.add(reset);
                JMenuItem saveGeneration = new JMenuItem("Save Generation");
                file.add(saveGeneration);
                JMenuItem saveRules = new JMenuItem("Save Rules");
                file.add(saveRules);
                JMenuItem saveBest = new JMenuItem("Save Best");
                file.add(saveBest);
                JMenuItem openGeneration = new JMenuItem("Open Generation");
                file.add(openGeneration);
                JMenuItem openRules = new JMenuItem("Open Rules");
                file.add(openRules);
                JMenuItem exit = new JMenuItem("Exit");
                exit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){System.exit(0);}});
                file.add(exit);
            menuBar.add(file);
            JMenu help = new JMenu("Help");
                JMenuItem about = new JMenuItem("About");
                help.add(about);
                JMenuItem welcomeGuide = new JMenuItem("Welcome Guide");
                help.add(welcomeGuide);
            menuBar.add(help);
        setJMenuBar(menuBar);

        piecesPanel = new PiecesPanel(controller);
        JScrollPane scrollPane = new JScrollPane(piecesPanel);
        add(scrollPane);

        //test.setMaximumSize(new Dimension(200, test.getHeight()));
        stats = new StatisticsPanel(controller);
        evolution = new EvolutionPanel(controller);
        control = new ControlPanel(controller);
        JScrollPane scrollPane2 = new JScrollPane(control);

        JSplitPane topPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, stats, evolution);
        topPanel.setOneTouchExpandable(false);
        topPanel.setDividerLocation(90);

        JSplitPane sideSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, scrollPane2);
        sideSplitter.setOneTouchExpandable(false);
        sideSplitter.setDividerLocation(220);

        JSplitPane sidePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, sideSplitter);
        sidePane.setOneTouchExpandable(false);
        sidePane.setDividerLocation(900);
        sidePane.setResizeWeight(1.0);
        sidePane.setEnabled(false);
        BasicSplitPaneDivider divider = (BasicSplitPaneDivider) sidePane.getComponent(2);
        //divider.setBackground(Color.black);
        //divider.setBorder(null);
        divider.setDividerSize(1);

        //Provide minimum sizes for the two components in the split pane
        //Dimension minimumSize = new Dimension(100, 50);
        //listScrollPane.setMinimumSize(minimumSize);
        //pictureScrollPane.setMinimumSize(minimumSize);
        add(sidePane);

        setVisible(true);
    }

    public PiecesPanel getPiecesPanel(){return piecesPanel;}
    public StatisticsPanel getStatisticsPanel(){return stats;}
    public EvolutionPanel getEvolutionPanel(){return evolution;}
    public ControlPanel getControlPanel(){return control;}

    public void refresh()
    {
        //Print.a("refreshing");
        piecesPanel.refresh();
        stats.refresh();// = new StatisticsPanel(controller);
        evolution.refresh();
        //control.refresh();
        //Print.a("refreshed");
    }

    public void reset()
    {
        //FIXME reset all rules too
        controller.restartGeneticAlgorithm();
        controller.refreshGUI();
    }

}
