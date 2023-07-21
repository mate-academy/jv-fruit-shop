package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();
        try {
            if (quantity >= 0) {
              FruitStorage.fruits.put(fruitName, transaction);
            }
        } catch (Exception e) {
            throw new RuntimeException("quantity must be positive value");
        }
    }
}
