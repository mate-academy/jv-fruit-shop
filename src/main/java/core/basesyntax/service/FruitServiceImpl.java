package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitServiceImpl implements FruitService {
    @Override
    public Fruit getFruit(String fruitName) {
        return Storage.fruits.stream()
                .filter(a -> a.getFruit().equals(fruitName))
                .findFirst().get();
    }

    @Override
    public void addFruit(String fruit, int quantity) {
        Fruit newFruit = new Fruit(fruit, quantity);
        Storage.fruits.add(newFruit);
    }

    @Override
    public void updateFruit(Fruit fruit, int addQuantity) {
        int quantity = fruit.getQuantity() + addQuantity;
        fruit.setQuantity(quantity);
    }
}
