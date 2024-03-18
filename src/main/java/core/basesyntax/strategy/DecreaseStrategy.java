package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class DecreaseStrategy implements Strategy {
    private final FruitDao fruitDao;

    public DecreaseStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        int oldQuantity = fruitDao.getFruitQuantity(transaction.fruit());
        int newQuantity = oldQuantity - transaction.quantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Quality can't be less than 0!");
        }
        fruitDao.addFruit(transaction.fruit(), newQuantity);
    }
}
