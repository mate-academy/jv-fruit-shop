package mate.academy.service.transaction;

import mate.academy.dao.FruitDao;
import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.FruitTransaction;

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
