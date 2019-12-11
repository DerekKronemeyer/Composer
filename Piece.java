import java.util.ArrayList;

public class Piece //implements Comparable
{
    private ArrayList<Bar> bars;
    private int score;

    public Piece()
    {
        this.bars = new ArrayList<Bar>();
    }

    public void addBar(Bar bar)
    {
        bars.add(bar);
    }

    public Bar getBar(int i)
    {
        return bars.get(i);
    }

    public int size()
    {
        return bars.size();
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }

    public Bar lastBar()
    {
        return bars.get(bars.size()-1);
    }

    public int numberOfNotes()
    {
        int total = 0;
        for(int i=0; i<bars.size(); i++)
        {
            total = total + bars.get(i).size();
        }
        return total;
    }

    public Note getNote(int noteIndex)
    {
        int notesParsed = 0;
        for(int i=0; i<size(); i++)
        {
            for(int j=0; j<getBar(i).size(); j++)
            {
                if(notesParsed == noteIndex)
                {
                    return getBar(i).getNote(j);
                }
                else
                {
                    notesParsed = notesParsed + 1;
                }
            }
        }
        return getBar(0).getNote(0);//this will only happen with bad input
    }

    public void Print()
    {
        for(int i=0; i<bars.size(); i++)
        {
            bars.get(i).Print();
            Print.p("----------");
        }
    }
}
