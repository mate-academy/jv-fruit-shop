package core.basesyntax.service;

import core.basesyntax.service.model.FruitTransaction;

public interface ParseService {
    FruitTransaction parse(String line);
}
