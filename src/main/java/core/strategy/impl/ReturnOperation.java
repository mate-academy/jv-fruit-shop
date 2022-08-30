package core.strategy.impl;

import core.model.Fruit;
import core.storage.DataBase;
import core.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void execute(DataBase dataBase, Fruit fruit, Integer quantity) {
        dataBase.append(fruit, quantity);
    }
}
