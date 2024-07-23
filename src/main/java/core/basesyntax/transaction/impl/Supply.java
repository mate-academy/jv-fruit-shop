package core.basesyntax.transaction.impl;

import core.basesyntax.transaction.HandlerOperation;

public class Supply implements HandlerOperation {
    @Override
    public int perform(int balance, int quantity) {
        return balance + quantity;
    }
}
