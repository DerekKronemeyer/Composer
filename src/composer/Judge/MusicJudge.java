

public class MusicJudge
{
    private int score;
    private RuleBook rb;

    private int firstLastTonicValue;
    private int intervalPreferencesValue;
    private int contourEnforcementValue;
    private int finalityValue;
    private int keySignatureEnforcementValue;
    private int noBigJumpsValue;
    private int similarBarStructureValue;
    private int noteDurationValue;

    public MusicJudge()
    {
        score = 0;
        rb = new RuleBook();

        firstLastTonicValue = 1;
        intervalPreferencesValue = 1;
        finalityValue = 1;
        keySignatureEnforcementValue = 1;
        noBigJumpsValue = 1;
        similarBarStructureValue = 1;
        noteDurationValue = 1;
    }

    public int evaluatePiece(Piece piece)
    {
        score = 0;
        score = score + (rb.firstLastTonic(piece)*firstLastTonicValue);
        score = score + (rb.intervalPreferences(piece)*intervalPreferencesValue);
        score = score + (rb.contourEnforcement(piece)*contourEnforcementValue);
        score = score + (rb.finality(piece)*finalityValue);
        score = score + (rb.keySignatureEnforcement(piece)*keySignatureEnforcementValue);
        score = score + (rb.noBigJumps(piece)*noBigJumpsValue);
        score = score + (rb.similarBarStructure(piece)*similarBarStructureValue);
        score = score + (rb.noteDuration(piece)*noteDurationValue);
        return score;
    }

    public RuleBook getRuleBook(){return rb;}


}
