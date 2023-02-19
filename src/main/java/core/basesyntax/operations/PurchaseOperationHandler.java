package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldSum = Storage.fruits.get(fruitTransaction.getFruit());
        Storage.fruits.put(fruitTransaction.getFruit(),oldSum - fruitTransaction.getQuantity());
    }
}
