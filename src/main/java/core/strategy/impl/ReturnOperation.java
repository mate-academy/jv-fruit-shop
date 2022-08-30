package core.strategy.impl;

import core.model.Fruit;
import core.storage.DataBase;
import core.strategy.FruitStrategy;

public class ReturnOperation implements FruitStrategy {
    @Override
    public void execute(DataBase dataBase, Fruit fruit, Integer quantity) {
        dataBase.append(fruit, quantity);
    }
}
