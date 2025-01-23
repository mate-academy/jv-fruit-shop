package core.basesyntax.dao;

import core.basesyntax.models.Fruit;
import java.util.List;

public interface FruitDao {
    List<Fruit> getAll();
}
