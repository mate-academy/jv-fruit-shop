package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitRecordsDao {
    void save(Fruit fruit, Integer quantity);

    Map<Fruit, Integer> getAll();

    int getFruitAmountFromStorage(Fruit fruit);
}
