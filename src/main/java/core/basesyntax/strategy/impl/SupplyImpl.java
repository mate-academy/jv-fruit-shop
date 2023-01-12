package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitService;

public class SupplyImpl implements FruitService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return startAmount + amountToOperate;
    }
}
