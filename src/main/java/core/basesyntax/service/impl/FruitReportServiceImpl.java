package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitReportService;
import java.util.Map;

public class FruitReportServiceImpl implements FruitReportService {
    public static final String COMMA = ",";
    public static final String LINE_SEPARATOR = "\n";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append("\n");
        for (Map.Entry<Fruit, Integer> entry : Storage.data.entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
