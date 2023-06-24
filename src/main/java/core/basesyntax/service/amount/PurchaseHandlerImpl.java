package core.basesyntax.service.amount;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        Storage.fruits.compute(fruitTransaction.getFruitType(),
                (k, v) -> v - fruitTransaction.getAmount());
    }
}
