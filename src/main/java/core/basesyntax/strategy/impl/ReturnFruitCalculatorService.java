package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitCalculatorService;

public class ReturnFruitCalculatorService implements FruitCalculatorService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return startAmount + amountToOperate;
    }
}
