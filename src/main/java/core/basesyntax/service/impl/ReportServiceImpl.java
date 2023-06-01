package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String SEPARATOR = ",";
    public static final String FRUIT_QUANTITY = "fruit,quantity";

    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(FRUIT_QUANTITY + System.lineSeparator());
        for (Map.Entry<String, Integer> data : Storage.fruitStorage.entrySet()) {
            stringBuilder.append(data.getKey())
                    .append(SEPARATOR)
                    .append(data.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
