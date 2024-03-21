package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;

public class ReturnHandler implements ActivityHandler {
    private final Storage storage;

    public ReturnHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void operate(String fruit, int quantity) {
        int newQuantity = storage.getData().get(fruit) + quantity;
        storage.getData().put(fruit, newQuantity);
    }
}
