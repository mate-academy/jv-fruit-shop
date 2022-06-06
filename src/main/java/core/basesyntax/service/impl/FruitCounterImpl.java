package core.basesyntax.service.impl;

import core.basesyntax.service.FruitCounter;
import core.basesyntax.strategy.FruitHandler;
import java.util.List;
import java.util.Map;

public class FruitCounterImpl implements FruitCounter {
    private static final int INDEX_OPERATION = 0;

    public void countFruits(List<String> unhandledFruits,
                            Map<String, FruitHandler> strategy) {
        for (String unhandledFruit : unhandledFruits) {
            String[] currentLine = unhandledFruit.split(",");
            FruitHandler fruitHandler = strategy.get(currentLine[INDEX_OPERATION]);
            fruitHandler.handle(currentLine);
        }
    }
}
