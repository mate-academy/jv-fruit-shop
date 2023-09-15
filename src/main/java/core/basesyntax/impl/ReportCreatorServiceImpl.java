package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String DEFAULT_MESSAGE = "fruit,quantity";
    private static final String SPLIT_DELIMITER = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(DEFAULT_MESSAGE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.STORAGE.entrySet()) {
            report.append(entry.getKey())
                    .append(SPLIT_DELIMITER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }

}
