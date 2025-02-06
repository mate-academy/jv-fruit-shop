package core.basesyntax.service.usecases;

import core.basesyntax.infratructure.persistence.FruitRepository;

public class FruitUseReposetory {
    FruitRepository fruitRepository;

    public FruitUseReposetory(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }
}
