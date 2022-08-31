package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class FruitReturnHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public FruitReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void proceed(FruitTransaction fruitTransaction) {
        fruitDao.addQuantity(new Fruit(fruitTransaction.getFruit().getFruitName()),
                fruitTransaction.getQuantity());
    }
}
