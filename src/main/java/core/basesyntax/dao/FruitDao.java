package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitDao {
    Fruit add(String fruitName);

    Fruit get(FruitTransaction fruitTransaction);

    List<Fruit> getAll();

    void update(FruitTransaction fruitTransaction, int newAmount);
}
