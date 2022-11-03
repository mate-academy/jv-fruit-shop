package myfirstproject.strategy;

import myfirstproject.model.Fruit;

public class ReturnOperation implements OperationHandler {
    @Override
    public void changeValue(Fruit fruit, int value) {
        FRUIT_DAO.saveFruit(fruit, FRUIT_DAO.getQuantity(fruit) + value);
    }
}
