package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CalculateData;
import core.basesyntax.strategy.FruitStrategyImpl;
import java.util.List;
import java.util.Map;

public class CalculateDataImpl implements CalculateData {
    static final int OPERATION_INDEX = 0;
    static final int FRUIT_INDEX = 1;
    static final int AMOUNT_INDEX = 2;
    private FruitStrategyImpl fruitStrategy = new FruitStrategyImpl();

    @Override
    public Map<String, Integer> calculateData(List<String[]> lines) {
        for (String[] line: lines) {
            String key = line[FRUIT_INDEX];
            int oldAmount = Storage.mapFruits.getOrDefault(key, 0);
            int newAmount = Integer.parseInt(line[AMOUNT_INDEX]);
            Storage.mapFruits.put(line[FRUIT_INDEX].trim(),
                    fruitStrategy.getFruitService(line[OPERATION_INDEX].trim())
                            .calculateFruits(oldAmount, newAmount));
        }
        return Storage.mapFruits;
    }
}
