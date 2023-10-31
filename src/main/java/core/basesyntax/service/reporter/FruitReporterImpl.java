package core.basesyntax.service.reporter;

import static core.basesyntax.db.FruitStorage.fruitQuantity;

public class FruitReporterImpl implements Reporter {
    private static final String DATA_SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(REPORT_HEADER);
        for (String fruit : fruitQuantity.keySet()) {
            builder.append(System.lineSeparator())
                    .append(fruit)
                    .append(DATA_SEPARATOR)
                    .append(fruitQuantity.get(fruit));
        }
        return builder.toString();
    }
}
