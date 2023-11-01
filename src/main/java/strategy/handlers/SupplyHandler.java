package strategy.handlers;

import model.FruitTransaction;
import model.FruitTransaction.OperationType;
import strategy.FruitStrategy;

public class SupplyHandler implements FruitStrategy {
    @Override
    public void addToInventoryByOperationType(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity();
    }

    @Override
    public boolean isApplicable(FruitTransaction fruitTransaction) {
        return OperationType.RETURN.equals(fruitTransaction.getOperationType());
    }
}
