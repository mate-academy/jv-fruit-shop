package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void getCalculation(FruitTransaction fruitTransaction) {

        if (Storage.storage.get(fruitTransaction.getFruit()) == null) {
            throw new RuntimeException("Such fruit was not found: " + fruitTransaction.getFruit());
        }
        int quantity = Storage.storage
                        .get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Not enough fruit quality!");
        }
        Storage.storage.put(fruitTransaction.getFruit(), quantity);
    }
}
