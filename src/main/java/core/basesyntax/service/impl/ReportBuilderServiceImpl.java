package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportBuilderService;
import java.util.Map;

public class ReportBuilderServiceImpl implements ReportBuilderService {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String createReport() {
        if (Storage.fruitStorage == null || Storage.fruitStorage.isEmpty()) {
            throw new RuntimeException("Please enter valid data");
        }
        StringBuilder builder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
