import javax.sound.midi.*;
import java.util.*;
import javax.swing.*;

public class MusicPlayer
{
    int tempo;
    Sequencer sequencer;
    Sequence sequence;
    Thread thread;

    public MusicPlayer(int tempo)
    {
        this.tempo = tempo;
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
                    sequence = new Sequence(Sequence.PPQ, 4);
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
}
