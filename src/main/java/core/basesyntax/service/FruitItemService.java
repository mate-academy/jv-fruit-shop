package core.basesyntax.service;

import core.basesyntax.model.FruitItem;

public interface FruitItemService {
    FruitItem create(String fruitName,int quantity);
}
