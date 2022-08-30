package core.strategy;

import core.model.Fruit;
import core.storage.DataBase;

public interface FruitStrategy {
    void execute(DataBase dataBase, Fruit fruit, Integer quantity);
}
