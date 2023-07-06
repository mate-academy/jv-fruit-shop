package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;

public class InputDaoImpl implements InputDao {

    @Override
    public void add(Fruit fruit) {
        FruitStorage.fruits.add(fruit);
    }

    @Override
    public String getFromStorage(String fruitName) {
        int quantity = FruitStorage.fruits.stream()
                .filter(fruit -> fruit.getFruitName().equals(fruitName))
                .mapToInt(Fruit::getFruitQuantity)
                .sum();
        return fruitName + "," + quantity;
    }
}
