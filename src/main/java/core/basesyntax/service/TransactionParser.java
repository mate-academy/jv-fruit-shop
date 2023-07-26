package core.basesyntax.service;

import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseTransactions(List<String> dataList);
}
