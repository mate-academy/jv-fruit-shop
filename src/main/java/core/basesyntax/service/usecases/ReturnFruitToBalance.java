package core.basesyntax.service.usecases;

import core.basesyntax.infratructure.persistence.FruitRepository;

public interface ReturnFruitToBalance extends FruitUseService {
    void run(String fruitName, int amount);
}
