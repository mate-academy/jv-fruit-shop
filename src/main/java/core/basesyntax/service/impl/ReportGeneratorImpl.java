package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE = "fruit,quantity\n";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(TITLE);
        for (Map.Entry<String, Integer> entry : FruitStorage.fruitStorage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
