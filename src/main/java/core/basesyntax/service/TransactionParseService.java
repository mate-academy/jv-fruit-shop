package core.basesyntax.service;

import java.util.List;

public interface TransactionParseService {
    List<FruitTransaction> parse(List<String> dailyTransactionList);
}
