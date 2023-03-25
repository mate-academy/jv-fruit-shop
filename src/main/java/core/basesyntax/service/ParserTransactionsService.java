package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ParserTransactionsService {
    FruitTransaction getDataFromLine(String line);
}
