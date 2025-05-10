package core.basesyntax.service.report;

import core.basesyntax.dao.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT)
                .append(COMMA)
                .append(QUANTITY)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
