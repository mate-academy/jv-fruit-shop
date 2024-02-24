package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class ReaderService {
    private static final String FILE_NAME = "input.csv";
    private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

    public List<FruitTransaction> readFromFile() {
        return fruitTransactionDao.getAllTransactions(FILE_NAME);
    }

}
