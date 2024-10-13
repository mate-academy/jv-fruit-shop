package strategy;

import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public int getQuantityToAdd(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity();
    }
}
