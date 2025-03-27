package core.basesyntax.service.operation;

import static core.basesyntax.db.Storage.removeFruit;

import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        removeFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
