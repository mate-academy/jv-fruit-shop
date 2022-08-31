package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReport(List<Fruit> fruits) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append("\n");
        fruits.forEach(f -> builder.append(f.getName()).append(",")
                .append(f.getAmount()).append("\n"));
        return builder.toString();
    }
}
