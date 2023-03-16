package handlers;

import db.Storage;
import model.FruitTransaction;

public class ReturnHandler implements OperationTypeHandler {

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        String key = fruitTransaction.getFruit();
        int value = fruitTransaction.getQuantity();
        if (value < 0) {
            throw new RuntimeException("Wrong input: [" + value + "]. Can't be negative!");
        } else {
            Storage.storage.put(key, Storage.storage.get(key) + value);
        }
    }
}
