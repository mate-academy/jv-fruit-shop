package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void process(FruitTransaction transaction) {
        fruitDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
