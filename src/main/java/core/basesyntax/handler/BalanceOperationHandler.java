package core.basesyntax.handler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        FruitStorage.STORAGE.put(transaction.getFruit(), transaction.getQuantity());
    }
}
