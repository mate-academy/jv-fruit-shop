package service.operation;

import db.Storage;

public class ReturnHandler implements Handler {
    @Override
    public void calc(String fruit, int quantity) {
        Storage.storage.put(fruit, (Storage.storage.get(fruit) + quantity));
    }
}
