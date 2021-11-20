package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;

public class Return extends Operation {

    @Override
    public Integer operate(String fruitName, String value) {
        Fruit fruit = fruitList.getFruitByName(fruitName);
        int fruitsQuantity = Integer.parseInt(value);
        int currentQuantity = storageDao.getCurrentQuantity(fruit);
        fruit.setQuantity(fruitsQuantity + currentQuantity);
        return storageDao.update(fruit, fruitsQuantity + currentQuantity);
    }
}
