package core.basesyntax.shop;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportCreator {
    public static final String COMA = ", ";

    public String createReport() {
        StringBuilder value = new StringBuilder().append("fruit,quantity\n");
        for (Map.Entry<Fruit, Integer> entry : Storage.getFruits().entrySet()) {
            value.append(entry.getKey().getName()).append(COMA)
                    .append(entry.getValue()).append("\n");
        }
        return value.toString();
    }
}
