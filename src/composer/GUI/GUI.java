import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    public GUI()
    {
        super("Composer");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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

        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
        bigPanel.add(new PiecePanel());
        for(int i=0; i<100; i++)
        {
            Piece piece = new Piece();
            piece.setName("piece" + i);
            PiecePanel piecePanel = new PiecePanel(piece);
            bigPanel.add(piecePanel);
        }

        JScrollPane scrollPane = new JScrollPane(bigPanel);

        add(scrollPane);

        setVisible(true);
    }





}
