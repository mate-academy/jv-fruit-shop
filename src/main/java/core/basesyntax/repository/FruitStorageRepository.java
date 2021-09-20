package core.basesyntax.repository;

import java.time.LocalDate;
import java.util.Map;

public interface FruitStorageRepository {
    boolean add(Map<String, Integer> validMap);

    Map<String, Integer> get(LocalDate date);
}
