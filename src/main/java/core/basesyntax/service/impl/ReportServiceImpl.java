package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SPLITTER = ",";
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_HEADER + System.lineSeparator());
        for (Map.Entry<Fruit, Integer> line : Storage.storage.entrySet()) {
            builder.append(line.getKey().getName())
                    .append(SPLITTER)
                    .append(line.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
