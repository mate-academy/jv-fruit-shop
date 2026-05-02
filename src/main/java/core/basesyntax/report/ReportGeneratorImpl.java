package core.basesyntax.report;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();

        report.append("fruit,quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
