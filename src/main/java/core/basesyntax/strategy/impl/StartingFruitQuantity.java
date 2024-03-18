package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitItem;
import core.basesyntax.strategy.FruitQuantityChange;

import java.util.HashMap;

public class StartingFruitQuantity implements FruitQuantityChange {
    @Override
    public HashMap<String, Integer> changeFruitQuantity(FruitItem fruit) {
        return null;
    }
}
