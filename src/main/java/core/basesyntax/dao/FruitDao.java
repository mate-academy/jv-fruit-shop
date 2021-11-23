package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    Integer getBalance(Fruit fruit);

    Integer add(Fruit fruit, Integer amount);

    Map<Fruit, Integer> getStorage();
}
