package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.interfaces.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        Storage.storage.forEach((key, value) -> stringBuilder.append(key.getName())
                .append(CSV_SEPARATOR)
                .append(value)
                .append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
