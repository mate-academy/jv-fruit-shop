package core.basesyntax.service;

import core.basesyntax.model.FruitTransactions;
import java.util.List;

public interface TransactionParser {
    List<FruitTransactions> parseTransactions(List<String> lines);
}
