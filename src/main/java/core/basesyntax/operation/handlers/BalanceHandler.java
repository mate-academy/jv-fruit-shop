package core.basesyntax.operation.handlers;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        storage.put(fruit, quantity);
    }
}
