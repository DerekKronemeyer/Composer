import java.util.concurrent.*;
import java.util.ArrayList;

public class Composer
{
    private int minPitch;
    private int maxPitch;
    private int minDuration;
    private int maxDuration;
    private int barDuration;
    private int numberOfBars;

    public Composer()
    {
        this.numberOfBars = 16;
        this.minPitch = 58;//B flat 3
        this.maxPitch = 77;//F 5
        this.minDuration = 1;
        this.maxDuration = 4;
        this.barDuration = 4;
    }

    public Piece createPiece()
    {
        Piece piece = new Piece();
        //Print.p("number of bars: "+numberOfBars);
        for(int i=0; i<numberOfBars; i++)
        {
            Bar bar = new Bar(barDuration);
            while(!bar.isFull())
            {
                int pitch = ThreadLocalRandom.current().nextInt(minPitch, maxPitch+1);
                int duration = ThreadLocalRandom.current().nextInt(minDuration, maxDuration+1);
                Note note = new Note(pitch, duration);
                bar.addNote(note);
                //note.Print();
            }
            piece.addBar(bar);
            //bar.Print();
            //Print.p("----------");

        }
        return piece;
    }
}
