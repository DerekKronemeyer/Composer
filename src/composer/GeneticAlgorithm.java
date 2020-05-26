import java.util.ArrayList;


/**
 * A genetic algorithm that is used to manage generations of music produced
 *
 * @author Derek Kronemeyer
 * @version 2.0
 */
public class GeneticAlgorithm
{
    Composer composer;
    MusicJudge judge;
    Generation generation;

    public GeneticAlgorithm()
    {
        composer = new Composer();
        judge = new MusicJudge();
        generation = new Generation(composer, judge);

        generation.evaluate();
        generation.sort();
    }

    public Generation getGeneration()
    {
        return generation;
    }

    public MusicJudge getMusicJudge()
    {
        return judge;
    }

    public void advance()
    {
        generation.cull();
        generation.repopulate();
        generation.evaluate();
        generation.sort();
        return;
    }

    public void showBestPiece()
    {
        Piece best = generation.getBestPiece();
        Print.p("------------------Generation------------------------");
        Print.p("Average Score: " + generation.getAverageScore());
        Print.p("Best Score: " + best.getScore());

    }

    public void playBestPiece(MusicPlayer mp)
    {
        Piece best = generation.getBestPiece();
        mp.Play(best);
    }

    public int size()
    {
        return generation.size();
    }
}
