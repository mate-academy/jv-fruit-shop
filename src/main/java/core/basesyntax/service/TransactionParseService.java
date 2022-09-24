package core.basesyntax.service;

import java.util.List;

public interface TransactionParseService {
    List<FruitTransaction> transactionParse(List<String> dailyTransactionList);
}
