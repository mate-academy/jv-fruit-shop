package core.basesyntax.shop.service;

import core.basesyntax.shop.model.Fruit;
import java.util.Map;

public interface FruitShopService {

    void balance(Fruit fruit, Integer quantity);

    void supply(Fruit fruit, Integer quantity);

    void purchase(Fruit fruit, Integer quantity);

    void returnBack(Fruit fruit, Integer quantity);

    Map<Fruit, Integer> getMap();
}
