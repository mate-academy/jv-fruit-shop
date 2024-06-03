package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        for (Map.Entry<String,Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
