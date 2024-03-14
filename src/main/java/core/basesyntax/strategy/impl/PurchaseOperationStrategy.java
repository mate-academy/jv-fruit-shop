package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationStrategy implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        int newQuantity = fruit.getQuantity() - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("You cannot sell more than you have in the store");
        }
        fruit.setQuantity(newQuantity);
        fruit.setSold(fruit.getSold() + quantity);
        fruitDao.update(fruit);
    }
}
