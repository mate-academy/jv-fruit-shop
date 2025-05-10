package core.basesyntax.service;

public class BalanceOperation implements OperationHandler {
    private final Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(String fruit, int quantity) {
        storage.addFruit(fruit, quantity);
    }
}
