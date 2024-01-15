package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitOperationStrategy;

public class IncreaseQuantityStrategy implements FruitOperationStrategy {
    private final FruitDao fruitDao;

    public IncreaseQuantityStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        Fruit fruit = fruitDao.findByFruitName(transaction.getFruit().getFruitName());
        int increase = transaction.getFruit().getQuantity();
        int newQuantity = fruit.getQuantity() + increase;
        fruit.setQuantity(newQuantity);
    }
}
