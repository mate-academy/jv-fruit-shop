package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_FRUIT = "fruit ";
    private static final String HEADER_QUANTITY = "quantity ";
    private static final String APPENDER = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER_FRUIT);
        report.append(APPENDER);
        report.append(HEADER_QUANTITY);
        report.append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey().getName())
                    .append(APPENDER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
