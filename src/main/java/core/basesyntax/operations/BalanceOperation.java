package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public Map<String, Integer> getCalculation(
            Map<String, Integer> fruits, FruitTransaction fruitTransaction) {
        fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        return fruits;
    }
}
