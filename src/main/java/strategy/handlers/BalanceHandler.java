package strategy.handlers;

import model.FruitTransaction;
import model.FruitTransaction.OperationType;
import strategy.FruitStrategy;

public class BalanceHandler implements FruitStrategy {
    @Override
    public void addToInventoryByOperationType(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity();
    }

    @Override
    public boolean isApplicable(FruitTransaction fruitTransaction) {
        return OperationType.BALANCE.equals(fruitTransaction.getOperationType());
    }
}
