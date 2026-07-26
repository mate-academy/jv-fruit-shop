package core.basesyntax.service;

import core.basesyntax.db.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();

        builder.append(HEADER).append(LINE_SEPARATOR);

        for (String fruit : Storage.fruits.keySet()) {
            builder.append(fruit)
                    .append(SEPARATOR)
                    .append(Storage.fruits.get(fruit))
                    .append(LINE_SEPARATOR);
        }

        return builder.toString();
    }
}
