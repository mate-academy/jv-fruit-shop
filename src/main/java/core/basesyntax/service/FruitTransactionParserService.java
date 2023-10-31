package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParserService {
    List<FruitTransaction> stringToFruitTransactions(List<String> strings);
}
