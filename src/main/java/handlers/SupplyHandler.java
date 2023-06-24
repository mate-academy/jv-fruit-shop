package handlers;

import db.Storage;
import model.FruitTransaction;

public class SupplyHandler implements OperationTypeHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String key = fruitTransaction.getFruit();
        int value = fruitTransaction.getQuantity();
        if (value < 0) {
            throw new RuntimeException("Wrong input: [" + value + "]. Can't be negative!");
        }
        Storage.storage.put(key, Storage.storage.get(key) + value);
    }
}
