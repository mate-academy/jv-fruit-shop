package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import java.util.Map;
import java.util.Optional;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Map<String, Integer> getCalculation(
            Map<String, Integer> fruits, FruitTransaction fruitTransaction) {
        if (fruits.isEmpty()) {
            throw new RuntimeException("Fruit's list is empty");
        }
        if (fruits.containsKey(fruitTransaction.getFruit())) {
            Optional<Map.Entry<String, Integer>> fruitEntry = fruits.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(fruitTransaction.getFruit()))
                    .map(entry -> {
                        int valueIsNegative = entry.getValue() - fruitTransaction.getQuantity() > 0
                                ? 1 : 0;
                        if (valueIsNegative > 0) {
                            return Map.entry(entry.getKey(),
                                    entry.getValue() - fruitTransaction.getQuantity());
                        } else {
                            throw new RuntimeException("Value is negative");
                        }
                    })
                    .findFirst();
            fruits.put(fruitEntry.get().getKey(), fruitEntry.get().getValue());
        } else {
            throw new RuntimeException("Such fruit doest exist" + fruitTransaction.getFruit());
        }
        return fruits;

    }
}
