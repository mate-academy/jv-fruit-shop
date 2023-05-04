package core.basesyntax.parser;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface Parser {
    public FruitTransaction parse(String data);
}
