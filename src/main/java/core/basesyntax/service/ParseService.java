package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ParseService {
    FruitTransaction fruitTransaction(String line);
}
