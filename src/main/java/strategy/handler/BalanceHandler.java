package strategy.handler;

import model.FruitTransaction;

public class BalanceHandler implements OperationHandler {

    @Override
    public FruitTransaction getOperationResult(FruitTransaction fruitTransaction) {
        return fruitTransaction;
    }
}
