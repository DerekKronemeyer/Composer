import java.util.ArrayList;

public class GeneticAlgorithm
{
    Composer composer;
    Generation generation;

    public GeneticAlgorithm()
    {
        composer = new Composer();
        generation = new Generation(composer);
        //mp = new MusicPlayer(30);

        generation.evaluate();
        generation.sort();
    }

    public Generation getGeneration()
    {
        return generation;
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
