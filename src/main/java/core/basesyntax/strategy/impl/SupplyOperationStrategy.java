package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationStrategy implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        if (quantity < 0) {
            throw new RuntimeException("Supply value can`t be negative");
        }
        if (fruit == null) {
            new BalanceOperationStrategy(fruitDao).execute(fruitName, quantity);
        }
        int newQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(newQuantity);
        fruitDao.update(fruit);
    }
}
