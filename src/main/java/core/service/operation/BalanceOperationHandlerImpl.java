package core.service.operation;

import core.db.Storage;
import core.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler{

    @Override
    public void operation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantityFruit = transaction.getQuantity();
        if (quantityFruit < 0) {
            throw new RuntimeException("Quantity must be greater or equals 0!");
        }
        Storage.storage.put(fruitName, quantityFruit);
    }
}
