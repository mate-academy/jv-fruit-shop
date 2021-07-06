package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String HEADER = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER);
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            builder.append(LINE_SEPARATOR)
                    .append(entry.getKey().getName())
                    .append(COMMA_SEPARATOR)
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
