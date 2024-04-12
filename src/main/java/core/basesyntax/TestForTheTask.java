package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.service.TransactionStrategy;

/**
 * Feel free to remove this class and create your own.
 */
public class TestForTheTask {

    public static void main(String[] args) {
        TransactionStrategy transactionStrategy = new TransactionStrategy();
        FruitTransactionDaoImpl fruitTransactionDao = new FruitTransactionDaoImpl();
        fruitTransactionDao.addToStorage("data.CSV");
        transactionStrategy.getShopService();
        fruitTransactionDao.getReport();
    }
}

