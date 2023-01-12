package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitCalculatorService;

public class BalanceImpl implements FruitCalculatorService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return amountToOperate;
    }
}
