package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface FileParser {
    List<Transaction> parseTransactionList(List<String> transactionList);
}
