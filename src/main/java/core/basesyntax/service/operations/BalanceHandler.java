package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
