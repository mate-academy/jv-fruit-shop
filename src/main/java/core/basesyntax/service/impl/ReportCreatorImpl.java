package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final int HEADER_ROW_INDEX = 0;
    private static final String SEPARATOR = ",";
    private static final String HEADER_ROW = "fruit,quantity";
    @Override
    public String createReport() {
        List<String> reportLines = Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.toList());
        reportLines.add(HEADER_ROW_INDEX, HEADER_ROW);
        return String.join(System.lineSeparator(), reportLines);
    }
}
