package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMA = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder("fruit,weight" + LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : Storage.fruitShopStorage.entrySet()) {
            builder.append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return builder.toString();
    }
}
