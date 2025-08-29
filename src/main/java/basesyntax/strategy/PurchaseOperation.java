package basesyntax.strategy;

import basesyntax.common.FruitTransaction;
import basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        validateTransaction(transaction);
        if (transaction.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than 0: "
                    + transaction.getQuantity());
        }
        int currentQuantity = Storage.get(transaction.getFruit());
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough quantity to purchase '"
                    + transaction.getFruit()
                    + "'. In stock: " + currentQuantity + ", requested: "
                    + transaction.getQuantity());
        }
        Storage.subtract(transaction.getFruit(), transaction.getQuantity());
    }

    private void validateTransaction(FruitTransaction transaction) {
        if (transaction == null || transaction.getFruit() == null
                || transaction.getFruit().isBlank()) {
            throw new RuntimeException("Invalid transaction: "
                    + "Fruit name cannot be null or empty.");
        }
    }
}
