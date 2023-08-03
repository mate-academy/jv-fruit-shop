package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.IllegalQuantityException;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int returnQuantity = fruitTransaction.getQuantity();
        int currentQuantity = Storage.fruitStorage.get(fruitName);

        if (returnQuantity < 0) {
            throw new IllegalQuantityException("Transaction \"return\" can`t be negative value");
        }

        Storage.fruitStorage.put(fruitName, currentQuantity + returnQuantity);

    }
}
