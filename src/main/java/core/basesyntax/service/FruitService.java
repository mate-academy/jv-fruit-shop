package core.basesyntax.service;

import core.basesyntax.infratructure.persistence.FruitRepository;

public interface FruitService {
    void makeOperation(Operation operation, String fruitName, int amount);

    FruitRepository getFruitRepository();
}
