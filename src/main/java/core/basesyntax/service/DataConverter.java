package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface DataConverter {
    FruitTransaction convertDataToObject(String data);
}
