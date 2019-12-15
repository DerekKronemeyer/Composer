
public class KeySignature
{
    private Note tonic;

    private int[] major;
    private int[] minor;

    private int[] dorian;
    private int[] phrygian;
    private int[] lydian;
    private int[] mixolydian;
    private int[] ionian;//just a major scale
    private int[] aeolian;
    private int[] locrian;
    private int[] pentatonic;
    //blues scales
    private int[] hexatonic;
    private int[] heptatonic;
    private int[] nonatonic;

    public KeySignature(Note tonic)
    {
        this.tonic = tonic;
        this.major =      new int[]{2,2,1,2,2,2,1};
        this.minor =      new int[]{2,1,2,2,1,3,1};

        this.dorian =     new int[]{2,1,2,2,2,1,2};
        this.phrygian =   new int[]{1,3,1,2,1,2,2};
        this.lydian =     new int[]{2,2,2,1,2,2,1};
        this.mixolydian = new int[]{2,2,1,2,2,1,2};
        this.ionian =     new int[]{2,2,1,2,2,2,1};//just a major scale
        this.aeolian =    new int[]{2,1,2,2,1,2,2};
        this.locrian =    new int[]{1,2,2,1,2,2,2};
        this.pentatonic = new int[]{3,2,2,3,2};
        //blues scales
        this.hexatonic =  new int[]{3,2,1,1,3,2};
        this.heptatonic = new int[]{2,1,2,1,3,1,2};
        this.nonatonic =  new int[]{2,1,1,1,2,2,1,1,1};
    }

    public Boolean isMajor(Note note)
    {
        for(int i=0; i<major.length; i++)
        {
            if((note.getPitch() % 12) == (tonic.getPitch() % 12) + major[i])
                return true;
        }
        return false;
    }
}
