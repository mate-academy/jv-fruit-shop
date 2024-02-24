package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Optional;

public interface FruitDao {
    Optional<Fruit> get(String fruitName);

    boolean update(String fruitName, int amount);

    boolean writeReportToFile(String fileName);
}
