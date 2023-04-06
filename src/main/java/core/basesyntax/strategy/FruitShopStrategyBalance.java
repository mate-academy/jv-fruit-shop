package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

import java.awt.*;

public class FruitShopStrategyBalance implements FruitShopStrategy{
    @Override
    public void calculate(String fruit, int value) {
        Storage.getFruitsStorage().put(fruit, value);
    }
}
