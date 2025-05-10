package core.basesyntax.service;

public class SupplyOperation implements OperationHandler {
    private final Storage storage;

    public SupplyOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        storage.addFruit(fruit, quantity);
    }
}
