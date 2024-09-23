package core.basesyntax.report;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity\n";
    private static final String SEPARATOR = ",";
    private static final String LINE_BREAK = "\n";

    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        storage.forEach((fruit, quantity) ->
                report.append(fruit)
                        .append(SEPARATOR)
                        .append(quantity)
                        .append(LINE_BREAK));
        return report.toString();
    }
}
