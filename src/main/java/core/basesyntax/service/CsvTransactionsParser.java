package core.basesyntax.service;

import java.util.List;
import core.basesyntax.model.FruitTransaction;

public interface CsvTransactionsParser {
    List<FruitTransaction> parseTransactions(List<String> transactions);
}
