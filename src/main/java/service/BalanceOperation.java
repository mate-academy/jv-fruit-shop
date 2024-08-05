package service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;
import strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.setQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
