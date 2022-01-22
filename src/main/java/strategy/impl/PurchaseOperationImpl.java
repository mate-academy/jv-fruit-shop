package strategy.impl;

import dao.FruitDao;
import model.Fruit;
import strategy.OperationHandler;

public class PurchaseOperationImpl implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String name, int quantity) {
        Fruit fruit = fruitDao.get(name);
        if (quantity <= fruit.getQuantity()) {
            int newQuantity = fruit.getQuantity() - quantity;
            fruit.setQuantity(newQuantity);
        } else {
            throw new RuntimeException("Not enough fruits to buy!!");
        }
    }
}
