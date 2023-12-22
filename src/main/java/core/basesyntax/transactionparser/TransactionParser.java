package core.basesyntax.transactionparser;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseTransactions(List<String> lines);
}
