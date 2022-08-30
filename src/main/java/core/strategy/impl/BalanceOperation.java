package core.strategy.impl;

import core.model.Fruit;
import core.storage.DataBase;
import core.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public void execute(DataBase dataBase, Fruit fruit, Integer quantity) {
        dataBase.add(fruit, quantity);
    }
}
