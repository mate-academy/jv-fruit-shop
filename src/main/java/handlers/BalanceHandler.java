package handlers;

import core.basesyntax.FruitInventory;
import core.basesyntax.FruitTransaction;

public class BalanceHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitInventory inventory, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        inventory.addToInventory(fruit, quantity);
    }
}
