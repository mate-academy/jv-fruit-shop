package core.basesyntax.shop.service;

import core.basesyntax.shop.model.Fruit;

public interface FruitShopService {
    public boolean apply(Fruit fruit, Integer quantity);
}
