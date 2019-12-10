import java.util.concurrent.*;
import java.util.ArrayList;

public class Composer
{
    private Piece piece;
    private int minPitch;
    private int maxPitch;
    private int minDuration;
    private int maxDuration;
    private int barDuration;

    public Composer()
    {
        piece = new Piece();
        this.minPitch = 58;
        this.maxPitch = 77;
        this.minDuration = 1;
        this.maxDuration = 4;
        this.barDuration = 4;
    }

    public Piece createPiece()
    {
        for(int i=0; i<4; i++)
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
