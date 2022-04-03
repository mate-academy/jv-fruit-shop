package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DailyReport {
    private final List<String> result = new ArrayList<>();
    private final Map<String, Integer> fruitMap = new HashMap<>();
    private final OperationStrategy operationStrategy = new OperationStrategyImpl();

    public List<String> listOperation(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction f: fruitTransactionList) {
            if (fruitMap.isEmpty() || !fruitMap.containsKey(f.getFruit())) {
                addNewPairToMap(f.getFruit());
            }
            int oldValue = fruitMap.get(f.getFruit());
            int newValue = operationStrategy.get(f.getOperation())
                    .getResultOfFruitOperation(oldValue, f.getQuantity());
            fruitMap.replace(f.getFruit(), newValue);

        }
        return fruitMap.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
    }

    private void addNewPairToMap(String name) {
        fruitMap.put(name, 0);
    }

}
