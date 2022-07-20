package core.basesyntax.service;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoCsvImpl;
import core.basesyntax.model.Transaction;
import java.util.List;

public class TransactionsFileReaderServiceImpl implements TransactionsFileReaderService {
    private static final String BALANCE_FILE_NAME = "src/main/resources/database.csv";
    private final TransactionDao transactionDao = new TransactionDaoCsvImpl();

    @Override
    public List<Transaction> getTransactionsFromFile() {
        return transactionDao.readFromFile(BALANCE_FILE_NAME);
    }
}
