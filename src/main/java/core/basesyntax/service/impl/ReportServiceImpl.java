package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Collection;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(Collection<Fruit> fruits) {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Fruit fruit : fruits) {
            report.append(fruit).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
