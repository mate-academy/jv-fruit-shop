package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;

public class Purchase extends Operation {

    @Override
    public Integer operate(String fruitName, String value) {
        Fruit fruit = fruitList.getFruitByName(fruitName);
        int fruitsQuantity = Integer.parseInt(value);
        int currentQuantity = storageDao.getCurrentQuantity(fruit);
        if (currentQuantity < fruitsQuantity) {
            throw new RuntimeException("Not enough fruits to buy");
        }
        fruit.setQuantity(currentQuantity - fruitsQuantity);
        return storageDao.update(fruit, currentQuantity - fruitsQuantity);
    }
}
