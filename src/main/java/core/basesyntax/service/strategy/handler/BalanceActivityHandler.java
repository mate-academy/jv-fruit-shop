package core.basesyntax.service.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceActivityHandler implements ActivityHandler {
    private final FruitDao fruitDao;

    public BalanceActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void accept(FruitTransaction fruitTransaction) {
        fruitDao.setFruitQuantity(fruitTransaction.getFruit(),
                                    fruitTransaction.getQuantity());
    }
}
