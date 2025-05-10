package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;

public interface FruitParser {
    FruitTransaction parseString(String string);
}
