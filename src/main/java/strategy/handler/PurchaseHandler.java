package strategy.handler;

import model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public FruitTransaction getOperationResult(FruitTransaction fruitTransaction) {
        int fruitQuantityFromDb = fruitTransaction.getQuantity();
        fruitTransaction.setQuantity(-fruitQuantityFromDb);
        return fruitTransaction;
    }
}
