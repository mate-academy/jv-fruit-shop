package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_HEADER).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> map : Storage.getStorage().entrySet()) {
            builder.append(map.getKey().getName()).append(SEPARATOR)
                    .append(map.getValue()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
