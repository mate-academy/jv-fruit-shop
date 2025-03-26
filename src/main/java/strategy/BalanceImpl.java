package strategy;

import db.StorageService;

public class BalanceImpl implements Operation {

    @Override
    public void execute(StorageService storage, String fruit, int quantity) {
        storage.put(fruit, quantity);
    }
}
