package core.basesyntax.service;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public interface TransactionParserService {
    List<FruitTransaction> parse(List<String> rawData);
}
