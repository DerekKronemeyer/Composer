import javax.sound.midi.*;
import java.util.*;
import java.util.ArrayList;

public class MusicPlayer
{
    int tempo;

    public MusicPlayer(int tempo)
    {
        this.tempo = tempo;
    }


    public void Play(ArrayList<Integer> piece)
    {
        try
        {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();
            for(int i=0; i<piece.size(); i++)
            {
                track.add(makeEvent(144, 1, piece.get(i), 100, i));
                track.add(makeEvent(128, 1, piece.get(i), 100, i+1));
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
            Print.a("Failed to play song");
        }
    }

    public void Play(Piece piece)
    {
        try
        {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
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
            Print.a("Failed to play song");
        }
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
}
