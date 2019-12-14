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
}
