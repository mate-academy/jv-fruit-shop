package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface Parsing {
    FruitTransaction parse(String line);
}
