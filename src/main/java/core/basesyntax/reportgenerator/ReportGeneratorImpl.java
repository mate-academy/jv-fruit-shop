package core.basesyntax.reportgenerator;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        String reportFormat = "fruit, quantity";
        StringBuilder report = new StringBuilder();
        report.append(reportFormat).append(System.lineSeparator());
        Map<String, Integer> dataToReport = Storage.getDataStorageMap();
        for (Map.Entry<String, Integer> entry : dataToReport.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
