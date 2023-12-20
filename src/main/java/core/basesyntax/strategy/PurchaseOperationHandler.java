package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public PurchaseOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void performOperation(FruitTransaction transaction) {
        int currentInventory = fruitStorage.getFruitInventory()
                .getOrDefault(transaction.getFruit(), 0);

        if (currentInventory >= transaction.getQuantity()) {
            fruitStorage.substractFruit(transaction.getFruit(), transaction.getQuantity());
            int newBalance = currentInventory - transaction.getQuantity();
            System.out.println("Processed Purchase Operation for " + transaction.getFruit()
                    + ". Current Inventory: "
                    + currentInventory
                    + ". Purchased: "
                    + transaction.getQuantity());
        } else {
            throw new RuntimeException("Negative balance after purchase operation");
        }
    }
}
