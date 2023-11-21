package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ProcessorService {
    void process(FruitTransaction transaction);
}
