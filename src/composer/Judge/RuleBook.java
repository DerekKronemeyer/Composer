import java.lang.*;
import java.util.*;

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

    public static int noBigJumps(Piece piece)
    {
        int score = 0;
        for(int i=1; i<piece.numberOfNotes(); i++)
        {
            int pitch1 = piece.getNote(i).getPitch();
            int pitch2 = piece.getNote(i-1).getPitch();

            if(Math.abs(pitch1-pitch2) <= 8){score = score + 20;}
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

    public static int keySignatureEnforcement(Piece piece)
    {
        int score = 0;
        Note tonic = piece.getBar(0).getNote(0);
        KeySignature ks = new KeySignature(tonic);
        for(int i=0; i<piece.numberOfNotes(); i++)
        {
            if(ks.isMajor(piece.getNote(i)))
                score = score + 7;
        }
        return score;
    }

    public static int similarBarStructure(Piece piece)
    {
        int score = 0;
        ArrayList<String> structures = new ArrayList<String>();
        for(int i=0; i<piece.size(); i++)
        {
            structures.add(piece.getBar(i).getStructure());
        }
        Collections.sort(structures);
        for(int i=1; i<structures.size(); i++)
        {
            if(structures.get(i).equals(structures.get(i-1)))
            {
                score = score + 5;
            }
        }
        return score;
    }

    public static int noteDuration(Piece piece)
    {
        int score = 0;
        double[] preferences = {0.0, 12.0, 6.0, 4.0, 3.0};//expected ratio of notes of index duration
        double expectedTotal = 0;
        for(int i=0; i<5; i++)
        {
            expectedTotal = expectedTotal + preferences[i];
        }

        // calculate expected number of notes by duration based on preferences
        int[] expected = new int[5];//this is what we are looking for!
        for(int i=0; i<5; i++)
        {
            double temp = ((double)piece.size())/(preferences[i]/expectedTotal);
             expected[i] = (int)temp;//floor
        }

        //calculate actual number of notes by duration
        int[] actual = new int[5];
        for(int i=0; i<piece.numberOfNotes(); i++)
        {
            actual[piece.getNote(i).getDuration()]++;
        }

        for(int i=0; i<5; i++)
        {
            score = score + expected[i] - (Math.abs(expected[i] - actual[i]));
        }
        return score;
    }
}
