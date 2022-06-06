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

    public List<String> countFruits(List<String> uncountedFruits) {
        List<String> fruitTypes = new ArrayList<>();
        List<Integer> fruitAmount = new ArrayList<>();
        Map<String, FruitHandler> strategy = new HashMap<>();
        strategy.put("b", new FruitCreator());
        strategy.put("s", new FruitAdder());
        strategy.put("r", new FruitAdder());
        strategy.put("p", new FruitSubtractor());

        for (String uncountedFruit : uncountedFruits) {
            String[] line = uncountedFruit.split(",");
            FruitHandler fruitHandler = strategy.get(line[INDEX_OPERATION]);
            fruitHandler.handle(fruitTypes, fruitAmount, line);
            /*        throw new RuntimeException("Invalid operation. "
                           + "Allowed operations are: b - for balance, "
                          + "s - for supply, r - for return, p - for purchase"); */
        }

        List<String> countedFruits = new ArrayList<>();
        countedFruits.add("fruit,quantity");
        for (int i = 0; i < fruitTypes.size(); i++) {
            countedFruits.add(fruitTypes.get(i) + "," + fruitAmount.get(i));
        }
        return countedFruits;
    }
}
