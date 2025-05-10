package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(FIRST_LINE).append(System.lineSeparator());
        FruitStorage.getFruitsStorage().forEach(
                (key, value) -> reportBuilder.append(key)
                        .append(SEPARATOR)
                        .append(value)
                        .append(System.lineSeparator()));
        return reportBuilder.toString();
    }
}
