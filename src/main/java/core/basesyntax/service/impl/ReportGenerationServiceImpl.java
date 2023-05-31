package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerationService;
import java.util.Map;

public class ReportGenerationServiceImpl implements ReportGenerationService {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String COMA_SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(FRUIT).append(COMA_SEPARATOR)
                .append(QUANTITY).append(System.lineSeparator());
        for (Map.Entry<String, Integer> data : Storage.FRUITS.entrySet()) {
            String line = data.getKey() + COMA_SEPARATOR + data.getValue() + System.lineSeparator();
            reportBuilder.append(line);
        }
        return reportBuilder.toString();
    }
}
