package core.basesyntax.service.report;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.getAll().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
