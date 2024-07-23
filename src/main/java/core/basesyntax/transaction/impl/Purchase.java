package core.basesyntax.transaction.impl;

import core.basesyntax.transaction.HandlerOperation;

public class Purchase implements HandlerOperation {
    @Override
    public int perform(int balance, int quantity) {
        if (balance < quantity) {
            throw new RuntimeException("Not enough money! " + balance);
        }
        return balance - quantity;
    }
}
