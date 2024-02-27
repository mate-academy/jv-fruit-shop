package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FileService {
    private static final String INPUT_FILE_NAME = "src/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/output.csv";
    private FruitDao fruitDao;
    private FruitTransactionDao fruitTransactionDao;

    public FileService() {
        this.fruitDao = new FruitDaoImpl();
        this.fruitTransactionDao = new FruitTransactionDaoImpl();
    }

    public List<FruitTransaction> readFromFile() {
        return fruitTransactionDao.getAllTransactions(INPUT_FILE_NAME);
    }

    public void writeReport() {
        fruitDao.writeReportToFile(OUTPUT_FILE_NAME);
    }
}
