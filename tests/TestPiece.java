import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class TestPiece
{
    private Piece p;

    @Before
    public void init()
    {
        p = new Piece();
    }

    @After
    public void finalize()
    {
        p = null;
    }

    @Test public void TestGetBar()
    {
        Bar one = new Bar(4);
        Bar two = new Bar(4);
        p.addBar(one);
        assertSame("Testing Piece", p.getBar(0), one);
        p.addBar(two);
        assertSame("Testing Piece", p.getBar(0), one);
        assertSame("Testing Piece", p.getBar(1), two);
    }

    @Test public void TestConstructor()
    {
        Bar one = new Bar(4);
        p.addBar(one);
        Piece clone = new Piece(p);
        assertNotSame("Testing Piece", p.getBar(0), clone.getBar(0));
        assertEquals("Testing Piece", p.size(), clone.size());
    }

    @Test public void TestSize()
    {
        Bar one = new Bar(4);
        Bar two = new Bar(4);
        Bar three = new Bar(4);
        Bar four = new Bar(4);
        assertEquals("Testing Piece", p.size(), 0);
        p.addBar(one);
        assertEquals("Testing Piece", p.size(), 1);
        p.addBar(two);
        assertEquals("Testing Piece", p.size(), 2);
        p.addBar(three);
        assertEquals("Testing Piece", p.size(), 3);
        p.addBar(four);
        assertEquals("Testing Piece", p.size(), 4);
    }

    @Test public void TestScore()
    {
        for(int i=0; i<100; i++)
        {
            p.setScore(i);
            assertEquals("Testing Piece", p.getScore(), i);
        }
    }

    @Test public void TestName()
    {
        for(int i=0; i<100; i++)
        {
            p.setName("name"+i);
            assertEquals("Testing Piece", p.getName(), "name"+i);
        }
    }

    @Test public void TestLastBar()
    {
        Bar one = new Bar(4);
        Bar two = new Bar(4);
        Bar three = new Bar(4);
        Bar four = new Bar(4);
        assertEquals("Testing Piece", p.lastBar(), null);
        p.addBar(one);
        assertEquals("Testing Piece", p.lastBar(), one);
        p.addBar(two);
        assertEquals("Testing Piece", p.lastBar(), two);
        p.addBar(three);
        assertEquals("Testing Piece", p.lastBar(), three);
        p.addBar(four);
        assertEquals("Testing Piece", p.lastBar(), four);
    }

    @Test public void TestNumberOfNotes()
    {
        Bar one = new Bar(2);
        Bar two = new Bar(2);
        p.addBar(one);
        p.addBar(two);
        assertEquals("Testing Piece", p.numberOfNotes(), 0);
        one.addNote(new Note(72, 1));
        assertEquals("Testing Piece", p.numberOfNotes(), 1);
        one.addNote(new Note(72, 1));
        assertEquals("Testing Piece", p.numberOfNotes(), 2);
        one.addNote(new Note(72, 1));
        assertEquals("Testing Piece", p.numberOfNotes(), 2);
        two.addNote(new Note(72, 1));
        assertEquals("Testing Piece", p.numberOfNotes(), 3);
        two.addNote(new Note(72, 1));
        assertEquals("Testing Piece", p.numberOfNotes(), 4);
        two.addNote(new Note(72, 1));
        assertEquals("Testing Piece", p.numberOfNotes(), 4);
    }

    @Test public void TestGetNotes()
    {
        Bar one = new Bar(2);
            Note a = new Note(72, 1);
            Note b = new Note(73, 1);
            one.addNote(a);
            one.addNote(b);
        Bar two = new Bar(2);
            Note c = new Note(74, 1);
            Note d = new Note(75, 1);
            two.addNote(c);
            two.addNote(d);
        p.addBar(one);
        p.addBar(two);
        assertSame("Testing Piece", p.getNote(0), a);
        assertSame("Testing Piece", p.getNote(1), b);
        assertSame("Testing Piece", p.getNote(2), c);
        assertSame("Testing Piece", p.getNote(3), d);
    }

}
