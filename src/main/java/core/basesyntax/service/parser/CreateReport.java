package core.basesyntax.service.parser;

import core.basesyntax.fruitstorage.FruitStorage;
import java.util.Map;

public class CreateReport implements Report {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : FruitStorage.fruitStorage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
