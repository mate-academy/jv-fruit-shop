package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR_SIGN = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        Storage.fruits.forEach((fruit, quantity) -> report.append(fruit)
                        .append(SEPARATOR_SIGN)
                        .append(quantity)
                        .append(System.lineSeparator()));
        return report.toString();
    }
}
