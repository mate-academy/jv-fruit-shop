package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.strategy.ActivitiesShop;

public class PurchaseActivitiesShop implements ActivitiesShop {

    @Override
    public void calculate(FruitOperation inputFruit) {
        Fruit fruit = new Fruit(inputFruit.getFruit().getName());
        Integer quantityStorage = Storage.fruits.get(fruit);
        if ((quantityStorage < inputFruit.getQuantity())) {
            throw new RuntimeException("The fruits had sold");
        }
        Storage.fruits.put(fruit, quantityStorage - inputFruit.getQuantity());
    }
}
