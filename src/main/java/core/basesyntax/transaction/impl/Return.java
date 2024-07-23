package core.basesyntax.transaction.impl;

import core.basesyntax.transaction.HandlerOperation;

public class Return implements HandlerOperation {
    @Override
    public int perform(int balance, int quantity) {
        return balance + quantity;
    }
}
