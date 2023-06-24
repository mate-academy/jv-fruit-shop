package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public void updateAmount(FruitTransaction fruitTransaction) {
        String currentFruit = fruitTransaction.getFruit();
        int currentAmount = Storage.fruitStorage.getOrDefault(currentFruit, 0);
        int transactionAmount = fruitTransaction.getQuantity();
        int updatedAmount = currentAmount + transactionAmount;
        Storage.fruitStorage.put(currentFruit, updatedAmount);
    }
}

