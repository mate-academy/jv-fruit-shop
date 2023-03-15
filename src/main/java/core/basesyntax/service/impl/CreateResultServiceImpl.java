package core.basesyntax.service.impl;

import core.basesyntax.service.CreateResultService;
import java.util.Map;

public class CreateResultServiceImpl implements CreateResultService {
    private static final String FRUIT_QUANTITY = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String create(Map<String, Integer> fruitStorage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRUIT_QUANTITY);
        for (Map.Entry<String, Integer> fruit : fruitStorage.entrySet()) {
            stringBuilder.append(System.lineSeparator()
                    + fruit.getValue() + SEPARATOR + fruit.getKey());
        }
        return stringBuilder.toString();
    }
}
