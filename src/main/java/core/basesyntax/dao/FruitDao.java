package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {
    void addFruit(Fruit fruit);

    Fruit get(String fruitName);

    List<String> getAll();

    void addAmount(Fruit fruit);

    void subAmount(Fruit fruit);
}
