import java.util.ArrayList;

public class GeneticAlgorithm
{
    Composer composer;
    Generation generation;
    MusicPlayer mp;
    //ArrayList<Piece> bestPieces;

    public GeneticAlgorithm()
    {
        composer = new Composer();
        generation = new Generation(composer);
        mp = new MusicPlayer(30);
        //bestPieces = new ArrayList<Piece>();

        generation.evaluate();
        generation.sort();

        // //showBestPiece();
        // for(int i=0; i<1000; i++)
        // {
        //     advance();
        //     //showBestPiece();
        // }
        // playBestPiece(mp);
    }

    public Generation getGeneration()
    {
        return generation;
    }

    public MusicPlayer getMusicPlayer()
    {
        return mp;
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

    public void updateMusicPlayer(int tempo)
    {
        this.mp = new MusicPlayer(tempo);
    }

    public int size()
    {
        return generation.size();
    }
}
