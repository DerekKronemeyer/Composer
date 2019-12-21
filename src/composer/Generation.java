import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.*;

public class Generation
{
    private ArrayList<Piece> generation;
    private int popluationSize;
    private int index;
    private int survivalPopulationSize;
    private Composer composer;
    private MusicJudge judge;

    public Generation(Composer composer)
    {
        this.generation = new ArrayList<Piece>();
        this.popluationSize = 1000;
        this.index = 0;
        this.survivalPopulationSize = 100;
        this.composer = composer;
        this.judge = new MusicJudge();
        for(int i=0; i<popluationSize; i++)
        {
            Piece piece = composer.createPiece();
            //Print.p("Size of piece: "+piece.size());
            piece.setName("gen0_num" + i);
            generation.add(piece);
            //Print.p("Size of generation: " + generation.size());
        }

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

    public void cull()
    {
        //Print.a("culling");
        ArrayList<Piece> survivors = new ArrayList<Piece>();
        for(int i=0; i<survivalPopulationSize; i++)
        {
            //Print.p(""+getPiece(i).getScore());
            survivors.add(getPiece(i));
        }
        //Print.p("_________");
        this.generation = survivors;
    }

    public void repopulate()
    {
        index = index + 1;
        ArrayList<Piece> mutations = new ArrayList<Piece>();
        //Print.p("Pop Size: " + popluationSize + "| Survival Size: " + survivalPopulationSize);
        for(int i=0; i<popluationSize; i++)
        {
             if(i<10)
             {
                 mutations.add(getPiece(i));
             }
             else
             {
                 Piece input = getRandomPiece();
                 Piece mutation = input.mutate();
                 mutation.setName("gen"+index+"_num"+i);
                 mutations.add(mutation);
             }
        }
        this.generation = mutations;
    }

    public Piece getBestPiece()
    {
        return generation.get(0);
    }

    public Piece getPiece(int index)
    {
        return generation.get(index);
    }

    public void deletePiece(int index)
    {
        generation.remove(index);
    }

    public Piece getRandomPiece()
    {
        int index = ThreadLocalRandom.current().nextInt(0, generation.size()-1);
        return generation.get(index);
    }

    public double getAverageScore()
    {
        //Print.p("this far");
        double totalScore = 0;
        for(int i=0; i<generation.size(); i++)
        {
            totalScore = totalScore + generation.get(i).getScore();
        }
        double averageScore = totalScore/(double)generation.size();
        return averageScore;
    }

    public int number()
    {
        return index;
    }

    public int size()
    {
        return generation.size();
    }

}
