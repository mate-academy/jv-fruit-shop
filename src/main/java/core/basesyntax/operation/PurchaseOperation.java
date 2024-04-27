package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.NoSuchElementException;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int fruitsInStorage = Storage.storage.get(fruit);
        int fruitsToBuy = fruitTransaction.getQuantity();
        if (fruitsToBuy > fruitsInStorage) {
            throw new NoSuchElementException("Not enough fruit for purchase. You can purchase max: "
                    + fruitsInStorage);
        }
        Storage.storage.put(fruitTransaction.getFruit(), fruitsInStorage - fruitsToBuy);
    }
}
