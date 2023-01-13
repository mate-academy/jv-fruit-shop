package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportMaker;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportMakerImpl implements ReportMaker {
    private static final Map<String, Integer> STORAGE = Storage.fruitsStorage;
    private static final String END_LINE = System.lineSeparator();
    private static final String COLUMNS = "fruit,quantity" + END_LINE;
    private static final String LINE_SPLITTER = ",";

    @Override
    public String makeReport() {
        String report = COLUMNS;
        report += STORAGE.keySet().stream()
                .map(key -> key + LINE_SPLITTER + STORAGE.get(key) + END_LINE)
                .collect(Collectors.joining());
        return report;
    }
}
