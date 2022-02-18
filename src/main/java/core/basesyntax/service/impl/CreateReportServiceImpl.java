package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReportService;
import java.util.List;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String TITLE_TEXT = "fruit,quantity";

    public String createReport(List<Fruit> fruits) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_TEXT).append(System.lineSeparator());
        for (Fruit fruit: fruits) {
            stringBuilder.append(fruit.getName()).append(",")
                    .append(fruit.getQuantity()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
