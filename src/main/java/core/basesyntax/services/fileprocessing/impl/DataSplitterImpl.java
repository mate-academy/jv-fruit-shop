package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.services.fileprocessing.DataSplitter;
import java.util.List;

public class DataSplitterImpl implements DataSplitter {
    private static final String STRING_SPLITTER = ",";
    private static final String SKIP_LINE_IF_CONTAINS_TYPE = "type";

    @Override
    public List<String[]> divideData(List<String> rawData) {
        return rawData.stream().map(string -> string.split(STRING_SPLITTER))
                .filter(strings -> !strings[0].equals(SKIP_LINE_IF_CONTAINS_TYPE)).toList();
    }
}
