package service.operations;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction) {
        Integer qtyInStorage = Storage.fruits.get(transaction.getFruit());
        Integer quantityInTransaction = transaction.getQuantity();
        Integer newQty = qtyInStorage + quantityInTransaction;
        Storage.fruits.put(transaction.getFruit(), newQty);
    }
}
