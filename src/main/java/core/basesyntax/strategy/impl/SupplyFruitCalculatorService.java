package core.basesyntax.strategy.impl;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.strategy.FruitCalculatorService;

public class SupplyFruitCalculatorService implements FruitCalculatorService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        if (startAmount < 0 || amountToOperate < 0) {
            throw new FruitShopException("Amount of fruits should be grater than 0");
        }
        return startAmount + amountToOperate;
    }
}
