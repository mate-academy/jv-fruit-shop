package core.basesyntax.report;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        storage.forEach((fruit, quantity) ->
                report.append(fruit).append(",").append(quantity).append("\n"));
        return report.toString();
    }
}

