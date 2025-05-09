package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import java.util.Map;
import java.util.stream.Collectors;

public class SupplyOperation implements OperationHandler {
    @Override
    public Map<String, Integer> getCalculation(
            Map<String, Integer> fruits, FruitTransaction fruitTransaction) {
        if (fruits.isEmpty()) {
            throw new RuntimeException("Fruit's list is empty");
        }
        return fruits.entrySet().stream()
                .map(entry -> entry.getKey().equals(fruitTransaction.getFruit())
                        ? Map.entry(entry.getKey(),
                        entry.getValue() + fruitTransaction.getQuantity()) : entry)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
