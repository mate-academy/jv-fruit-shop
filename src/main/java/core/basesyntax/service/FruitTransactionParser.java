package core.basesyntax.service;

import core.basesyntax.dto.FruitTransaction;
import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> parseTransactions(List<String> data);
}
