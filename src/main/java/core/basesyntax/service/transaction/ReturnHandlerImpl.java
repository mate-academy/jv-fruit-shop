package core.basesyntax.service.transaction;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandlerImpl implements TransactionHandler {
    private final FruitDao fruitDao;

    public ReturnHandlerImpl() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int oldQuantity = fruitDao.getQuantity(transaction.getFruit());
        int newQuantity = oldQuantity + transaction.getQuantity();
        fruitDao.add(transaction.getFruit(), newQuantity);
    }
}
