package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.FruitTransactionException;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction) {
        int fruitAmountInStorage = getFruitAmountInStorage(transaction.getFruitName());
        int fruitAmountInTransaction = transaction.getAmount();
        if (fruitAmountInStorage < fruitAmountInTransaction) {
            throw new FruitTransactionException(
                    "Can't execute the subtraction operation. Fruit amount of "
                            + transaction.getFruitName() + " is " + fruitAmountInStorage
                            + ", but subtraction amount is " + fruitAmountInTransaction);
        }
        Storage.STORAGE.replace(transaction.getFruitName(),
                fruitAmountInStorage - fruitAmountInTransaction);
    }

    private Integer getFruitAmountInStorage(String fruitName) {
        Integer fruitAmountInStorage = Storage.STORAGE.get(fruitName);
        return fruitAmountInStorage != null ? fruitAmountInStorage : 0;
    }
}
