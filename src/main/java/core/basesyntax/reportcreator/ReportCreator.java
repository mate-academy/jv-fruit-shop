package core.basesyntax.reportcreator;

import core.basesyntax.Operation;
import core.basesyntax.Storage;
import java.util.Map;

public class ReportCreator {
    private static final String HEADER = "type,fruit,quantity\n";
    private static final String CSV_SEPARATOR = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public String generateReport() {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report.append(Operation.BALANCE)
                    .append(CSV_SEPARATOR)
                    .append(entry.getKey())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE_SEPARATOR);
        }
        return report.toString();
    }
}
