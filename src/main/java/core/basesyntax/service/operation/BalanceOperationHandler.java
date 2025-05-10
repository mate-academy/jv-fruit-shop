package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer handle(FruitTransaction fruitTransaction, Storage storage) {
        return fruitTransaction.getQuantity();
    }
}
