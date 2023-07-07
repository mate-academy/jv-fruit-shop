package mate.academy.service.transaction;

import mate.academy.dao.FruitDao;
import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.FruitTransaction;

public class BalanceHandlerImpl implements TransactionHandler {
    private final FruitDao fruitDao;

    public BalanceHandlerImpl() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        processFruit(transaction);
        fruitDao.add(transaction.getFruit(), transaction.getQuantity());
    }
    public void processFruit(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
        throw new RuntimeException("Negative number of fruits "
                    + transaction.getFruit()
                    + ": "
                    + transaction.getQuantity());
        }
    }

}
