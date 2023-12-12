package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements Operation {
    private final FruitStorage fruitStorage;

    public ReturnOperation(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void performOperation(FruitTransaction transaction, FruitStorage fruitStorage) {
        int currentInventory = fruitStorage.getFruitInventory()
                .getOrDefault(transaction.getFruit(), 0);

        fruitStorage.addFruit(transaction.getFruit(), transaction.getQuantity());
        System.out.println("Processed Return Operation for "
                + transaction.getFruit()
                + ". Current Inventory: "
                + currentInventory
                + ". Returned: "
                + transaction.getQuantity());
    }
}
