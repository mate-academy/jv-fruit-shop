package core.basesyntax.fruitentry.impl;

import core.basesyntax.fruitentry.FruitEntry;
import core.basesyntax.fruitentry.FruitEntryRepository;
import core.basesyntax.fruitentry.exception.NoSuchFruitEntryException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FruitEntryRepositoryInMemoryImpl implements FruitEntryRepository {

    private final Map<String, FruitEntry> fruitEntryMap = new HashMap<>();

    @Override
    public void save(FruitEntry fruitEntry) {
        fruitEntryMap.put(fruitEntry.getFruitName(), fruitEntry);
    }

    @Override
    public Optional<FruitEntry> getByFruitName(String fruitName) {
        return Optional.ofNullable(fruitEntryMap.get(fruitName));
    }

    @Override
    public void update(FruitEntry fruitEntry) {
        if (!fruitEntryMap.containsKey(fruitEntry.getFruitName())) {
            throw new NoSuchFruitEntryException("Can't update fruit entry: no such fruit name");
        }
        fruitEntryMap.replace(fruitEntry.getFruitName(), fruitEntry);
    }

    @Override
    public List<FruitEntry> getAll() {
        return new ArrayList<>(fruitEntryMap.values());
    }
}
