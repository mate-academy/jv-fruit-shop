package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;

public interface ParseService {
    FruitRecord getParsedLine(String row);
}
