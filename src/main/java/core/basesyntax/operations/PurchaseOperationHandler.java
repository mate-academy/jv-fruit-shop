package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.PurchaseException;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int MIN_QUANTITY_LEVEL = 0;
    @Override
    public void changeFruitQuantity(String fruit, int quantity) {
        if (Storage.reportData.get(fruit) == null) {
            throw new PurchaseException("Can't sale \"" + fruit + "\" because there are no such fruit in storage");
        }
        int newQuantity = Storage.reportData.get(fruit) - quantity;
        if (newQuantity < MIN_QUANTITY_LEVEL) {
            throw new PurchaseException("Can't sale " + quantity + " of "
                    + fruit + ", there are only "
                    + Storage.reportData.get(fruit) + " left");
        }
        Storage.reportData.put(fruit, newQuantity);
    }
}