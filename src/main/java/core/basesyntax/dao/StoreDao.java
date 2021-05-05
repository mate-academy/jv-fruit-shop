package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StoreDao {
    void add(Fruit fruit, int newQuantity);

    int get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
