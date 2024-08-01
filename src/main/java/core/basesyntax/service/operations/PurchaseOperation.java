package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        storageFruits.put(transaction.getFruit(), storageFruits
                .getOrDefault(transaction.getFruit(), 0) - transaction.getQuantity());
    }
}
