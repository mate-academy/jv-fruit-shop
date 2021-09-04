package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;
import core.basesyntax.model.Fruit;

public class ReportFruitImpl implements ReportFruit {
    public static final String COMMA = ",";
    public static final String LINE_SEPARATOR = "\n";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(LINE_SEPARATOR);
        for (Map.Entry<Fruit, Integer> entry : Storage.data.entrySet()) {
            stringBuilder.append(entry.getKey().getFruitName())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
