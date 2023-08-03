package core.basesyntax.service.transaction.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.InvalidDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.TransactionHandler;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void executeTransaction(FruitTransaction transaction) {
        if (Storage.get(transaction.getFruit()) < transaction.getQuantity()) {
            throw new InvalidDataException("The amount of purchase is too big! "
                    + "Purchase amount is " + transaction.getQuantity() + ", but shop has only "
                    + Storage.get(transaction.getFruit()) + " "
                    + transaction.getFruit().name().toLowerCase());
        }
        Integer oldQuantity = Storage.get(transaction.getFruit());
        Integer newQuantity = oldQuantity - transaction.getQuantity();;
        Storage.updatePair(transaction.getFruit(), newQuantity);
    }
}
