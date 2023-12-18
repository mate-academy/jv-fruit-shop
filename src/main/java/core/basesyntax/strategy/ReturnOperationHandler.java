package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public ReturnOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void performOperation(FruitTransaction transaction) {
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

