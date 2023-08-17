package core.basesyntax.dao;

import java.math.BigDecimal;
import java.util.Map;

public interface FruitDao {
    void add(String name, BigDecimal quantity);

    Map.Entry<String, BigDecimal> get(String fruitName);

    void update(String fruitName, BigDecimal quantity);

    Map<String, BigDecimal> getAll();
}
