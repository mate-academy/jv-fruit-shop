package strategy;

import db.StorageService;

public class ReturnImpl implements Operation {

    @Override
    public void execute(StorageService storage, String fruit, int quantity) {
        storage.put(fruit, storage.get(fruit) + quantity);
    }
}
