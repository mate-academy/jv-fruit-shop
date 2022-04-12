package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    private final Map<String, Integer> fruitMap = new HashMap<>();
    private final OperationStrategy operationStrategy = new OperationStrategyImpl();

    public Map<String, Integer> putFruitInStorage(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction f : fruitTransactionList) {
            if (fruitMap.isEmpty() || !fruitMap.containsKey(f.getFruit())) {
                addNewPairToMap(f.getFruit());
            }
            int oldValue = fruitMap.get(f.getFruit());
            int newValue = operationStrategy.get(f.getOperation())
                    .getResultOfFruitOperation(oldValue, f.getQuantity());
            fruitMap.replace(f.getFruit(), newValue);

        }
        return fruitMap;
    }

    private void addNewPairToMap(String name) {
        fruitMap.put(name, 0);
    }
}
