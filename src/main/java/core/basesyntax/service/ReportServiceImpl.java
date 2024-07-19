package core.basesyntax.service;

import core.basesyntax.db.Storage;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_LINE = "fruit, quantity";
    private static final String COMMA_DELIMITER = ",";

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER_LINE)
                .append("\n");
        Storage.getFruits().forEach(fruit -> reportBuilder.append(fruit.getName())
                .append(COMMA_DELIMITER)
                .append(fruit.getQuantity())
                .append("\n"));
        return reportBuilder.toString();
    }
}
