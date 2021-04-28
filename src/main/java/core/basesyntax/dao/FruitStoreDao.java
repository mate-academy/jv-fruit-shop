package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitStoreDao {
    void addFruit(Fruit fruit, int newQuantity);

    int getFruitQuantity(Fruit fruit);

    Map<Fruit, Integer> getAllFruits();
}
