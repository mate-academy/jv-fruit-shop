package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceStrategy implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitDao.addFruit(transaction.fruitName(), transaction.quantity());
    }
}
