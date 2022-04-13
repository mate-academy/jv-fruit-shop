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
                fruitMap.put(f.getFruit(), 0);
            }
            int currentQuantity = fruitMap.get(f.getFruit());
            int newQuantity = operationStrategy.get(f.getOperation())
                    .handle(currentQuantity, f.getQuantity());
            fruitMap.replace(f.getFruit(), newQuantity);
        }
        return fruitMap;
    }
}
