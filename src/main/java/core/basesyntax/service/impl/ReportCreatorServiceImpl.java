package core.basesyntax.service.impl;

import static core.basesyntax.db.FruitStorage.storageFruits;

import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String HEADER = "fruit,quantity";
    private static final char SEPARATOR = ',';

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storageFruits.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
