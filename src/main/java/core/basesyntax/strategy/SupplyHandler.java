package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class SupplyHandler implements OperationHandler {
    private final Storage storage;

    public SupplyHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity cannot be negative");
        }
        Integer current = storage.get(fruit);
        int currentQty = (current == null) ? 0 : current;
        storage.add(fruit, currentQty + quantity);
    }
}
