package core.basesyntax.service.parser;

import core.basesyntax.fruitmodel.Fruit;
import core.basesyntax.fruitstorage.FruitStorage;
import java.util.Map;

public class CreateReport implements Report {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String report() {
        FruitStorage fruitStorage = new FruitStorage();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : fruitStorage.getAll().entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
