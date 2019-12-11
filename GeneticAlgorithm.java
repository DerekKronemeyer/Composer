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
        bestPieces = new ArrayList<Piece>();

        generation.evaluate();
        generation.sort();
        playBestPiece();
    }

    public void playBestPiece()
    {
        Piece best = generation.getBestPiece();
        Print.p("------------------BEST PIECE------------------------");
        Print.p("Score: " + best.getScore());
        best.Print();
        Print.p("----------------------------------------------------");

        MusicPlayer mp = new MusicPlayer(30);
        mp.Play(best);
    }






}
