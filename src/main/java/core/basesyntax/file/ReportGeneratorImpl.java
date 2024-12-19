package core.basesyntax.file;

import core.basesyntax.db.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(FIRST_LINE).append(System.lineSeparator());
        Storage.getFruitsStorage().forEach(
                (key, value) -> reportBuilder.append(key)
                        .append(SEPARATOR)
                        .append(value)
                        .append(System.lineSeparator()));
        return reportBuilder.toString();
    }
}
