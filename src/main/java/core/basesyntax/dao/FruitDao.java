package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitDao {
    void add(FruitTransaction transaction);

    void addAll(List<FruitTransaction> transactions);

    Map<String, Integer> getAll();
}
