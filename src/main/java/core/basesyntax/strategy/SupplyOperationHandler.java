package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void getOperationHandler(FruitTransaction transaction) {
        Integer currentQuantity = Storage.storageFruits.get(transaction.getFruit());
        Storage.storageFruits.put(transaction.getFruit(),
                currentQuantity + transaction.getQuantity());
    }
}
