package core.basesyntax.service;

import core.basesyntax.operation.Transaction;
import java.util.List;

public interface TransactionParser {
    List<Transaction> parse(List<String> storageData);
}
