package file.search;

import java.util.ArrayList;
import java.util.List;

public class FulltextSearchPattern extends AbstractSearchPattern {

    @Override
    public List<List<String>> search(
            List<List<String>> haystack,
            String needle,
            int field
    ) {
        List<List<String>> matches = new ArrayList<>();

        for (List<String> line : haystack) {
            if (line.get(field).equals(needle)) {
                matches.add(line);
            }
        }

        return matches;
    }
}
