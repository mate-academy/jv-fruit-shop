package service.operation;

import db.Storage;
import model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void getOperation(FruitTransaction transaction) {
        int currentFruitQuantity = Storage.fruits.get(transaction.getFruitName());
        int transactionFruitQuantity = transaction.getQuantity();
        if (transactionFruitQuantity > 0) {
            Storage.fruits.put(transaction.getFruitName(),
                    currentFruitQuantity + transactionFruitQuantity);
        } else {
            throw new RuntimeException("You can't supply "
                    + transaction.getFruitName() + " in quantity"
                    + transactionFruitQuantity + " to the Fruit shop");
        }
    }
}
