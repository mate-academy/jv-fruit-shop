package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitOutputService implements OutputService {
    private static final String COLUMNS = "fruit,quantity";
    private static final String WORDS_SEPARATOR = ",";

    @Override
    public String makeOutputResult() {
        StringBuilder outputBuilder = new StringBuilder(COLUMNS);
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            outputBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName().toLowerCase())
                    .append(WORDS_SEPARATOR)
                    .append(entry.getValue());
        }
        return outputBuilder.toString();
    }
}
