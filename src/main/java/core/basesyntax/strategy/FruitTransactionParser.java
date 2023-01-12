package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> parseTransactions(String transaction);
}
