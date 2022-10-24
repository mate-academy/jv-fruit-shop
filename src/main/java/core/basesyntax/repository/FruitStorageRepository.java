package core.basesyntax.repository;

import core.basesyntax.model.Fruit;
import java.time.LocalDate;
import java.util.Map;

public interface FruitStorageRepository {
    boolean add(Map<Fruit, Integer> validMap);

    Map<Fruit, Integer> get(LocalDate date);
}
