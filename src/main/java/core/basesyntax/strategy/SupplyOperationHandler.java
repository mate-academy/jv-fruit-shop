package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void processWithData(FruitTransaction transaction, Map<String, Integer> data) {
        String fruit = transaction.getFruit();
        int quantity = data.get(fruit) + transaction.getQuantity();
        data.put(fruit, quantity);
    }
}