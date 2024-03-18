package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitItem;

import java.util.HashMap;

public class ResupplyFruitQuantity {
    @Override
    public HashMap<String, Integer> changeFruitQuantity(FruitItem fruit) {
        Storage.fruitsQuantity.get(fruit.getFruitName())
    }
}
