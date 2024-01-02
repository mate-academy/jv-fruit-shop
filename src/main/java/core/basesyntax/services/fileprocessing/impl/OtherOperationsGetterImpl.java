package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.services.fileprocessing.OtherOperationsGetter;
import java.util.List;
import java.util.stream.Collectors;

public class OtherOperationsGetterImpl implements OtherOperationsGetter {
    private static final String STRING_SPLITTER = ",";
    private static final String SKIP_LINE_IF_CONTAINS_B = "b";
    private static final String SKIP_LINE_IF_CONTAINS_TYPE = "type";

    @Override
    public List<String[]> writeDownOtherOperations(List<String> rawData) {
        return rawData.stream().map(string -> string.split(STRING_SPLITTER))
                .filter(strings -> !strings[0].equals(SKIP_LINE_IF_CONTAINS_B)
                        && !strings[0].equals(SKIP_LINE_IF_CONTAINS_TYPE))
                .collect(Collectors.toList());
    }
}
