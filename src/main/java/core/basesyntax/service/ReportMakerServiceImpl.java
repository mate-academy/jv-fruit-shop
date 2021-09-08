package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = "\n";
    private static final String FIRST_ROW = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(FIRST_ROW);
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            builder.append(LINE_SEPARATOR)
                    .append(getSingleFruitReport(entry));
        }
        return builder.toString();
    }

    private String getSingleFruitReport(Map.Entry<String, Integer> entry) {
        return entry.getKey()
                + COMMA
                + entry.getValue();
    }
}
