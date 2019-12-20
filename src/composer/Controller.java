public class Controller{
    GeneticAlgorithm ga;
    MusicPlayer mp;
    GUI gui;

    public Controller(GeneticAlgorithm ga)
    {
        this.ga = ga;
        this.mp = new MusicPlayer(30);//defaul30 bpm
    }

    public void setGUI(GUI gui){this.gui = gui;}

    //getters
    public GeneticAlgorithm getGeneticAlgorithm(){return ga;}
    public Piece getPiece(int index){return ga.getGeneration().getPiece(index);}
    public PiecePanel getPiecePanel(int index){return gui.getPiecesPanel().getPiecePanel(index);};


    //doers
    public void refreshGUI(){gui.refresh();}
    public void playPiece(int index){mp.Play(getPiece(index));}
    public void stopPlaying(){mp.stop();}
    public void playBestPiece(){mp.Play(ga.getGeneration().getBestPiece());}

    //setters
    public void updateMusicPlayer(int tempo){mp = new MusicPlayer(tempo);}
}
