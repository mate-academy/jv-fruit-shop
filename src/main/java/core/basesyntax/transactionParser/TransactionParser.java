package core.basesyntax.transactionParser;

import core.basesyntax.FruitTransaction;

import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseTransactions(List<String> lines);

}

//TransactionParser parses list of rows from file into list of FruitTransaction class