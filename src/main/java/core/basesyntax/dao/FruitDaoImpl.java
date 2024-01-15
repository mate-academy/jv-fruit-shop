package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addFruit(Fruit fruit) {
        FruitStorage.getFruits().add(fruit);
    }

    @Override
    public Fruit findByFruitName(String fruitName) {
        return get(fruitName).orElseThrow(() -> new NoSuchElementException("Fruit with name "
                + fruitName + " not found."));
    }

    @Override
    public Set<Fruit> getAllFruits() {
        return FruitStorage.getFruits();
    }

    private Optional<Fruit> get(String fruitName) {
        return FruitStorage.getFruits().stream()
                .filter(fruit -> fruit.getFruitName().equals(fruitName))
                .findFirst();
    }
}
