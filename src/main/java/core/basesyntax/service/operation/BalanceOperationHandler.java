package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.FruitStorageImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private FruitStorage storage = new FruitStorageImpl();

    @Override
    public void process(FruitTransaction transaction) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
