import java.util.ArrayList;

public class Bar
{
    private ArrayList<Note> notes;
    private int maxDuration;
    private int duration;

    public Bar(int maxDuration)
    {
        this.notes = new ArrayList<Note>();
        this.maxDuration = maxDuration;
    }

    public void addNote(Note note)
    {
        //Print.p(duration + "/" + maxDuration);
        if((duration+note.getDuration()) <= maxDuration)
        {
            notes.add(note);
            duration = duration + note.getDuration();
        }
        return;
    }

    public Boolean isFull()
    {
        if(duration == maxDuration)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Note getNote(int i)
    {
        return notes.get(i);
    }

    public int size()
    {
        return notes.size();
    }

    public Note lastNote()
    {
        return notes.get(notes.size()-1);
    }

    public void Print()
    {
        for(int i=0; i<notes.size(); i++)
        {
            notes.get(i).Print();
        }
    }

}
