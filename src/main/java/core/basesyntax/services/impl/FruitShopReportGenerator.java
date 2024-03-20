package core.basesyntax.services.impl;

import static core.basesyntax.db.StorageDao.fruitStorage;

import core.basesyntax.services.ReportGenerator;
import java.util.Map;

public class FruitShopReportGenerator implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private StringBuilder builder = new StringBuilder();

    @Override
    public String generateReport() {
        builder.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruits : fruitStorage.entrySet()) {
            builder.append(fruits.getKey()).append(COMMA)
                    .append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
