package core.basesyntax.service;

import core.basesyntax.template.FruitTransaction;

public interface ParseService {
    FruitTransaction parseLine(String operation);
}
