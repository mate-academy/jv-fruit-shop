package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMA_SEPARATOR = ",";
    private static final String FIRST_LINE_IN_REPORT = "fruit,quantity" + LINE_SEPARATOR;
    private StringBuilder report;

    @Override
    public String fruitReport() {
        report = new StringBuilder(FIRST_LINE_IN_REPORT);
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            report.append(entry.getKey())
                    .append(COMA_SEPARATOR)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return report.toString();
    }
}
