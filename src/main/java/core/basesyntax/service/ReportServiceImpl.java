package core.basesyntax.service;

import core.basesyntax.db.Storage;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_LINE = "fruit,quantity";
    private static final String COMMA_DELIMITER = ",";
    private static final String SYSTEM_LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER_LINE)
                .append(SYSTEM_LINE_SEPARATOR);
        Storage.getFruitTransactions()
                .forEach((key, value) -> reportBuilder.append(key.toString().toLowerCase())
                .append(COMMA_DELIMITER)
                .append(value)
                .append(SYSTEM_LINE_SEPARATOR));
        return reportBuilder.toString();
    }
}
