package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public int handle(int balance, int count) {
        return balance + count;
    }
}
