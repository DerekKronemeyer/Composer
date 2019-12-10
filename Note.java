import java.util.ArrayList;

public class Note
{
    private int pitch;
    private int duration;

    public Note(int pitch, int duration)
    {
        this.pitch = pitch;
        this.duration = duration;
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
        Print.p("Pitch: " + pitch + ", Duration: " + duration);
    }
}
