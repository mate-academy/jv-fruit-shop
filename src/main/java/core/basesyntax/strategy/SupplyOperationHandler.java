package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction transaction, Storage fruitsStorage) {
        fruitsStorage.getFruitsStorage().put(transaction.getFruit(), fruitsStorage
                .getFruitsStorage().get(transaction.getFruit()) + transaction.getQuantity());
    }
}
