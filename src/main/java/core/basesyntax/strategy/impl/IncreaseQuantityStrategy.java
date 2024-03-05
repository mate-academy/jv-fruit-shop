package java.core.basesyntax.strategy.impl;

import java.core.basesyntax.dao.FruitDao;
import java.core.basesyntax.model.FruitTransaction;
import java.core.basesyntax.strategy.FruitOperationStrategy;

public class IncreaseQuantityStrategy implements FruitOperationStrategy {
    private final FruitDao fruitDao;

    public IncreaseQuantityStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        String fruitName = transaction.getFruitName();
        int oldQuantity = fruitDao.getQuantityByFruitName(fruitName);
        int increase = transaction.getQuantity();
        int newQuantity = oldQuantity + increase;
        fruitDao.addFruit(fruitName, newQuantity);
    }
}
