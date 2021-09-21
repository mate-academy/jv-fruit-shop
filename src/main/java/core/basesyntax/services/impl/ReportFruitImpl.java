package core.basesyntax.services.impl;

import core.basesyntax.dao.Storage;
import core.basesyntax.services.ReportFruit;
import java.util.Map;

public class ReportFruitImpl implements ReportFruit {
    public static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.map.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
