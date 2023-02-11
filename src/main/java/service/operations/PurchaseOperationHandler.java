package service.operations;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction) {
        Integer qtyInStorage = Storage.fruits.get(transaction.getFruit());
        Integer quantityInTransaction = transaction.getQuantity();
        if (quantityInTransaction > qtyInStorage) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " in shop storage. "
                     + "Should be at least " + transaction.getQuantity()
                    + " items. But storage has only " + qtyInStorage);
        }
        Integer newQty = qtyInStorage - quantityInTransaction;
        Storage.fruits.put(transaction.getFruit(), newQty);
    }
}
