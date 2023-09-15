package dao;

import model.FruitTransaction;

public interface FruitDao {
    FruitTransaction add(FruitTransaction fruitTransaction);

    FruitTransaction get(FruitTransaction fruitTransaction);

}
