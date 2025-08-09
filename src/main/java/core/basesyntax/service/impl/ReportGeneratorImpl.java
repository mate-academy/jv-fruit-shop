package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String CSV_DELIMITER = ",";

    @Override
    public String getReport() {
        Map<String, Integer> fruitStorage = Storage.getFruitStorage();
        StringBuilder reportBuilder = new StringBuilder(REPORT_HEADER)
                .append(System.lineSeparator());
        fruitStorage.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> reportBuilder.append(entry.getKey())
                        .append(CSV_DELIMITER)
                        .append(entry.getValue())
                        .append(System.lineSeparator()));

        if (fruitStorage.isEmpty()) {
            return REPORT_HEADER;
        }
        return reportBuilder.toString();
    }
}
