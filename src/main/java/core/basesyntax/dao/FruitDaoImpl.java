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
        return null;
    }

    @Override
    public void add(String fruitName, int quantity) {
        Storage.fruits.add(new Fruit.FruitBuilder()
                .setName(fruitName).setQuantity(quantity).build());
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
