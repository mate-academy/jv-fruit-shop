package core.basesyntax.service;

import core.basesyntax.model.FruitItem;

public class FruitItemServiceImpl implements FruitItemService {

    @Override
    public FruitItem create(String fruitName, int quantity) {
        return new FruitItem(fruitName, quantity);
    }
}
