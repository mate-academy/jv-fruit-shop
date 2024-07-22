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
        Storage.getFruits().forEach(fruit ->
                reportBuilder.append(fruit.getName().name().toLowerCase())
                .append(COMMA_DELIMITER)
                .append(fruit.getQuantity())
                .append(SYSTEM_LINE_SEPARATOR));
        return reportBuilder.toString();
    }
}
