package core.basesyntax.infratructure.persistence;

import core.basesyntax.model.Fruit;

public interface FruitRepository {
    void createFruit(Fruit fruit);
    void updateFruit(String fruitName, int amount);
    void deleteFruit(String fruitName);
    Fruit getFruit(String fruitName);
}
