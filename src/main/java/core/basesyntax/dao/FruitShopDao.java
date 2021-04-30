package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitShopDao {
    void add(Fruit fruit, int quantity);

    int getBalance(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
