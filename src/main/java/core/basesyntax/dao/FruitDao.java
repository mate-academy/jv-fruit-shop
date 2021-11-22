package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.math.BigDecimal;
import java.util.Map;

public interface FruitDao {
    BigDecimal getBalance(Fruit.Type type);

    BigDecimal add(Fruit.Type type, BigDecimal amount);

    Map<Fruit.Type, BigDecimal> getStorage();
}
