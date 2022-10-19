package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.HandlerOperation;

public class HandlerOperationImplPurchase implements HandlerOperation {
    @Override
    public int apply(int balance, int count) {
        return balance - count;
    }
}
