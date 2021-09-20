package core.basesyntax.repository;

import static core.basesyntax.db.FruitStorage.fruitStorage;

import java.time.LocalDate;
import java.util.Map;

public class FruitStorageRepositoryImpl implements FruitStorageRepository {
    @Override
    public boolean add(Map<String, Integer> validMap) {
        fruitStorage.put(LocalDate.now(), validMap);
        return true;
    }

    @Override
    public Map<String, Integer> get(LocalDate date) {
        return fruitStorage.get(date);
    }
}
