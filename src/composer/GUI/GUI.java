import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;

public class GUI extends JFrame
{
    public GUI()
    {
        super("Composer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new GridLayout(1, 2));




        JMenuBar menuBar = new JMenuBar();
            JMenu file = new JMenu("file");
                JMenuItem reset = new JMenuItem("Reset");
                file.add(reset);
                JMenuItem saveGeneration = new JMenuItem("Save Generation");
                file.add(saveGeneration);
                JMenuItem saveRules = new JMenuItem("Save Rules");
                file.add(saveRules);
                JMenuItem saveBest = new JMenuItem("Save Best");
                file.add(saveBest);
                JMenuItem loadGeneration = new JMenuItem("Load Generation");
                file.add(loadGeneration);
                JMenuItem loadRules = new JMenuItem("Load Rules");
                file.add(loadRules);
                JMenuItem exit = new JMenuItem("Exit");
                file.add(exit);
            menuBar.add(file);
            JMenu help = new JMenu("Help");
                JMenuItem about = new JMenuItem("About");
                help.add(about);
                JMenuItem welcomeGuide = new JMenuItem("Welcome Guide");
                help.add(welcomeGuide);
            menuBar.add(help);
        setJMenuBar(menuBar);


        Composer composer = new Composer();
        Generation generation = new Generation(composer);
        PiecesPanel piecesPanel = new PiecesPanel(generation);
        JScrollPane scrollPane = new JScrollPane(piecesPanel);
        add(scrollPane);

        //test.setMaximumSize(new Dimension(200, test.getHeight()));
        StatisticsPanel stats = new StatisticsPanel(generation);
        ControlPanel control = new ControlPanel();
        JScrollPane scrollPane2 = new JScrollPane(control);
        JSplitPane sideSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT, stats, scrollPane2);
        sideSplitter.setOneTouchExpandable(false);
        sideSplitter.setDividerLocation(150);

        JSplitPane sidePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, sideSplitter);
        sidePane.setOneTouchExpandable(false);
        sidePane.setDividerLocation(550);
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





}
