package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements FruitOperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.addFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
