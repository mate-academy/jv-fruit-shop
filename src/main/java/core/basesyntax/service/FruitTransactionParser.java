package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> toTransactions(List<String> data);
}
