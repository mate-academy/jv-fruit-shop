package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionStrategy;

public interface ParserService {
    FruitTransaction getDataFromLine(String line, TransactionStrategy transactionStrategy);
}
