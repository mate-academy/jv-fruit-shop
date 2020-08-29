package core.basesyntax.service;

import static java.util.stream.Collectors.toList;

import core.basesyntax.model.Fruit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitServiceImpl implements FruitService {

    private final List<Fruit> storage = new ArrayList<>();

    @Override
    public boolean add(Fruit fruit) {
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit cannot be null.");
        }
        return storage.add(fruit);
    }

    @Override
    public void sell(String fruitName, LocalDate expirationDate, int amount) {
        List<Fruit> available = storage.stream()
                .filter(f -> f.getName().equals(fruitName))
                .filter(f -> greaterOrEqual(f.getExpirationDate(), expirationDate))
                .limit(amount)
                .collect(toList());

        if (available.size() < amount) {
            throw new IllegalStateException(String.format("Not enough Fruits: %s", fruitName));
        }

        available.forEach(storage::remove);
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(storage);
    }

    private boolean greaterOrEqual(LocalDate date1, LocalDate date2) {
        return date1.isEqual(date2) || date1.isAfter(date2);
    }
}
