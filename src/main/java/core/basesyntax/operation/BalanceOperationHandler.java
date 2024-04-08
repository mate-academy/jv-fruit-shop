package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Unable to complete the balance");
        }
        Storage.fruitBalance.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
