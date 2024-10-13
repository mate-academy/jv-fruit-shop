package strategy;

import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public int getQuantityToAdd(FruitTransaction fruitTransaction) {
        return fruitTransaction.getQuantity();
    }
}
