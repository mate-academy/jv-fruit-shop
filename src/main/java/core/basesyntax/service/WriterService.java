package core.basesyntax.service;

import core.basesyntax.model.Fruit;

import java.util.Map;

public interface WriterService {
    void writeBalanceOfFruitToFile(Map<Fruit, Integer> balance);
}
