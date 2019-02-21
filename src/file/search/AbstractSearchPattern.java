package file.search;

import java.util.List;

abstract public class AbstractSearchPattern {

    abstract public List<List<String>> search(
            List<List<String>> haystack,
            String needle,
            int field
    );
}
