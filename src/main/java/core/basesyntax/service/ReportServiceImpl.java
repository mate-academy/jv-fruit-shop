package core.basesyntax.service;

import static core.basesyntax.db.Storage.reportData;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : reportData.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(", ")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
