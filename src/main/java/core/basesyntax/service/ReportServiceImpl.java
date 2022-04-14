package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TOPIC = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TOPIC).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue().toString())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
