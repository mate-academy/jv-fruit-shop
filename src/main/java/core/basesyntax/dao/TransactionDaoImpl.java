package core.basesyntax.dao;

import core.basesyntax.model.Transaction;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public List<Transaction> readFromFile(String fileName) {
        return new TransactionDaoCsvImpl().readFromFile(fileName);
    }
}
