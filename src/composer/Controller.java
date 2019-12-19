



public class Controller{
    GeneticAlgorithm ga;
    MusicPlayer mp;

    public Controller(GeneticAlgorithm ga)
    {
        this.ga = ga;
        this.mp = new MusicPlayer(30);//defaul30 bpm
    }

    //getters
    public GeneticAlgorithm getGeneticAlgorithm(){return ga;}
    public Piece getPiece(int index){return ga.getGeneration().getPiece(index);}


    //doers
    public void playPiece(int index){mp.Play(getPiece(index));}
    public void playBestPiece(){mp.Play(ga.getGeneration().getBestPiece());}

    //setters
    public void updateMusicPlayer(int tempo){mp = new MusicPlayer(tempo);}
}
