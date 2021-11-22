package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;

public class Return extends Operation {

    @Override
    public boolean operate(String fruitName, String value) {
        Fruit fruit = fruitList.getFruitByName(fruitName);
        int fruitsQuantity = Integer.parseInt(value);
        int currentQuantity = fruit.getQuantity();
        fruit.setQuantity(fruitsQuantity + currentQuantity);
        return true;
    }
}
