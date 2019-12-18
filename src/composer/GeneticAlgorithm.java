import java.util.ArrayList;

public class GeneticAlgorithm
{
    Composer composer;
    Generation generation;
    ArrayList<Piece> bestPieces;

    public GeneticAlgorithm()
    {
        composer = new Composer();
        generation = new Generation(composer);
        //bestPieces = new ArrayList<Piece>();

        generation.evaluate();
        generation.sort();

        showBestPiece();
        for(int i=0; i<1000; i++)
        {
            generation.advance();
            showBestPiece();
        }
        playBestPiece();

    }

    public void showBestPiece()
    {
        Piece best = generation.getBestPiece();
        Print.p("------------------Generation------------------------");
        Print.p("Average Score: " + generation.getAverageScore());
        Print.p("Best Score: " + best.getScore());

    }

    public void playBestPiece()
    {
        Piece best = generation.getBestPiece();
        Print.p("----------------------------------------------------");
        best.Print();

        MusicPlayer mp = new MusicPlayer(30);
        mp.Play(best);
    }
}
