package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationHandler {
    private final Storage storage;

    public PurchaseHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Purchase quantity cannot be negative");
        }
        Integer current = storage.get(fruit);
        int currentQty = (current == null) ? 0 : current;
        if (currentQty < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in storage");
        }
        storage.add(fruit, currentQty - quantity);
    }
}
