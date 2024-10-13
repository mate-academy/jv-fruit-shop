package strategy;

import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int getQuantityToCalculate(FruitTransaction fruitTransaction) {
        return -fruitTransaction.getQuantity();
    }
}
