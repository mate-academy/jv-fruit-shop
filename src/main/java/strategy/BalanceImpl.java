package strategy;

import db.Storage;

public class BalanceImpl implements Operation {

    @Override
    public void execute(String fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }
}
