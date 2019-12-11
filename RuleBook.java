import java.lang.*;

public class RuleBook
{
    public static int firstLastTonic(Piece piece)
    {
        Note first = piece.getBar(0).getNote(0);
        Note last = piece.lastBar().lastNote();
        if(first.getPitch() == last.getPitch())
        {
            return 100;
        }
        else
        {
            return 0;
        }
    }

    public static int intervalPreferences(Piece piece)
    {
        int score = 0;
        for(int i=1; i<piece.numberOfNotes(); i++)
        {
            int pitch1 = piece.getNote(i).getPitch();
            int pitch2 = piece.getNote(i-1).getPitch();

            if(Math.abs(pitch1-pitch2) == 0){score = score + 4;}
            if(Math.abs(pitch1-pitch2) == 1){score = score + 4;}
            if(Math.abs(pitch1-pitch2) == 2){score = score + 9;}
            if(Math.abs(pitch1-pitch2) == 3){score = score + 6;}
            if(Math.abs(pitch1-pitch2) == 4){score = score + 6;}
            if(Math.abs(pitch1-pitch2) == 5){score = score + 3;}
            if(Math.abs(pitch1-pitch2) == 6){score = score + 0;}
            if(Math.abs(pitch1-pitch2) == 7){score = score + 3;}
            if(Math.abs(pitch1-pitch2) == 8){score = score + 2;}
            if(Math.abs(pitch1-pitch2) == 9){score = score + 2;}
            if(Math.abs(pitch1-pitch2) == 10){score = score + 1;}
            if(Math.abs(pitch1-pitch2) == 11){score = score + 1;}
            if(Math.abs(pitch1-pitch2) == 12){score = score + 5;}
        }
        return score;
    }

    public static int contourEnforcement(Piece piece)
    {
        int score = 0;
        for(int i=2; i<piece.numberOfNotes(); i++)
        {
            int pitch1 = piece.getNote(i).getPitch();
            int pitch2 = piece.getNote(i-1).getPitch();
            int pitch3 = piece.getNote(i-2).getPitch();

            if(Integer.signum(pitch1-pitch2) == Integer.signum(pitch2-pitch3)){score = score + 5;}
        }
        return score;
    }

    public static int finality(Piece piece)
    {
        if(piece.lastBar().size() == 1)
        {
            return 100;
        }
        else
        {
            return 0;
        }
    }
}
