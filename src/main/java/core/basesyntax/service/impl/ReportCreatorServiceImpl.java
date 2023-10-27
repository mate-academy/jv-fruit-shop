package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String DATA_SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry entry : Storage.getFruits().entrySet()) {
            report.append(entry.getKey()).append(DATA_SEPARATOR)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
