package core.basesyntax.impl;

import core.basesyntax.base.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String CSV_FILE_HEADER = "fruit,quantity";
    private static final String CSV_DELIMITER = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(CSV_FILE_HEADER).append(LINE_SEPARATOR);

        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(CSV_DELIMITER)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }

        return reportBuilder.toString();
    }
}
