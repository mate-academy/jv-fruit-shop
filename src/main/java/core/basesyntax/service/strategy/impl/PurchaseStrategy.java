package core.basesyntax.service.strategy.impl;

import core.basesyntax.service.strategy.OperationStrategy;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public int execute(int balanceValue, int valueToChangeBalance) {
        if (balanceValue < valueToChangeBalance) {
            throw new RuntimeException("Not enough fruit for purchase, balance can't be negative");
        }
        return balanceValue - valueToChangeBalance;
    }
}
