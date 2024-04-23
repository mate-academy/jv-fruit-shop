package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.FruitStorageImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        FruitStorageImpl.fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
