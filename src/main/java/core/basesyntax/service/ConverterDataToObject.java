package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ConverterDataToObject {
    FruitTransaction convertDataToObject(String data);
}
