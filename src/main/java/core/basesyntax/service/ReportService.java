package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import java.util.Arrays;
import java.util.Map;

public class ReportService {
    private static final String HEADER = "type,fruit,quantity\n";
    private static final String CSV_SEPARATOR = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public String generateReport() {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {

            report.append(Arrays.stream(Operation.values()).findAny().get().getCode())
                    .append(CSV_SEPARATOR)
                    .append(entry.getKey())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE_SEPARATOR);
        }
        return report.toString();
    }
}
