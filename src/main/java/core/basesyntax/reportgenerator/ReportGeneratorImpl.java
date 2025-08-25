package core.basesyntax.reportgenerator;

import core.basesyntax.fruittransactionhandler.storage.HashMapWithQuantities;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        Map<String, Integer> dataToReport = HashMapWithQuantities.hashMapToReport;
        for (Map.Entry<String, Integer> entry : dataToReport.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
