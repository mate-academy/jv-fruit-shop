package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDao implements IFruitDao {
    @Override
    public void add(Fruit fruit) {
        if (isFruitExist(fruit.getName())) {
            update(fruit);
        } else {
            Storage.fruits.add(fruit);
        }
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitOld = get(fruit.getName());
        fruitOld.setQuantity(fruit.getQuantity());
    }

    @Override
    public Fruit get(String name) {
        return Storage.fruits
                .stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("This type of fruit does not exist"));
    }

    @Override
    public boolean isFruitExist(String name) {
        return Storage.fruits.stream().anyMatch(fruit -> fruit.getName().equals(name));
    }

    @Override
    public Fruit getByIndex(int index) {
        if (index >= getSize()) {
            throw new IndexOutOfBoundsException();
        }
        return Storage.fruits.get(index);
    }

    @Override
    public int getSize() {
        return Storage.fruits.size();
    }
}
