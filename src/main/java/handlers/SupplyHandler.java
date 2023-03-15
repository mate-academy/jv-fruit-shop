package handlers;

import db.Storage;
import model.FruitTransaction;

public class SupplyHandler implements OperationTypeHandler {

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        String key = fruitTransaction.getFruit();
        int value = fruitTransaction.getQuantity();
        Storage.storage.put(key, Storage.storage.get(key) + value);
    }
}
