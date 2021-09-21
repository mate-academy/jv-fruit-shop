package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;

public interface FruitParserService {
    FruitRecord parseRecord(String[] recordData);
}
