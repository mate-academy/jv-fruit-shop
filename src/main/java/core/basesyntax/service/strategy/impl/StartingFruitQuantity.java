package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitItem;
import core.basesyntax.service.strategy.FruitQuantityChange;

import java.util.HashMap;

public class StartingFruitQuantity implements FruitQuantityChange {
    @Override
    public HashMap<String, Integer> changeFruitQuantity(FruitItem fruit) {
        StorageDaoImpl newFruit = new StorageDaoImpl();
        return newFruit.add(fruit);
    }
}
