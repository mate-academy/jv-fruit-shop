package core.basesyntax.service.report;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE_REPORT = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> fruits) {
        StringBuilder report = new StringBuilder();

        report.append(TITLE_REPORT).append(System.lineSeparator());

        fruits.keySet().forEach(product -> report
                        .append(product)
                        .append(",")
                        .append(fruits.get(product))
                        .append(System.lineSeparator()));
        return report.toString();
    }
}
