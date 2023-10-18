package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String WORD_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String HEAD_STRING = "fruit,quantity" + LINE_SEPARATOR;

    @Override
    public String generateReport() {
        return Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + WORD_SEPARATOR
                + entry.getValue())
                .collect(Collectors.joining(LINE_SEPARATOR,
                        HEAD_STRING, LINE_SEPARATOR));
    }
}
