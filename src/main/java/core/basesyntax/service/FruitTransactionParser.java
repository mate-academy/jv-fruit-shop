package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface FruitTransactionParser {
    List<Transaction> parseList(List<String> transactionListString);
}
