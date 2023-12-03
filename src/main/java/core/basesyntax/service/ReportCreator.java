package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;

public class ReportCreator {

    public String createReport() {
        if (FruitStorage.FRUITS.isEmpty()) {
            throw new RuntimeException("No data for the report!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (String fruit : FruitStorage.FRUITS.keySet()) {
            stringBuilder.append(fruit)
                    .append(",")
                    .append(FruitStorage.FRUITS.get(fruit))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
