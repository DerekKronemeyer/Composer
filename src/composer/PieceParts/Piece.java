import java.util.ArrayList;
import java.util.concurrent.*;

public class Piece
{
    private ArrayList<Bar> bars;
    private int score;
    private String name;

    public Piece()
    {
        this.bars = new ArrayList<Bar>();
        this.score = 0;
        this.name = "Unnamed Piece";
    }

    public Piece(Piece piece)
    {
        this.bars = new ArrayList<Bar>();
        this.score = 0;
        this.name = piece.getName();
        for(int i=0; i<piece.size(); i++)
        {
            bars.add(new Bar(piece.getBar(i)));
        }
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

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Bar lastBar()
    {
        if(bars.size() == 0)
            return null;
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
        if(noteIndex < 0)
            return null;
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

    public void printLetters()
    {
        String out = "";
        for(int i=0; i<numberOfNotes(); i++)
        {
            out = out +getNote(i).getLetter();
            //if((i+1) < numberOfNotes())
            //    out = out + "-";
        }
        Print.p(out);
    }

    public Piece mutate()
    {
        int numberOfMutations = 3;
        int intensity = 1;
        Piece mutatedPiece = new Piece(this);
        for(int i=0; i<numberOfMutations; i++)
        {
            mutatedPiece.getRandomNote().mutateNote(intensity);
        }
        //printLetters();
        //mutatedPiece.printLetters();
        //Print.p("");
        return mutatedPiece;
    }

    public Note getRandomNote()
    {
        int index = ThreadLocalRandom.current().nextInt(0, numberOfNotes()+1);
        return getNote(index);
    }
}
