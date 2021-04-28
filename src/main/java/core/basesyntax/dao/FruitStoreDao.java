package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitStoreDao {
    void add(Fruit fruit, int newQuantity);

    int getQuantity(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
