package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        int fruitsInStorage = Storage.storage.get(fruitTransaction.getFruit());
        int updateQuantity = fruitsInStorage + fruitTransaction.getQuantity();
        Storage.storage.put(fruitTransaction.getFruit(), updateQuantity);
    }
}
