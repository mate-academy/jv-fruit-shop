package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.CheckFruitExist;

public class CheckFruitExistImpl implements CheckFruitExist {
    @Override
    public void check(String fruit) {
        if (!FruitStorage.storage.containsKey(fruit)) {
            throw new RuntimeException("Database does not contain: " + fruit);
        }
    }
}
