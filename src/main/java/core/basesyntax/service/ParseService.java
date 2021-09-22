package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;

public interface ParseService {
    FruitRecord parseData(String line);
}
