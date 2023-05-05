package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface Parser {
    public FruitTransaction parse(String data);
}
