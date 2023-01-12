package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ProcessWithData;
import core.basesyntax.strategy.FruitStrategyImpl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessWithDataImpl implements ProcessWithData {
    static final int INDEX_OF_PROCESS = 0;
    static final int INDEX_OF_FRUIT = 1;
    static final int INDEX_OF_AMOUNT = 2;
    private FruitStrategyImpl fruitStrategy = new FruitStrategyImpl();

    @Override
    public Map<String, Integer> processWithData(List<String[]> lines) {
        List<String[]> listSorted = lines.stream()
                .skip(1)
                .collect(Collectors.toList());

        for (String[] line: listSorted) {
            String key = line[INDEX_OF_FRUIT];
            int oldAmount = Storage.mapFruits.getOrDefault(key, 0);
            int newAmount = Integer.parseInt(line[INDEX_OF_AMOUNT]);
            Storage.mapFruits.put(line[INDEX_OF_FRUIT].trim(),
                    fruitStrategy.getFruitService(line[INDEX_OF_PROCESS].trim())
                            .calculateFruits(oldAmount, newAmount));
        }
        return Storage.mapFruits;
    }
}
