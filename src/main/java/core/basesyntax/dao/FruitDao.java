package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {
    void addFruit(Fruit fruit);

    Fruit getByName(String fruitName);

    List<String> getAll();

    void addAmount(Fruit fruit);

    void subtractAmount(Fruit fruit);
}
