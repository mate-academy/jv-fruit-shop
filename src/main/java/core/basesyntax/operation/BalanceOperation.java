package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> inventory, FruitTransaction fruitTransaction) {
        inventory.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());

    }
}
