package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;

public class Balance extends Operation {

    @Override
    public Integer operate(String fruitName, String value) {
        Fruit fruit = fruitList.getFruitByName(fruitName);
        int fruitsQuantity = Integer.parseInt(value);
        fruit.setQuantity(fruitsQuantity);
        return storageDao.put(fruit, fruitsQuantity);
    }
}
