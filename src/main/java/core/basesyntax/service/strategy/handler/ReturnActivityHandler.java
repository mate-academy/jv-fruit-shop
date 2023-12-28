package core.basesyntax.service.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnActivityHandler implements ActivityHandler {
    private final FruitDao fruitDao;

    public ReturnActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void accept(FruitTransaction fruitTransaction) {
        fruitDao.addFruitQuantity(fruitTransaction.getFruit(),
                                    fruitTransaction.getQuantity());
    }
}
