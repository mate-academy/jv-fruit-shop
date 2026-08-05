package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.getFruits;

import core.basesyntax.model.Fruit;

public class ReportCreator {
    public static String createReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Fruit fruit : getFruits()) {
            report.append(fruit.getName())
                    .append(",")
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
