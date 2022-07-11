package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    @Override
    public String makeReport(List<Fruit> fruits) {
        StringBuilder builder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        fruits.forEach(fruit -> builder.append(fruit.getFruitName())
                .append(",").append(fruit.getQuantity()).append(System.lineSeparator()));
        return builder.toString();
    }
}
