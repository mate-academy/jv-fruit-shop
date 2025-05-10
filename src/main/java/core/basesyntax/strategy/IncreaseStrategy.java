package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class IncreaseStrategy implements OperationHandler {
    private final FruitDao fruitDao;

    public IncreaseStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitDao.getFruits().compute(transaction.fruitName(), (key, oldQuantity) ->
                oldQuantity == null
                        ? transaction.quantity()
                        : oldQuantity + transaction.quantity());
    }
}
