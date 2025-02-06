package core.basesyntax.service;

import core.basesyntax.infratructure.persistence.FruitRepository;
import core.basesyntax.service.usecases.FruitUseService;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private FruitRepository fruitRepository;
    private Map<Operation, FruitUseService> fruitUseServiceMap;

    public FruitServiceImpl(FruitRepository fruitRepository, Map<Operation,
            FruitUseService> fruitUseServiceMap) {
        this.fruitRepository = fruitRepository;
        this.fruitUseServiceMap = fruitUseServiceMap;
    }

    @Override
    public FruitRepository getFruitRepository() {
        return fruitRepository;
    }

    @Override
    public void makeOperation(Operation operation, String fruitName, int amount) {
        fruitUseServiceMap.get(operation).run(fruitName, amount);

    }
}
