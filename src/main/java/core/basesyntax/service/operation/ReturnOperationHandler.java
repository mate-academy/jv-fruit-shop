package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction) {
        Integer fruitAmountInStorage = Storage.STORAGE.get(transaction.getFruitName());
        if (fruitAmountInStorage == null) {
            Storage.STORAGE.put(transaction.getFruitName(), transaction.getAmount());
        } else {
            Storage.STORAGE.replace(transaction.getFruitName(),
                    fruitAmountInStorage + transaction.getAmount());
        }
    }
}
