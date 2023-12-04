package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;

public class ReportCreator {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public String createReport() {
        if (FruitStorage.FRUITS.isEmpty()) {
            throw new RuntimeException("No data for the report!");
        }
        StringBuilder stringBuilder = new StringBuilder(FIRST_LINE + System.lineSeparator());
        for (String fruit : FruitStorage.FRUITS.keySet()) {
            stringBuilder.append(fruit)
                    .append(SEPARATOR)
                    .append(FruitStorage.FRUITS.get(fruit))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
