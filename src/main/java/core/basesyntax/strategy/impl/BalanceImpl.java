package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitService;

public class BalanceImpl implements FruitService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return amountToOperate;
    }
}
