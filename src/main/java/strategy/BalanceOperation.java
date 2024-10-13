package strategy;

import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public int getQuantityToAdd(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity();
    }
}
