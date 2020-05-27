import javax.sound.midi.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class MusicPlayer
{
    int tempo;
    Controller controller;
    Sequencer sequencer;
    Sequence sequence;
    Thread thread;

    public MusicPlayer(int tempo, Controller controller)
    {
        this.tempo = tempo;
        this.controller = controller;
        thread = new Thread();
    }

    public void Play(Piece piece)
    {
        if(thread.isAlive())
        {
            sequencer.stop();
        }
        thread = new Thread(new Runnable() {
        @Override
            public void run() {
                try{
                    sequencer = MidiSystem.getSequencer();
                    sequencer.open();
                    sequence = new Sequence(Sequence.PPQ, 1);
                    Track track = sequence.createTrack();

                    int notePosition = 0;
                    for(int i=0; i<piece.size(); i++)
                    {
                        Bar bar = piece.getBar(i);
                        for(int j=0; j<bar.size(); j++)
                        {
                            Note note = bar.getNote(j);
                            track.add(makeEvent(144, 1, note.getPitch(), 100, notePosition));
                            notePosition = notePosition + note.getDuration();
                            track.add(makeEvent(128, 1, note.getPitch(), 100, notePosition));
                        }
                    }

                    sequencer.setSequence(sequence);
                    sequencer.setTempoInBPM(tempo);
                    sequencer.start();
                    while(true)
                    {
                        if(!sequencer.isRunning())
                        {
                            controller.refreshGUI();
                            sequencer.close();
                            return;
                        }
                    }
                }
                catch(Exception e)
                {
                    Print.a("Failed to play piece");
                }
            }
        });
        thread.start();
    }

    public static MidiEvent makeEvent(int command, int channel, int note, int velocity, int tick)
	{
		MidiEvent event = null;
		try
        {
			ShortMessage a = new ShortMessage();
			a.setMessage(command, channel, note, velocity);
			event = new MidiEvent(a, tick);
		}
		catch (Exception ex)
        {
			ex.printStackTrace();
		}
		return event;
	}

    public void stop()
    {
        if(thread.isAlive())
        {
            sequencer.stop();
        }
    }

    public void save(Piece piece)
    {
        try
        {
            sequence = new Sequence(Sequence.PPQ, 1);
            Track track = sequence.createTrack();

            int notePosition = 0;
            for(int i=0; i<piece.size(); i++)
            {
                Bar bar = piece.getBar(i);
                for(int j=0; j<bar.size(); j++)
                {
                    Note note = bar.getNote(j);
                    track.add(makeEvent(144, 1, note.getPitch(), 100, notePosition));
                    notePosition = notePosition + note.getDuration();
                    track.add(makeEvent(128, 1, note.getPitch(), 100, notePosition));
                }
            }

            String fileName = JOptionPane.showInputDialog("Enter File Name:");
            if(fileName.isEmpty())
            {
                return;
            }
            File dir = new File("savedPieces");
            if(! dir.exists())
            {
                dir.mkdir();
            }
            File file = new File(dir + "\\" + fileName + ".mid");
		    MidiSystem.write(sequence, 1, file);
        }
        catch(Exception e)
        {
            Print.a("File not saved");
        }
    }
}
