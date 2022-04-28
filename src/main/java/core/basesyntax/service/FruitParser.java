package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitParser {
    FruitTransaction parse(String stringList);
}
