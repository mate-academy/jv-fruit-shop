package core.shop.handler;

import core.shop.db.Storage;
import core.shop.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void operation(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruitName(), transaction.getQuantity());
    }
}
