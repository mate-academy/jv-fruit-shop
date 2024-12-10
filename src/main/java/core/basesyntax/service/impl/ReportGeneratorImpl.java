package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE = "fruit,quantity";
    private static final int TITLE_INDEX = 0;
    private static final String DELIMITER = ",";

    @Override
    public List<String> getReport() {
        List<String> report = Storage.STORED_FRUITS
                .entrySet()
                .stream()
                .map(lot -> lot.getKey() + DELIMITER + lot.getValue())
                .collect(Collectors.toList());
        report.add(TITLE_INDEX, TITLE);
        return report;
    }
}
