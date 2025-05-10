package core.basesyntax.service;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        int currentQuantity = storage.getQuantity(fruit);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough "
                    + fruit
                    + " in storage to complete the purchase.");
        }
        storage.removeFruit(fruit, quantity);
    }
}
