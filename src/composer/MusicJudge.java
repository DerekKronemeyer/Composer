

public class MusicJudge
{
    private int score;
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
        score = score + (RuleBook.firstLastTonic(piece)*firstLastTonicValue);
        score = score + (RuleBook.intervalPreferences(piece)*intervalPreferencesValue);
        score = score + (RuleBook.contourEnforcement(piece)*contourEnforcementValue);
        score = score + (RuleBook.finality(piece)*finalityValue);
        score = score + (RuleBook.keySignatureEnforcement(piece)*keySignatureEnforcementValue);
        score = score + (RuleBook.noBigJumps(piece)*noBigJumpsValue);
        score = score + (RuleBook.similarBarStructure(piece)*similarBarStructureValue);
        score = score + (RuleBook.noteDuration(piece)*noteDurationValue);
        return score;
    }


}
