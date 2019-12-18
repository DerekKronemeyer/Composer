import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class TestBar
{
    private Bar b;

    @Before
    public void init()
    {
        b = new Bar(4);//4 beats
    }

    @After
    public void finalize()
    {
        b = null;
    }

    @Test public void TestAddNote()
    {
        b.addNote(new Note(72, 1));
        assertEquals("Testing Bar", b.getNote(0).getDuration(), 1);
        b.addNote(new Note(72, 2));
        assertEquals("Testing Bar", b.getNote(0).getDuration(), 1);
        assertEquals("Testing Bar", b.getNote(1).getDuration(), 2);
        b = new Bar(4);
        b.addNote(new Note(72, 4));
        assertEquals("Testing Bar", b.getNote(0).getDuration(), 4);
    }

    @Test public void TestConstructor()
    {
        b.addNote(new Note(72, 1));
        Bar clone = new Bar(b);
        assertEquals("Testing Bar", b.getNote(0).getDuration(), clone.getNote(0).getDuration());
        assertEquals("Testing Bar", b.getNote(0).getPitch(), clone.getNote(0).getPitch());
        assertNotSame("Testing Bar", clone, b);
    }

    @Test public void TestIsFull()
    {
        assertFalse("Testing Bar", b.isFull());
        b.addNote(new Note(72, 1));
        assertFalse("Testing Bar", b.isFull());
        b.addNote(new Note(72, 3));
        assertTrue("Testing Bar", b.isFull());
        b = new Bar(1);
        b.addNote(new Note(72, 2));
        assertFalse("Testing Bar", b.isFull());
        b.addNote(new Note(72, 1));
        assertTrue("Testing Bar", b.isFull());
    }

    @Test public void TestGetStructure()
    {
        assertEquals("Testing Bar", b.getStructure(), "");
        b.addNote(new Note(72, 1));
        assertEquals("Testing Bar", b.getStructure(), "1");
        b.addNote(new Note(72, 1));
        assertEquals("Testing Bar", b.getStructure(), "11");
        b.addNote(new Note(72, 1));
        assertEquals("Testing Bar", b.getStructure(), "111");
        b.addNote(new Note(72, 1));
        assertEquals("Testing Bar", b.getStructure(), "1111");
        b.addNote(new Note(72, 1));
        assertEquals("Testing Bar", b.getStructure(), "1111");
        b = new Bar(4);
        b.addNote(new Note(72, 4));
        assertEquals("Testing Bar", b.getStructure(), "4");
        b.addNote(new Note(72, 1));
        assertEquals("Testing Bar", b.getStructure(), "4");
        b = new Bar(6);
        b.addNote(new Note(72, 2));
        assertEquals("Testing Bar", b.getStructure(), "2");
        b.addNote(new Note(72, 4));
        assertEquals("Testing Bar", b.getStructure(), "24");
        b.addNote(new Note(72, 1));
        assertEquals("Testing Bar", b.getStructure(), "24");
    }

    @Test public void TestGetNote()
    {
        Note one = new Note(72, 1);
        Note two = new Note(73, 1);
        Note three = new Note(74, 1);
        Note four = new Note(75, 1);
        b.addNote(one);
        b.addNote(two);
        b.addNote(three);
        b.addNote(four);
        assertSame("Testing Bar", b.getNote(0), one);
        assertSame("Testing Bar", b.getNote(1), two);
        assertSame("Testing Bar", b.getNote(2), three);
        assertSame("Testing Bar", b.getNote(3), four);
    }

    @Test public void TestGetMaxDuration()
    {
        assertEquals("Testing Bar", b.getMaxDuration(), 4);
        b = new Bar(1);
        assertEquals("Testing Bar", b.getMaxDuration(), 1);
        b = new Bar(10);
        assertEquals("Testing Bar", b.getMaxDuration(), 10);
    }

    @Test public void TestSize()
    {
        assertEquals("Testing Bar", b.size(), 0);
        b.addNote(new Note(72, 1));
        assertEquals("Testing Bar", b.size(), 1);
        b.addNote(new Note(73, 1));
        assertEquals("Testing Bar", b.size(), 2);
        b.addNote(new Note(74, 1));
        assertEquals("Testing Bar", b.size(), 3);
        b.addNote(new Note(75, 1));
        assertEquals("Testing Bar", b.size(), 4);
        b.addNote(new Note(75, 1));
        assertEquals("Testing Bar", b.size(), 4);
    }

    @Test public void TestLastNote()
    {
        assertNull("Testing Bar", b.lastNote());
        Note one = new Note(72, 1);
        b.addNote(one);
        assertSame("Testing Bar", b.lastNote(), one);
        Note two = new Note(73, 1);
        b.addNote(two);
        assertSame("Testing Bar", b.lastNote(), two);
        Note three = new Note(74, 1);
        b.addNote(three);
        assertSame("Testing Bar", b.lastNote(), three);
        Note four = new Note(75, 1);
        b.addNote(four);
        assertSame("Testing Bar", b.lastNote(), four);
        Note five = new Note(75, 1);
        b.addNote(five);
        assertSame("Testing Bar", b.lastNote(), four);
    }
}
