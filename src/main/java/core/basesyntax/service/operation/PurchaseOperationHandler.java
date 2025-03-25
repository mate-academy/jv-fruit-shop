package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction, Storage fruitStorage) {
        fruitStorage.minusFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
