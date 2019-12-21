public class Controller{
    GeneticAlgorithm ga;
    MusicPlayer mp;
    GUI gui;

    public Controller(GeneticAlgorithm ga)
    {
        this.ga = ga;
        this.mp = new MusicPlayer(120, this);//default30 bpm
    }

    public void setGUI(GUI gui){this.gui = gui;}

    //getters
    public GeneticAlgorithm getGeneticAlgorithm(){return ga;}
    public Piece getPiece(int index){return ga.getGeneration().getPiece(index);}
    public PiecePanel getPiecePanel(int index){return gui.getPiecesPanel().getPiecePanel(index);}
    public Generation getGeneration(){return ga.getGeneration();}
    public KeySignature getKeySignature(){return ga.getMusicJudge().getRuleBook().getKeySignature();}

    //doers
    //public void refreshGUI(){mp.stop();gui.refresh();}
    public void refreshGUI(){gui.refresh();}
    public void refreshControlPanel(){gui.getControlPanel().refresh();}
    public void playPiece(int index){mp.Play(getPiece(index));}
    public void savePiece(int index){mp.save(getPiece(index));}
    public void stopPlaying(){mp.stop();}
    public void playBestPiece(){mp.Play(ga.getGeneration().getBestPiece());}
    public void restartGeneticAlgorithm(){this.ga = new GeneticAlgorithm();};

    //setters
    public void updateMusicPlayer(int tempo){mp = new MusicPlayer(tempo, this);}
    public void setKeySignature(int index){getKeySignature().setKeySignature(index);}
}
