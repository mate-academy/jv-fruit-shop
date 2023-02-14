package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String SEPARATED_VALUE = ",";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_LINE);
        for (Map.Entry<Fruit, Integer> fruitInfo : FruitStorage.storage.entrySet()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(fruitInfo.getKey().getName())
                    .append(SEPARATED_VALUE).append(fruitInfo.getValue());
        }
        return stringBuilder.toString();
    }
}
