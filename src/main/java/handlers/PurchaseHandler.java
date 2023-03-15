package handlers;

import db.Storage;
import model.FruitTransaction;

public class PurchaseHandler implements OperationTypeHandler {

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        String key = fruitTransaction.getFruit();
        int value = fruitTransaction.getQuantity();
        Integer currentQuantity = Storage.storage.get(key);
        if (currentQuantity == null) {
            throw new RuntimeException("Fruit " + key + " not found in storage");
        }
        if (currentQuantity < value) {
            throw new RuntimeException("Can't purchase " + value + " " + key
                    + "! Only " + currentQuantity + " on the balance");
        } else {
            Storage.storage.put(key, currentQuantity - value);
        }
    }
}
