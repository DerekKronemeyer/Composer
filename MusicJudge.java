

public class MusicJudge
{
    private int score;
    private int firstLastTonicValue;
    private int intervalPreferencesValue;
    private int contourEnforcementValue;

    public MusicJudge()
    {
        score = 0;
        firstLastTonicValue = 1;
        intervalPreferencesValue = 1;
    }

    public int evaluatePiece(Piece piece)
    {
        score = 0;
        score = score + (RuleBook.firstLastTonic(piece)*firstLastTonicValue);
        score = score + (RuleBook.intervalPreferences(piece)*intervalPreferencesValue);
        score = score + (RuleBook.contourEnforcement(piece)*contourEnforcementValue);

        return score;
    }


}
