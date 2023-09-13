package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionParser {
    List<Transaction> parseTransactionList(List<String> transactions);
}
