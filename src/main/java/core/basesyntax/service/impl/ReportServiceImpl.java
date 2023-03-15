package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport(List<Fruit> fruitList) {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEADER)
                .append(System.lineSeparator());
        for (Fruit fruit : fruitList) {
            report.append(fruit.getName())
                    .append(SEPARATOR)
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
