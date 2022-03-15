package core.basesyntax.service;

import core.basesyntax.service.impl.FruitTransaction;

public interface ParserService {
    FruitTransaction parseToTransaction(String line);
}
