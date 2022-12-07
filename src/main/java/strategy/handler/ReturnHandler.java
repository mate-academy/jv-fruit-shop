package strategy.handler;

import model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public FruitTransaction getOperationResult(FruitTransaction fruitTransaction) {
        return fruitTransaction;
    }
}
