package file;

import file.exception.InvalidIndexException;
import file.search.AbstractSearchPattern;
import java.util.List;

public class Reader
{
    private File file;

    private int counter = -1;

    public Reader(File file)
    {
        this.file = file;
    }

    public Object[] readNextLine()
    {
        this.counter++;

        if (this.counter > this.file.getLinesCount() - 1) {
            this.counter = this.file.getLinesCount() - 1;
            throw new InvalidIndexException("Index is greater than list size");
        }

        List<String> lines =  this.file.getAt(counter);

        return lines.toArray();
    }

    public Object[] readPreviousLine()
    {
        this.counter--;

        if (this.counter < 0) {
            this.counter =  0;
            throw new InvalidIndexException("Index is less than zero");
        }

        List<String> lines =  this.file.getAt(counter);

        return lines.toArray();
    }
    
    public Object[] readNextSearchLine()
    {
        this.counter++;

        if (this.counter > this.file.getSearchResultsCount() - 1) {
            this.counter = this.file.getSearchResultsCount() - 1;
            throw new InvalidIndexException("Index is greater than list size");
        }

        List<String> lines =  this.file.getSearchedAt(counter);

        return lines.toArray();
    }

    public Object[] readPreviousSearchLine()
    {
        this.counter--;

        if (this.counter < 0) {
            this.counter =  0;
            throw new InvalidIndexException("Index is less than zero");
        }

        List<String> lines =  this.file.getSearchedAt(counter);

        return lines.toArray();
    }

    public void find(AbstractSearchPattern pattern, String search, int field)
    {
        this.file.findInField(pattern, search, field);
        this.resetCounter();
    }
    
    public int getCurrentItemIndex() {
        return this.counter;
    }
    
    public void resetCounter()
    {
        this.counter = -1;
    }
}