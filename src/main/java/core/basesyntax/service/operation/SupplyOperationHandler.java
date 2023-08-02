package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void completeOperation(FruitTransaction fruitTransaction) {
        Integer newQuantity = Storage.storage.get(fruitTransaction.getName())
                                                    + fruitTransaction.getQuantity();
        Storage.storage.put(fruitTransaction.getName(), newQuantity);
    }
}
