package core.basesyntax;

public class PurchaseOperationHandler implements OperationHandler {
    private final Storage storage;

    public PurchaseOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        int currentQuantity = storage.getFruits().getOrDefault(transaction.getFruit(), 0);
        storage.getFruits().put(transaction.getFruit(),
                currentQuantity - transaction.getQuantity());
    }
}
