import java.util.ArrayList;
import java.util.concurrent.*;

public class Note
{
    private int pitch;
    private int duration;

    public Note(int pitch, int duration)
    {
        this.pitch = pitch;
        this.duration = duration;
    }

    public Note(Note note)
    {
        this.pitch = note.getPitch();
        this.duration = note.getDuration();
    }

    public void setPitch(int pitch)
    {
        this.pitch = pitch;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public int getPitch()
    {
        return this.pitch;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public void Print()
    {
        String noteLetter = "NULL";
        int temp = pitch;
        int octave = -1;
        while(temp >= 12)
        {
            temp = temp - 12;
            octave = octave + 1;
        }
        if(temp == 0){noteLetter = "C";}
        if(temp == 1){noteLetter = "C#/Db";}
        if(temp == 2){noteLetter = "D";}
        if(temp == 3){noteLetter = "D#/Eb";}
        if(temp == 4){noteLetter = "E";}
        if(temp == 5){noteLetter = "F";}
        if(temp == 6){noteLetter = "F#/Gb";}
        if(temp == 7){noteLetter = "G";}
        if(temp == 8){noteLetter = "G#/Ab";}
        if(temp == 9){noteLetter = "A";}
        if(temp == 10){noteLetter = "A#/Bb";}
        if(temp == 11){noteLetter = "B";}
        Print.p("Pitch: " + noteLetter + octave + ", Duration: " + duration);
        //Print.p("Pitch: " + pitch + ", Duration: " + duration);
    }

    public String getLetter()
    {
        String noteLetter = "NULL";
        int temp = pitch;
        while(temp >= 12)
        {
            temp = temp - 12;
        }
        if(temp == 0){noteLetter =  "C ";}
        if(temp == 1){noteLetter =  "C#";}
        if(temp == 2){noteLetter =  "D ";}
        if(temp == 3){noteLetter =  "D#";}
        if(temp == 4){noteLetter =  "E ";}
        if(temp == 5){noteLetter =  "F ";}
        if(temp == 6){noteLetter =  "F#";}
        if(temp == 7){noteLetter =  "G ";}
        if(temp == 8){noteLetter =  "G#";}
        if(temp == 9){noteLetter =  "A ";}
        if(temp == 10){noteLetter = "A#";}
        if(temp == 11){noteLetter = "B ";}
        return noteLetter;
    }

    public void mutateNote(int intensity)
    {
        //Print();
        Boolean direction = ThreadLocalRandom.current().nextBoolean();
        if(direction)
        {
            setPitch(getPitch() + intensity);
        }
        else
        {
            setPitch(getPitch() - intensity);
        }
    }
}
