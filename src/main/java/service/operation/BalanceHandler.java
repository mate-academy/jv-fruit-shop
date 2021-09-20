package service.operation;

import db.Storage;

public class BalanceHandler implements Handler {

    @Override
    public void calc(String fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }
}
