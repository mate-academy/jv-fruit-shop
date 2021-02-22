package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.listOfRecords.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.listOfRecords.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst().get();
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.listOfRecords;
    }

    @Override
    public void update(Fruit newFruit) {
        if (Storage.listOfRecords.size() == 0) {
            add(newFruit);
            return;
        }
        Fruit fruitFromStorage = null;
        for (Fruit fruit : Storage.listOfRecords) {
            if (fruit.getName().equals(newFruit.getName())) {
                fruitFromStorage = fruit;
                Storage.listOfRecords.remove(fruitFromStorage);
                add(newFruit);
                return;
            }
        }
        add(newFruit);
    }
}
