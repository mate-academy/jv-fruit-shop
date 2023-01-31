package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void updateAmount(FruitTransaction fruitTransaction) {
        String currentFruit = fruitTransaction.getFruit();
        int currentAmount = Storage.fruitStorage.getOrDefault(currentFruit, 0);
        int transactionAmount = fruitTransaction.getQuantity();
        int updatedAmount = currentAmount - transactionAmount;
        if (updatedAmount < 0) {
            throw new RuntimeException("Fruit quantity cannot be negative!");
        }
        Storage.fruitStorage.put(currentFruit, updatedAmount);
    }
}
