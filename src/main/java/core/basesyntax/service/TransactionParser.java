package core.basesyntax.service;

import core.basesyntax.transaction.Transaction;
import java.util.List;

public interface TransactionParser {
    List<Transaction> parse(List<String> storageData);
}
