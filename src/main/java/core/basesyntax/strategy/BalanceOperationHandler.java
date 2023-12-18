package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public BalanceOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void performOperation(FruitTransaction transaction) {
        int currentBalance = this.fruitStorage.getFruitInventory()
                .getOrDefault(transaction.getFruit(), 0);
        this.fruitStorage.addFruit(transaction.getFruit(), transaction.getQuantity());

        System.out.println("Processed Balance Operation for "
                + transaction.getFruit()
                + ". Current Balance: "
                + currentBalance
                + ". Added: "
                + transaction.getQuantity());
    }
}

