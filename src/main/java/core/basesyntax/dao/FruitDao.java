package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitDao {
    void add(Map<String, Integer> fruits);

    Map<String, Integer> getAll();
}
