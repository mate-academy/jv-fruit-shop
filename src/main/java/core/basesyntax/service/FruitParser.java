package core.basesyntax.service;

import core.basesyntax.models.FruitTransition;

public interface FruitParser {
    FruitTransition parseString(String string);
}
