package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ParserService {
    FruitTransaction parseToTransaction(String line);
}
