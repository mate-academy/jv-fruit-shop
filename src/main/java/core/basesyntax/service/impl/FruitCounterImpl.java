package core.basesyntax.service.impl;

import core.basesyntax.service.FruitCounter;
import core.basesyntax.strategy.FruitAdder;
import core.basesyntax.strategy.FruitCreator;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitSubtractor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitCounterImpl implements FruitCounter {
    private static final int INDEX_OPERATION = 0;

    public List<String> countFruits(List<String> unhandledFruits, Map<String, FruitHandler> strategy) {
        List<String> fruitTypes = new ArrayList<>();
        List<Integer> fruitAmount = new ArrayList<>();

        for (String unhandledFruit : unhandledFruits) {
            String[] currentLine = unhandledFruit.split(",");
            FruitHandler fruitHandler = strategy.get(currentLine[INDEX_OPERATION]);
            fruitHandler.handle(fruitTypes, fruitAmount, currentLine);
        }

        List<String> countedFruits = new ArrayList<>();
        countedFruits.add("fruit,quantity");
        for (int i = 0; i < fruitTypes.size(); i++) {
            countedFruits.add(fruitTypes.get(i) + "," + fruitAmount.get(i));
        }
        return countedFruits;
    }
}
