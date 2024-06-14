package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SPLITTER = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String,Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SPLITTER)
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
