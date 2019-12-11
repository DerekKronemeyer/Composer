import java.util.ArrayList;
//import java.utilconcurrent.*;
import java.util.*;

public class Generation
{
    private ArrayList<Piece> generation;
    private int popluationSize;
    private int survivalPopulationSize;
    private Composer composer;
    private MusicJudge judge;

    public Generation(Composer composer)
    {
        this.generation = new ArrayList<Piece>();
        this.popluationSize = 1000;
        this.survivalPopulationSize = 100;
        this.composer = composer;
        this.judge = new MusicJudge();
        for(int i=0; i<popluationSize; i++)
        {
            Piece piece = composer.createPiece();
            //Print.p("Size of piece: "+piece.size());
            generation.add(piece);
            //Print.p("Size of generation: " + generation.size());
        }

    }

    public void advance()
    {
        evaluate();
        sort();
        return;
    }

    public void evaluate()
    {
        for(int i=0; i<popluationSize; i++)
        {
            int score = judge.evaluatePiece(generation.get(i));
            generation.get(i).setScore(score);

            //generation.get(i).setScore(ThreadLocalRandom.current().nextInt(1, 1000));
        }
        return;
    }

    public void sort()
    {
        generation.sort(Comparator.comparingInt(Piece::getScore).reversed());
    }

    public Piece getBestPiece()
    {
        return generation.get(0);
    }


}
