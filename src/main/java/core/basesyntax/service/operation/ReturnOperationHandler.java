package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.FruitStorageImpl;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        FruitStorageImpl.fruitStorage.put(transaction.getFruit(),
                FruitStorageImpl.fruitStorage.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
