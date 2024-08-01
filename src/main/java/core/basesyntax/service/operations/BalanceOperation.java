package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        storageFruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
