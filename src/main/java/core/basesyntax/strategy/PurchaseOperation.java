package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements Operation {
    private final FruitStorage fruitStorage;

    public PurchaseOperation(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void performOperation(FruitTransaction transaction, FruitStorage fruitStorage) {
        int currentInventory = fruitStorage.getFruitInventory()
                .getOrDefault(transaction.getFruit(), 0);

        if (currentInventory >= transaction.getQuantity()) {
            fruitStorage.substractFruit(transaction.getFruit(), transaction.getQuantity());

            System.out.println("Processed Purchase Operation for " + transaction.getFruit()
                    + ". Current Inventory: "
                    + currentInventory
                    + ". Purchased: "
                    + transaction.getQuantity());
        } else {
            System.out.println("Not enough "
                    + transaction.getFruit()
                    + " in the inventory. Skipping purchase.");
        }
    }
}
