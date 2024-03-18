package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class DecreaseStrategy implements OperationHandler {
    private final FruitDao fruitDao;

    public DecreaseStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        int oldQuantity = fruitDao.getFruitQuantity(transaction.fruitName());
        int newQuantity = oldQuantity - transaction.quantity();
        if (newQuantity < 0) {
            throw new IllegalArgumentException();
        }
        fruitDao.addFruit(transaction.fruitName(), newQuantity);
    }
}
