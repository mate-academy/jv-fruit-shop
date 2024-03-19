package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitItem;
import core.basesyntax.service.strategy.FruitQuantityChange;

import java.util.HashMap;

public class ResupplyFruitQuantity implements FruitQuantityChange {
    @Override
    public HashMap<String, Integer> changeFruitQuantity(FruitItem fruit) {

        Storage.fruitsQuantity.get(fruit.getFruitName());
    }
}
