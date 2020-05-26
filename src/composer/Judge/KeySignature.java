
public class KeySignature
{
    private Note tonic;
    private int[] currentKeySignature;
    private String currentName;

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
    //no key Signature
    private int[] none;

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
        this.locrian =    new int[]{1,2,2,1,2,2,2};//may not be real
        this.pentatonic = new int[]{3,2,2,3,2};
        //blues scales
        this.hexatonic =  new int[]{3,2,1,1,3,2};
        this.heptatonic = new int[]{2,1,2,1,3,1,2};
        this.nonatonic =  new int[]{2,1,1,1,2,2,1,1,1};
        //no key sgnature
        this.none =       new int[]{1,1,1,1,1,1,1,1,1,1,1,1};

        setKeySignature(0);
    }

    public Boolean isInKeySignature(Note note)
    {
        int difference = 0;
        for(int i=0; i<currentKeySignature.length; i++)
        {
            difference = difference + currentKeySignature[i];
            if((note.getPitch() % 12) == (tonic.getPitch() % 12) + (difference%12))
                return true;
        }
        return false;
    }

    public void setKeySignature(int index)
    {
        if(index == 0)
        {
            currentKeySignature = major;
            currentName = "Major";
        }
        else if(index == 1)
        {
            currentKeySignature = minor;
            currentName = "Minor";
        }
        else if(index == 2)
        {
            currentKeySignature = dorian;
            currentName = "Dorian";
        }
        else if(index == 3)
        {
            currentKeySignature = phrygian;
            currentName = "Phrygian";
        }
        else if(index == 4)
        {
            currentKeySignature = lydian;
            currentName = "Lydian";
        }
        else if(index == 5)
        {
            currentKeySignature = mixolydian;
            currentName = "Mixolydian";
        }
        else if(index == 6)
        {
            currentKeySignature = ionian;
            currentName = "Ionian";
        }
        else if(index == 7)
        {
            currentKeySignature = aeolian;
            currentName = "Aeolian";
        }
        else if(index == 8)
        {
            currentKeySignature = locrian;
            currentName = "Locrian";
        }
        else if(index == 9)
        {
            currentKeySignature = pentatonic;
            currentName = "Pentatonic";
        }
        else if(index == 10)
        {
            currentKeySignature = hexatonic;
            currentName = "Hexatonic";
        }
        else if(index == 11)
        {
            currentKeySignature = heptatonic;
            currentName = "Heptatonic";
        }
        else if(index == 12)
        {
            currentKeySignature = nonatonic;
            currentName = "Nonatonic";
        }
        else if(index == 13)
        {
            currentKeySignature = none;
            currentName = "None";
        }
        else//if all else fails set key signature to major
        {
            currentKeySignature = major;
            currentName = "Major";
        }
        //Print.a("key sig set to: " + currentName);
    }

    public String getName()
    {
        return currentName;
    }
}
