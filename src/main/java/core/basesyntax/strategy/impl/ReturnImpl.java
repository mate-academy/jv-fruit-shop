package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitCalculatorService;

public class ReturnImpl implements FruitCalculatorService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return startAmount + amountToOperate;
    }
}
