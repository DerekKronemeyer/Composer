import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class TestRuleBook
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

    @Test public void TestFirstLastTonic()
    {
        Bar bar = new Bar(3);
            bar.addNote(new Note(72, 1));
            bar.addNote(new Note(72, 1));
            bar.addNote(new Note(72, 1));
        p.addBar(bar);
        assertEquals("Testing Rules", RuleBook.firstLastTonic(p), 100);
        p.getNote(p.size()-1).setPitch(73);
        assertEquals("Testing Rules", RuleBook.firstLastTonic(p), 0);
        p.getNote(p.size()-1).setPitch(72);
        assertEquals("Testing Rules", RuleBook.firstLastTonic(p), 100);
    }

    @Test public void TestintervalPreferences()
    {
        Bar bar = new Bar(2);
            bar.addNote(new Note(72, 1));
            bar.addNote(new Note(72, 1));
        p.addBar(bar);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 4);
        p.getNote(p.size()-1).setPitch(73);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 4);
        p.getNote(p.size()-1).setPitch(74);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 9);
        p.getNote(p.size()-1).setPitch(75);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 6);
        p.getNote(p.size()-1).setPitch(76);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 6);
        p.getNote(p.size()-1).setPitch(77);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 3);
        p.getNote(p.size()-1).setPitch(78);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 0);
        p.getNote(p.size()-1).setPitch(79);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 3);
        p.getNote(p.size()-1).setPitch(80);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 2);
        p.getNote(p.size()-1).setPitch(81);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 2);
        p.getNote(p.size()-1).setPitch(82);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 1);
        p.getNote(p.size()-1).setPitch(83);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 1);
        p.getNote(p.size()-1).setPitch(84);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 5);
        p.getNote(p.size()-1).setPitch(85);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 0);

        p.getNote(p.size()-1).setPitch(71);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 4);
        p.getNote(p.size()-1).setPitch(70);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 9);
        p.getNote(p.size()-1).setPitch(69);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 6);
        p.getNote(p.size()-1).setPitch(68);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 6);
        p.getNote(p.size()-1).setPitch(67);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 3);
        p.getNote(p.size()-1).setPitch(66);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 0);
        p.getNote(p.size()-1).setPitch(65);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 3);
        p.getNote(p.size()-1).setPitch(64);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 2);
        p.getNote(p.size()-1).setPitch(63);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 2);
        p.getNote(p.size()-1).setPitch(62);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 1);
        p.getNote(p.size()-1).setPitch(61);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 1);
        p.getNote(p.size()-1).setPitch(60);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 5);
        p.getNote(p.size()-1).setPitch(59);
        assertEquals("Testing Rules", RuleBook.intervalPreferences(p), 0);
    }

    @Test public void TestContourEnforcement()
    {
        Bar bar = new Bar(3);
            bar.addNote(new Note(72, 1));
            bar.addNote(new Note(72, 1));
            bar.addNote(new Note(72, 1));
        p.addBar(bar);
        assertEquals("Testing Rules", RuleBook.contourEnforcement(p), 5);
        p.getNote(1).setPitch(73);
        assertEquals("Testing Rules", RuleBook.contourEnforcement(p), 0);
        p.getNote(2).setPitch(74);
        assertEquals("Testing Rules", RuleBook.contourEnforcement(p), 5);
        p.getNote(0).setPitch(71);
        assertEquals("Testing Rules", RuleBook.contourEnforcement(p), 5);
        p.getNote(2).setPitch(73);
        assertEquals("Testing Rules", RuleBook.contourEnforcement(p), 0);
    }

    @Test public void TestFinality()
    {
        p.addBar(new Bar(2));
        p.lastBar().addNote(new Note(72, 1));
        p.lastBar().addNote(new Note(72, 1));
        assertEquals("Testing Rules", RuleBook.finality(p), 0);
        p.addBar(new Bar(2));
        p.lastBar().addNote(new Note(72, 1));
        assertEquals("Testing Rules", RuleBook.finality(p), 0);
        p.addBar(new Bar(2));
        p.lastBar().addNote(new Note(72, 2));
        assertEquals("Testing Rules", RuleBook.finality(p), 100);
    }

    @Test public void TestKeySignatureEnforcement()
    {
        p.addBar(new Bar(13));
        p.lastBar().addNote(new Note(72, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 7);
        p.lastBar().addNote(new Note(73, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 7);
        p.lastBar().addNote(new Note(74, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 14);
        p.lastBar().addNote(new Note(75, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 14);
        p.lastBar().addNote(new Note(76, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 21);
        p.lastBar().addNote(new Note(77, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 28);
        p.lastBar().addNote(new Note(78, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 28);
        p.lastBar().addNote(new Note(79, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 35);
        p.lastBar().addNote(new Note(80, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 35);
        p.lastBar().addNote(new Note(81, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 42);
        p.lastBar().addNote(new Note(82, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 42);
        p.lastBar().addNote(new Note(83, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 49);
        p.lastBar().addNote(new Note(84, 1));
        assertEquals("Testing Rules", RuleBook.keySignatureEnforcement(p), 56);
    }

    @Test public void TestSimilarBarStructre()
    {
        p.addBar(new Bar(3));
        p.getBar(0).addNote(new Note(72, 1));
        p.getBar(0).addNote(new Note(72, 1));
        p.getBar(0).addNote(new Note(72, 1));
        assertEquals("Testing Rules", RuleBook.similarBarStructure(p), 0);
        p.addBar(new Bar(3));
        p.getBar(1).addNote(new Note(72, 1));
        p.getBar(1).addNote(new Note(72, 1));
        p.getBar(1).addNote(new Note(72, 1));
        assertEquals("Testing Rules", RuleBook.similarBarStructure(p), 5);
        p.addBar(new Bar(3));
        p.getBar(2).addNote(new Note(72, 1));
        p.getBar(2).addNote(new Note(72, 2));
        assertEquals("Testing Rules", RuleBook.similarBarStructure(p), 5);
        p.addBar(new Bar(3));
        p.getBar(3).addNote(new Note(72, 2));
        p.getBar(3).addNote(new Note(72, 1));
        assertEquals("Testing Rules", RuleBook.similarBarStructure(p), 5);
        p.addBar(new Bar(3));
        p.getBar(4).addNote(new Note(72, 1));
        p.getBar(4).addNote(new Note(72, 2));
        assertEquals("Testing Rules", RuleBook.similarBarStructure(p), 10);
    }

    @Test public void TestnoteDuration()
    {
        p.addBar(new Bar(12));
        for(int i=0; i<12; i++)
        {
            p.getBar(0).addNote(new Note(72, 1));
        }
        //Print.a(""+RuleBook.noteDuration(p));
        p.addBar(new Bar(12));
        for(int i=0; i<6; i++)
        {
            p.getBar(1).addNote(new Note(72, 2));
        }
        //Print.a(""+RuleBook.noteDuration(p));
        p.addBar(new Bar(12));
        for(int i=0; i<4; i++)
        {
            p.getBar(2).addNote(new Note(72, 3));
        }
        //Print.a(""+RuleBook.noteDuration(p));
        p.addBar(new Bar(12));
        for(int i=0; i<3; i++)
        {
            p.getBar(3).addNote(new Note(72, 4));
        }
        //Print.a(""+RuleBook.noteDuration(p));
        assertEquals("Testing Rules", RuleBook.noteDuration(p), 25);
    }
}
