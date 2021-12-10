package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    Map<Fruit, Integer> getBalance();

    Integer getAmount(Fruit fruit);

    void update(Fruit fruit, Integer amount);
}
