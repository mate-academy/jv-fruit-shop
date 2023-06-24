package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String doReport() {
        return REPORT_HEADER + Storage.fruitsMap.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
