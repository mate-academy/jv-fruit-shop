package strategy.impl;

import dao.FruitDao;
import model.Fruit;
import strategy.OperationHandler;

public class AddOperationImpl implements OperationHandler {
    private FruitDao fruitDao;

    public AddOperationImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String name, int quantity) {
        Fruit fruit = fruitDao.get(name);
        int newQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(newQuantity);
    }
}

