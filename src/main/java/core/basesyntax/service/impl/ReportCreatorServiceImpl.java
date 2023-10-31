package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String STANDARD_HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(STANDARD_HEADER);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey());
            report.append(COMMA_SEPARATOR);
            report.append(entry.getValue());
            report.append(System.lineSeparator());
        }
        return report.toString();
    }
}
