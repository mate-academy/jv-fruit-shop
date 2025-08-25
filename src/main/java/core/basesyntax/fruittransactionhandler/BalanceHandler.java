package core.basesyntax.fruittransactionhandler;

import core.basesyntax.fruittransactionhandler.storage.HashMapWithQuantities;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        HashMapWithQuantities.hashMapToReport.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
