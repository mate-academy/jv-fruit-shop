package core.basesyntax.service;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (Storage.storage.put(transaction.getFruit(), transaction.getQuantity()) == null) {
            Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
        } else {
            Storage.storage.replace(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
