package strategy.impl;

import dao.Fruit;
import dao.FruitDao;
import service.impl.FruitServiceImpl;
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

    @Override
    public void handle(FruitServiceImpl.Transaction transaction) {

    }
}

