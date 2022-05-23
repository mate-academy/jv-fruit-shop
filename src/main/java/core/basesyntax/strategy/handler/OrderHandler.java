package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class OrderHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public OrderHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.update(fruitTransaction.getFruit(),
                fruitDao.getQuantity(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
    }
}
