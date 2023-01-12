package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitCalculatorService;

public class PurchaseImpl implements FruitCalculatorService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return startAmount - amountToOperate;
    }
}
