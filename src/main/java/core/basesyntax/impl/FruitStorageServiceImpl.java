package core.basesyntax.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.repository.FruitStorageRepository;
import core.basesyntax.repository.FruitStorageRepositoryImpl;
import java.time.LocalDate;
import java.util.Map;

public class FruitStorageServiceImpl {
    private final FruitStorageRepository repository;

    public FruitStorageServiceImpl() {
        this.repository = new FruitStorageRepositoryImpl();
    }

    public void addToStorage(Map<Fruit, Integer> validMap) {
        repository.add(validMap);
    }

    public Map<Fruit, Integer> getFromStorage(LocalDate date) {
        return repository.get(date);
    }
}
