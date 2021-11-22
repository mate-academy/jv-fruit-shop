package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Fruit add(Fruit fruit) {
        Storage.storage.add(fruit);
        return fruit;
    }

    @Override
    public Optional<Fruit> get(String fruitName) {
        for (Fruit fruit : Storage.storage) {
            if (fruit.getFruitName().equals(fruitName)) {
                return Optional.of(fruit);
            }
        }
        return Optional.empty();
    }

    @Override
    public void changeFruitCountInStorage(int newCount, String fruitName) {
        get(fruitName).ifPresent(f -> f.setFruitCountInStorage(newCount));
    }

    @Override
    public int getCurrentCountFruitsInStorage(String fruitName) {
        return get(fruitName).get().getFruitCountInStorage();
    }

    @Override
    public String getAllDataFromDB() {
        return Storage.storage.toString();
    }
}
