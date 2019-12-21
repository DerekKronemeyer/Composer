import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PiecePanel extends JPanel
{
    Controller controller;
    int index;
    JButton display;
    JButton play;
    JButton save;
    JButton delete;

    public PiecePanel(Controller controller, int index)
    {
        super();
        this.controller = controller;
        this.index = index;
        setLayout(new GridLayout(1, 5));
        add(new JLabel("" + controller.getPiece(index).getName()));
        add(new JLabel("" + controller.getPiece(index).getScore()));
        display = new JButton("display");
        display.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){displayPiece();}});
        add(display);
        play = new JButton("play");
        play.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){playPressed();}});
        play.setBackground(Color.GREEN);
        add(play);
        save = new JButton("save");
        save.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){savePressed();}});
        save.setBackground(new Color(100,100,255));
        add(save);
        delete = new JButton("delete");
        delete.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){deletePressed();}});
        delete.setBackground(new Color(153,0,0));
        add(delete);
        setPreferredSize(new Dimension(400,30));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public PiecePanel()//for header
    {
        super();
        setLayout(new GridLayout(1, 5));
        setBackground(Color.LIGHT_GRAY);
        Font font = new Font("Courier", Font.BOLD,12);
        JLabel name = new JLabel("Name");
        name.setFont(font);
        add(name);
        JLabel score = new JLabel("Points");
        score.setFont(font);
        add(score);
        JLabel display = new JLabel("Display Piece");
        score.setFont(font);
        add(display);
        JLabel play = new JLabel("Play Piece");
        play.setFont(font);
        add(play);
        JLabel save = new JLabel("Save Piece");
        save.setFont(font);
        add(save);
        JLabel delete = new JLabel("Delete Piece");
        delete.setFont(font);
        add(delete);
        setPreferredSize(new Dimension(400,30));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void playPressed()
    {
        controller.refreshGUI();
        controller.playPiece(index);
        controller.getPiecePanel(index).setStopButton();
    }

    public void setStopButton()
    {
        play.setText("stop");
        play.setBackground(Color.RED);
        for( ActionListener al : play.getActionListeners()){
            play.removeActionListener(al);
        }
        play.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){stopPressed();}});
    }

    public void stopPressed()
    {
        controller.refreshGUI();
        controller.stopPlaying();
    }

    public void savePressed()
    {
        controller.savePiece(index);
    }

    public void deletePressed()
    {
        controller.getGeneticAlgorithm().getGeneration().deletePiece(index);
        controller.refreshGUI();
    }

    public void displayPiece()
    {
        PieceDisplay pd = new PieceDisplay(controller, index);
    }

    public JButton getPlayButton()
    {
        return play;
    }

}
