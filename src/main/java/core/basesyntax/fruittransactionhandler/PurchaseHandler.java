package core.basesyntax.fruittransactionhandler;

import core.basesyntax.fruittransactionhandler.storage.HashMapWithQuantities;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() > 0) {
            HashMapWithQuantities.hashMapToReport.compute(fruitTransaction.getFruit(),
                    (k, currentValue) -> currentValue - fruitTransaction.getQuantity());
        }
    }
}
