package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreated;

public class ReportCreatedImpl implements ReportCreated {
    @Override
    public String createReport(Fruit[] fruits) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Fruit element: fruits) {
            stringBuilder.append(element.getFruit()).append(",")
                    .append(element.getQuantity()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
