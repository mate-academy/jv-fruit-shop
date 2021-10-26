package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Fruit get(String fruitName) {
        for (Fruit fruitFromStorage: Storage.fruits) {
            if (fruitFromStorage.getName().equals(fruitName)) {
                return fruitFromStorage;
            }
        }
        if (!(fruitName.equals("apple") || fruitName.equals("banana"))) {
            throw new RuntimeException("Invalid input value " + fruitName);
        }
        add(fruitName);
        return get(fruitName);
    }

    @Override
    public void add(String fruitName) {
        Storage.fruits.add(new Fruit.FruitBuilder().setName(fruitName).build());
    }

    @Override
    public void update(String fruitName,int quantity) {
        for (int i = 0; i < Storage.fruits.size(); i++) {
            if (Storage.fruits.get(i).getName().equals(fruitName)) {
                Storage.fruits.get(i).setQuantity(quantity);
            }
        }
    }
}
