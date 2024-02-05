package core.basesyntax.service.strategy.impl;

import core.basesyntax.service.strategy.OperationStrategy;

public class SupplyStrategy implements OperationStrategy {
    @Override
    public int execute(int balanceValue, int valueToChangeBalance) {
        return balanceValue + valueToChangeBalance;
    }
}
