package core.basesyntax.dataparser;

import java.util.LinkedList;
import java.util.List;

public class CsvDataParser implements DataParser {
    private static final String SEPARATOR = ",";

    @Override
    public List<String[]> parseData(List<String> srcContents) {
        return new LinkedList<String[]>(srcContents.stream().map(s -> s.split(SEPARATOR))
                .toList());
    }
}
