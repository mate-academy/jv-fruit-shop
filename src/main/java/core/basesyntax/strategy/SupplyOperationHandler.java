package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void toProcess(FruitTransaction transaction) {
        int oldQuantity = Storage.fruitStorage.get(transaction.getFruit());
        Storage.fruitStorage.put(transaction.getFruit(), transaction.getQuantity() + oldQuantity);
    }
}
