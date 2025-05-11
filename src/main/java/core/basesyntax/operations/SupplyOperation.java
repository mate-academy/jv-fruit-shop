package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import java.util.Map;
import java.util.Optional;

public class SupplyOperation implements OperationHandler {
    @Override
    public Map<String, Integer> getCalculation(
            Map<String, Integer> fruits, FruitTransaction fruitTransaction) {
        if (fruits.isEmpty()) {
            throw new RuntimeException("Fruit's list is empty");
        }
        if (fruits.containsKey(fruitTransaction.getFruit())) {
            Optional<Map.Entry<String, Integer>> fruitEntry = fruits.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(fruitTransaction.getFruit()))
                    .map(entry -> Map.entry(
                            entry.getKey(), entry.getValue() + fruitTransaction.getQuantity()))
                    .findFirst();
            fruits.put(fruitEntry.get().getKey(), fruitEntry.get().getValue());
            return fruits;
        } else {
            fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
            return fruits;
        }
    }
}
