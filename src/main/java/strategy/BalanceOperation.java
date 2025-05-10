package strategy;

import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public int getQuantityToCalculate(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity();
    }
}
