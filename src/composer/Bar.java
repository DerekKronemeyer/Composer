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

    public Bar(Bar bar)
    {
        this.notes = new ArrayList<Note>();
        this.maxDuration = bar.getMaxDuration();
        for(int i=0; i<bar.size(); i++)
        {
            addNote(new Note(bar.getNote(i)));
        }
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

    public String getStructure()
    {
        String structure = "";
        for(int i=0; i<size(); i++)
        {
            structure = structure + getNote(i).getDuration();
        }
        return structure;
    }

    public Note getNote(int i)
    {
        return notes.get(i);
    }

    public int getMaxDuration()
    {
        return this.maxDuration;
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
