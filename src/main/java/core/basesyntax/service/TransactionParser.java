package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import java.util.List;

public interface TransactionParser {
    List<Transaction> parseTransactions(List<String> data);
}
