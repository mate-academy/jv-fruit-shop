package strategy;

import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int getQuantityToAdd(FruitTransaction fruitTransaction) {
        return -fruitTransaction.getQuantity();
    }
}
