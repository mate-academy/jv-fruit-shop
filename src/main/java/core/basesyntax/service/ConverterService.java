package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ConverterService {
    FruitTransaction convertStringToFruitTransaction(String transaction);
}
