package core.basesyntax.serviceimpl;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class FruitSalesReportGenerator implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String REPORT_TOP_MESSAGE = "fruit,quantity";

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_TOP_MESSAGE)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> storageValues : Storage.getFruitBalance().entrySet()) {
            builder.append(storageValues.getKey())
                    .append(COMMA)
                    .append(storageValues.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
