package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        validateInPut(fruitTransaction);
        Storage.setFruitBalance(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
