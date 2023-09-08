package core.basesyntax.handler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        int amount = FruitStorage.STORAGE.getOrDefault(transaction.getFruit(), 0);
        int quantity = transaction.getQuantity();
        if (amount < quantity) {
            throw new RuntimeException(
                    getErrorMessage(transaction.getFruit(), amount, quantity)
            );
        }
        FruitStorage.STORAGE.put(transaction.getFruit(), amount - quantity);
    }

    private String getErrorMessage(String fruit, int amount, int quantity) {
        return String.format(
                "The store does not contain enough %s. "
                + "You want to purchase %d and only %d are available in stock.",
                fruit, quantity, amount);
    }
}
