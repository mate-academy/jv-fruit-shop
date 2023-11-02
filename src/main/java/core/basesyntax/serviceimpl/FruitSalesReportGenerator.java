package core.basesyntax.serviceimpl;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.storage.Storage;

public class FruitSalesReportGenerator implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private static final String REPORT_TOP_MESSAGE = "fruit,quantity";

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder();
        return builder.append(REPORT_TOP_MESSAGE)
                .append(System.lineSeparator())
                .append(BANANA + COMMA)
                .append(Storage.getFruitBalance().get(BANANA))
                .append(System.lineSeparator())
                .append(APPLE)
                .append(COMMA)
                .append(Storage.getFruitBalance().get(APPLE)).toString();
    }
}
