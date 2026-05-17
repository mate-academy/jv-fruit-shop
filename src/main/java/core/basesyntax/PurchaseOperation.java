package core.basesyntax;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        int currentQuantity = storage.getFruits().getOrDefault(transaction.getFruit(), 0);
        storage.getFruits().put(transaction.getFruit(),
                currentQuantity - transaction.getQuantity());
    }
}
