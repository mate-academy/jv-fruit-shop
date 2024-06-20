package core.basesyntax.service.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String SEPARATOR = ",";
    public static final String TITLE = "fruit" + SEPARATOR + "quantity";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE).append(System.lineSeparator());

        Storage.fruits.forEach(
                (fruit, quantity) -> reportBuilder
                        .append(fruit)
                        .append(SEPARATOR)
                        .append(quantity)
                        .append(System.lineSeparator())
        );
        return reportBuilder.toString();
    }
}
