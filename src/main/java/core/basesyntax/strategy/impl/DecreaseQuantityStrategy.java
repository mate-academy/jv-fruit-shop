package java.core.basesyntax.strategy.impl;

import java.core.basesyntax.dao.FruitDao;
import java.core.basesyntax.model.FruitTransaction;
import java.core.basesyntax.strategy.FruitOperationStrategy;

public class DecreaseQuantityStrategy implements FruitOperationStrategy {
    private final FruitDao fruitDao;

    public DecreaseQuantityStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        String fruitName = transaction.getFruitName();
        int oldQuantity = fruitDao.getQuantityByFruitName(fruitName);
        int decrease = transaction.getQuantity();
        int newQuantity = oldQuantity - decrease;
        if (newQuantity < 0) {
            throw new RuntimeException("Quantity (" + newQuantity + ") < 0.");
        }
        fruitDao.addFruit(fruitName, newQuantity);
    }
}
