package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ProductDao {
    void add(Fruit fruit, int amount);

    List<String> getAll();
}
