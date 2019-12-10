import java.util.ArrayList;

public class Piece
{
    private ArrayList<Bar> bars;

    public Piece()
    {
        this.bars = new ArrayList<Bar>();
    }

    public void addBar(Bar bar)
    {
        bars.add(bar);
    }

    public Bar getBar(int i)
    {
        return bars.get(i);
    }

    public int size()
    {
        return bars.size();
    }
}
