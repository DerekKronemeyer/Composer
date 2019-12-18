import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class TestNote
{
    private Note n;

    @Before
    public void init()
    {
        n = new Note(60, 1);//midddle C, quarter note
    }

    @After
    public void finalize()
    {
        n = null;
    }

    @Test public void TestPitch()
    {
        assertEquals("Testing Note", n.getPitch(), 60);
        n.setPitch(72);
        assertEquals("Testing Note", n.getPitch(), 72);
    }

    @Test public void TestDuration()
    {
        assertEquals("Testing Note", n.getDuration(), 1);
        n.setDuration(2);
        assertEquals("Testing Note", n.getDuration(), 2);
        n.setDuration(3);
        assertEquals("Testing Note", n.getDuration(), 3);
        n.setDuration(4);
        assertEquals("Testing Note", n.getDuration(), 4);
    }

    @Test public void TestConstuctor()
    {
        Note clone = new Note(n);
        assertEquals("Testing Note", n.getDuration(), clone.getDuration());
        assertEquals("Testing Note", n.getPitch(), clone.getPitch());
        assertNotSame("Testing Note", n, clone);
    }

    @Test public void TestGetLetter()
    {
        assertEquals("Testing Note", n.getLetter(), "C");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "C#");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "D");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "D#");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "E");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "F");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "F#");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "G");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "G#");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "A");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "A#");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "B");
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getLetter(), "C");
    }

    @Test public void TestGetOctave()
    {
        assertEquals("Testing Note", n.getOctave(), 4);
        n.setPitch(n.getPitch()-1);
        assertEquals("Testing Note", n.getOctave(), 3);
        n.setPitch(n.getPitch()+12);
        assertEquals("Testing Note", n.getOctave(), 4);
        n.setPitch(n.getPitch()+1);
        assertEquals("Testing Note", n.getOctave(), 5);
    }

    @Test public void TestMutateNote()
    {
        int prevPitch = n.getPitch();
        n.mutateNote(1);
        assertEquals("Testing Note", Math.abs(n.getPitch()-prevPitch), 1);
    }
}
