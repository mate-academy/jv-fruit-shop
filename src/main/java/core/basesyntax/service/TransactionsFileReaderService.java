package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionsFileReaderService {
    List<Transaction> getTransactionsFromFile();
}
