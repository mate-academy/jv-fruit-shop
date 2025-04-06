package core.basesyntax.reportgenerator;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(HEADER + System.lineSeparator());

        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
