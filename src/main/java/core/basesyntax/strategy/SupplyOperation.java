package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        int currentNumber = storage.getOrDefault(transaction.getProduct(), 0);
        storage.put(transaction.getProduct(), transaction.getQuantity() + currentNumber);
    }
}
