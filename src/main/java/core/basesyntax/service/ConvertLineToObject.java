package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ConvertLineToObject {
    FruitTransaction getData(String line);
}
