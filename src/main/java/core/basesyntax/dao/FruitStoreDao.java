package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Optional;

public interface FruitStoreDao {
    void addFruit(Fruit fruit, int newQuantity);

    Optional<Integer> getFruitQuantity(Fruit fruit);

    Map<Fruit, Integer> getAllFruits();
}
