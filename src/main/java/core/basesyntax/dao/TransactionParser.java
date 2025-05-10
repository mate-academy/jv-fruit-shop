package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseTransactions(List<String> stringList);
}
