package core.basesyntax.strategy.operation;

import core.basesyntax.data.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantityToRemove = transaction.getQuantity();
        int currentQuantity = Storage.getInventory().getOrDefault(fruit, 0);
        if (quantityToRemove > currentQuantity) {
            throw new IllegalStateException("Not enough " + fruit + " in stock.");
        }
        Storage.remove(fruit, quantityToRemove);
    }
}
