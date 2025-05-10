package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String REPORT_TITLE = "fruit,quantity\n";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(REPORT_TITLE);
        Storage.getAll().forEach((fruit, quantity) -> reportBuilder.append(fruit)
                .append(",")
                .append(quantity)
                .append("\n"));

        return reportBuilder.toString();
    }
}
