package core.basesyntax.reportgenerator;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String reportFormat = "fruit, quantity";

    @Override
    public String getReport(Storage dataToReport) {
        StringBuilder report = new StringBuilder();
        report.append(reportFormat).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : dataToReport.getDataStorageMap().entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
