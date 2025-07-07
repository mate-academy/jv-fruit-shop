package core.basesyntax.report;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        String firstLine = "fruit,quantity" + System.lineSeparator();
        StringBuilder stringBuilder = new StringBuilder(firstLine);
        for (Fruit fruit : Storage.fruits) {
            stringBuilder
                    .append(fruit.getName())
                    .append(",")
                    .append(fruit.getAmount())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
