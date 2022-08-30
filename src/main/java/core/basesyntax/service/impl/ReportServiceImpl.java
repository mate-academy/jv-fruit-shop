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
        builder.append(REPORT_HEADER + System.lineSeparator());

        for (Map.Entry<Fruit, Integer> map : Storage.getStorage().entrySet()) {
            String reportLine = map.getKey().getName() + SEPARATOR + map.getValue()
                    + System.lineSeparator();
            builder.append(reportLine);
        }
        return builder.toString();
    }
}
