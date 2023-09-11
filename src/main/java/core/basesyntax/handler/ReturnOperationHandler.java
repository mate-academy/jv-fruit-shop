package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void process(FruitTransaction transaction) {
        int amount = fruitDao.get(transaction.getFruit());
        fruitDao.add(transaction.getFruit(), amount + transaction.getQuantity());
    }
}
