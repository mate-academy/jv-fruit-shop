package core.basesyntax.transactionParser;

import core.basesyntax.FruitTransaction;

import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseTransactions(List<String> lines);

}
