package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String FILE_HEADING = "fruit,quantity";

    @Override
    public String makeReport() {
        StringBuilder reportBuilder = new StringBuilder(FILE_HEADING);
        for (Map.Entry<Fruit, Integer> fruitData : FruitStorage.fruitsMap.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(fruitData.getKey().getFruitName())
                    .append(",")
                    .append(fruitData.getValue());
        }
        return reportBuilder.toString();
    }
}
