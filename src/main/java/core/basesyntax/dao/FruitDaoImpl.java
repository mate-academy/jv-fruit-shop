package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addFruit(String fruit, int amount) {
        FruitStorage.fruitRepository.put(fruit, amount);
    }

    @Override
    public int get(String fruit) {
        return FruitStorage.fruitRepository.get(fruit);
    }
}
