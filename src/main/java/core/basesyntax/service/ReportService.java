package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportService {
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",")
                     .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
