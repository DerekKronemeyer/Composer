import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;
import java.awt.event.*;

public class RuleSettings extends JFrame
{
    private Controller controller;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;

    public RuleSettings(Controller controller)
    {
        super("Rule Settings");
        this.controller = controller;
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        panel1 = new JPanel();
        tabbedPane.addTab("1", panel1);

        panel2 = new JPanel();
        tabbedPane.addTab("2", panel2);

        panel3 = new JPanel();
        tabbedPane.addTab("3", panel3);

        panel4 = new JPanel();
        tabbedPane.addTab("4", panel4);

        panel5 = new JPanel();
        tabbedPane.addTab("5", panel5);

        add(tabbedPane);

        setVisible(true);
    }

    public void refresh()
    {

    }
}
