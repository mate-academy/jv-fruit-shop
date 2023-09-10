package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_NAMES = "fruit,quantity";
    private static final String DELIMITER = ",";
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_NAMES).append(NEW_LINE);
        for (Map.Entry<String, Integer> entry : Storage.STORAGE.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
