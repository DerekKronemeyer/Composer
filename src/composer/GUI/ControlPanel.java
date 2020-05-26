import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ControlPanel extends JPanel
{
    Controller controller;
    JLabel composerSettings, keySig;
    JButton composerSettingsButton, keySigButton;

    public ControlPanel(Controller controller)//Generation generation)
    {
        super();
        this.controller = controller;

        // composerSettings = new JLabel("Composer Settings");
        // composerSettingsButton = new JButton("Change");
        // composerSettingsButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){changeComposerSettings();}});
        // add(composerSettings);
        // add(composerSettingsButton);
        //
        
        keySig = new JLabel("Key Signature: " + controller.getKeySignature().getName());
        keySigButton = new JButton("Change");
        keySigButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){changeKeySignature();}});
        add(keySig);
        add(keySigButton);







    }

    public void changeKeySignature()
    {
        String[] keySigs = { "Major" , "Minor" , "Dorian" , "Phrygian" , "Lydian" , "Mixolydian" , "Ionian" , "Aeolian" , "Locrian" , "Pentatonic" , "Hexatonic" , "Heptatonic" , "Nonatonic", "None"};
        String input = (String)JOptionPane.showInputDialog(null, "Which key Signature would you like to use?", "Key Signature Selection", JOptionPane.QUESTION_MESSAGE, null, keySigs, keySigs[0]);
        for(int i=0; i<keySigs.length; i++)
        {
            if(input.equals(keySigs[i]))
                controller.getKeySignature().setKeySignature(i);
        }
        controller.refreshControlPanel();
    }

    public void refresh()
    {
        removeAll();
        //------


        keySig = new JLabel("Key Signature: " + controller.getKeySignature().getName());
        keySigButton = new JButton("Change");
        keySigButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){changeKeySignature();}});
        add(keySig);
        add(keySigButton);


        //------
        revalidate();
        repaint();
    }
}
