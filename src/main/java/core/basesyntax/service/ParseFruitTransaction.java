package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ParseFruitTransaction {
    FruitTransaction processing(String string);
}
