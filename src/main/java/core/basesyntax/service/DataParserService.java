package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface DataParserService {
    FruitTransaction createFruitTransaction(String data);
}
