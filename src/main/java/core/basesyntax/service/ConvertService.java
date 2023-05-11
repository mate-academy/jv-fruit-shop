package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ConvertService {
    FruitTransaction convertToFruitTransaction(String transactions);
}
