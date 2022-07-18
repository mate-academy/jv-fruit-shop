package core.basesyntax.service;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoCsvImpl;
import core.basesyntax.db.Storage;

public class BalanceFileReaderServiceImpl implements BalanceFileReaderService {
    private static final String BALANCE_FILE_NAME = "src/main/resources/database.csv";
    private final TransactionDao transactionDao = new TransactionDaoCsvImpl();

    @Override
    public void getTransactionsFromFile() {
        Storage.transactions.addAll(transactionDao.getAll(BALANCE_FILE_NAME));
    }
}
