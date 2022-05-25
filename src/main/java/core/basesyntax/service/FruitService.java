package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitService {
    void update(String fruitName, Integer amount);

    Integer getQuantity(String fruitName);

    List<Fruit> getAll();
}
