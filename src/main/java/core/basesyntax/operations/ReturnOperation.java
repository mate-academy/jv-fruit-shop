package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void getCalculation(FruitTransaction fruitTransaction) {

        if (Storage.storage.get(fruitTransaction.getFruit()) == null) {
            throw new RuntimeException("Such fruit was not found: " + fruitTransaction.getFruit());
        }
        int quantity = Storage.storage
                .get(fruitTransaction.getFruit()) + fruitTransaction.getQuantity();
        Storage.storage.put(fruitTransaction.getFruit(), quantity);
    }
}
