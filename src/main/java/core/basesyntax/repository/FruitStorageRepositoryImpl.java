package core.basesyntax.repository;

import static core.basesyntax.db.FruitStorage.fruitStorage;

import core.basesyntax.model.Fruit;
import java.time.LocalDate;
import java.util.Map;

public class FruitStorageRepositoryImpl implements FruitStorageRepository {
    @Override
    public boolean add(Map<Fruit, Integer> validMap) {
        fruitStorage.put(LocalDate.now(), validMap);
        return true;
    }

    @Override
    public Map<Fruit, Integer> get(LocalDate date) {
        return fruitStorage.get(date);
    }
}
