package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.strategy.ActivitiesShop;

public class BalanceActivitiesShop implements ActivitiesShop {

    @Override
    public void calculate(FruitOperation inputFruit) {
        Storage.fruits.put(new Fruit(inputFruit.getFruit().getName()), inputFruit.getQuantity());
    }
}
