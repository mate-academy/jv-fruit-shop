package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.storage.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.storage.stream()
                .filter(s -> s.getFruitName().equals(fruitName))
                .findFirst()
                .get();
    }

    @Override
    public void changeFruitCountInStorage(int newCount, String fruitName) {
        get(fruitName).setFruitCountInStorage(newCount);
    }

    @Override
    public int getCurrentCountFruitsInStorage(String fruitName) {
        return get(fruitName).getFruitCountInStorage();
    }

    @Override
    public String getAllDataFromDB() {
        return Storage.storage.toString();
    }
}
