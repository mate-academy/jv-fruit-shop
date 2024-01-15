package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitOperationStrategy;

public class DecreaseQuantityStrategy implements FruitOperationStrategy {
    private final FruitDao fruitDao;

    public DecreaseQuantityStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        Fruit fruit = fruitDao.findByFruitName(transaction.getFruit().getFruitName());
        int decrease = transaction.getFruit().getQuantity();
        int newQuantity = fruit.getQuantity() - decrease;
        if (newQuantity < 0) {
            throw new RuntimeException("Quantity (" + newQuantity + ") < 0.");
        }
        fruit.setQuantity(newQuantity);
    }
}
