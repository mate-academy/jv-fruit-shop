package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Can't complete the balance");
        }
        Storage.setFruitBalance(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
