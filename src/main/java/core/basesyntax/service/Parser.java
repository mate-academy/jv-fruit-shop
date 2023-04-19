package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface Parser {
    FruitTransaction splitLine(String line);
}
