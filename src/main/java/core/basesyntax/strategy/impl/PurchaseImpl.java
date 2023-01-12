package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitService;

public class PurchaseImpl implements FruitService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return startAmount - amountToOperate;
    }
}
