package core.basesyntax.shopserviceandreportgenerator;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return report.toString();
    }
}
