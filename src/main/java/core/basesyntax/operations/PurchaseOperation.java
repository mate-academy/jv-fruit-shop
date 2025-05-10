package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Map<String, Integer> getCalculation(
            Map<String, Integer> fruits, FruitTransaction fruitTransaction) {
        if (fruits.isEmpty()) {
            throw new RuntimeException("Fruit's list is empty");
        }
        return fruits.entrySet().stream()
                .map(entry -> {
                    int newValue = entry.getKey().equals(fruitTransaction.getFruit())
                            ? entry.getValue() - fruitTransaction.getQuantity()
                            : entry.getValue();
                    if (newValue < 0) {
                        throw new RuntimeException("Value cant be smaller than 0");
                    }
                    return Map.entry(entry.getKey(), newValue);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
