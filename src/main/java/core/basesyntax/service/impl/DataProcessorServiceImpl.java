package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.DataProcessorService;
import core.basesyntax.strategy.FruitStrategy;
import java.util.List;

public class DataProcessorServiceImpl implements DataProcessorService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final FruitStrategy fruitStrategy = new FruitStrategy();

    @Override
    public void processData(List<String[]> lines) {
        for (String[] line: lines) {
            String key = line[FRUIT_INDEX];
            int oldAmount = Storage.mapFruits.getOrDefault(key, 0);
            int newAmount = Integer.parseInt(line[AMOUNT_INDEX]);
            Storage.mapFruits.put(line[FRUIT_INDEX].trim(),
                    fruitStrategy.getFruitService(line[OPERATION_INDEX].trim())
                            .calculateFruits(oldAmount, newAmount));
        }
    }
}
