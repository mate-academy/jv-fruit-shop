package core.basesyntax;

public class BalanceOperation implements OperationHandler {
    private final Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        storage.getFruits().put(transaction.getFruit(), transaction.getQuantity());
    }
}
