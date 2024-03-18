package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class IncreaseStrategy implements Strategy {
    private final FruitDao fruitDao;

    public IncreaseStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitDao.getFruits().compute(transaction.fruit(), (key, oldQuantity) ->
                oldQuantity == null
                        ? transaction.quantity()
                        : oldQuantity + transaction.quantity());
    }
}
