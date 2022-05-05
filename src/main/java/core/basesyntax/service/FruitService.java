package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitService {
    public Integer getQuantity(String fruitName);

    public void update(String fruitName, Integer amount);

    public List<Fruit> getAll();
}
