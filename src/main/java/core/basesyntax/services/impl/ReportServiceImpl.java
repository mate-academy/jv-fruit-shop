package core.basesyntax.services.impl;

import core.basesyntax.db.DataStorage;
import core.basesyntax.services.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_ROW = "fruits,quantity";
    private static final String COMMA_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_ROW).append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> line : DataStorage.fruitsStorageMap.entrySet()) {
            stringBuilder.append(line.getKey());
            stringBuilder.append(COMMA_SEPARATOR);
            stringBuilder.append(line.getValue());
            stringBuilder.append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
