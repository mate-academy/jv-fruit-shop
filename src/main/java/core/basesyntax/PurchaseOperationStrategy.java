package core.basesyntax;

public class PurchaseOperationStrategy implements OperationStrategy {
    @Override
    public void process(FruitTransaction transaction, FruitStorage storage) {
        int availableQuantity = storage.getFruitQuantities()
                .getOrDefault(transaction.getFruit(), 0);

        if (availableQuantity >= transaction.getQuantity()) {
            storage.updateQuantity(transaction.getFruit(), -transaction.getQuantity());
        } else {
            throw new RuntimeException("Not enough quantity of "
                    + transaction.getFruit() + " for purchase");
        }
    }
}
