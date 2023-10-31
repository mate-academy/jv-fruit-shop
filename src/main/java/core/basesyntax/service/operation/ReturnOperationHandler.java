package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void execute(FruitTransaction fruitTransaction) {
        Integer newQuantity = Storage.storage.get(fruitTransaction.getName())
                                                    + fruitTransaction.getQuantity();
        Storage.storage.put(fruitTransaction.getName(), newQuantity);
    }
}
