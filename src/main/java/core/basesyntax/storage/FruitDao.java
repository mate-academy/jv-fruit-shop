package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface FruitDao {
    Set<Map.Entry<Fruit, Integer>> getEntries();

    int getAmount(Fruit fruit);

    void updateBalance(Fruit fruit, int amount);

    void addToAmount(Fruit fruit, int value);
}
