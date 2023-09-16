package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getNameOfObject();
        Integer actualAmount = Storage.storage.get(fruitName);
        int returnAmount = fruitTransaction.getAmount();
        if (actualAmount == null) {
            throw new RuntimeException("Seems you try to return non-existing product "
                    + fruitName);
        }
        Storage.storage.put(fruitName,
                actualAmount + returnAmount);
    }
}
