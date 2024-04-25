package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {
    Fruit getFruit(String line);

    void addFruit(String line);

    void updateAmount(String line);

    List<Fruit> getFruitList();
}
