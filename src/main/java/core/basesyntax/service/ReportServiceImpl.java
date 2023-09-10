package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String LINE = System.lineSeparator();

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(FIRST_LINE);
        Set<Map.Entry<String, Integer>> entrySet = Storage.storage.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            builder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE);
        }
        return builder.toString();
    }
}
