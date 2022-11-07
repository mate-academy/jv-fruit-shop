package core.basesyntax.strategy.operation.impl;

import core.basesyntax.strategy.operation.OperationHandler;

public class ReturnOperationImpl implements OperationHandler {
    @Override
    public void applyOperation(String fruitName, int value) {
        int oldVale = getBalanceFromFruitName(fruitName);
        int newValue = oldVale + value;
        putNewBalanceToFruit(fruitName, newValue);
    }
}
