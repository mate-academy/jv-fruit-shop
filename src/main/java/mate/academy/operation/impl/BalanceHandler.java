package mate.academy.operation.impl;

import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.Fruit;
import mate.academy.operation.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void getHandler(Fruit fruit) {
        new FruitDaoImpl().add(fruit);
    }
}
