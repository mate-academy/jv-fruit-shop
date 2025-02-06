package core.basesyntax.service;

import core.basesyntax.infratructure.persistence.FruitRepository;
import core.basesyntax.service.usecases.FruitUseService;

import java.util.Map;

public class FruitServiceImpl implements FruitService {
    FruitRepository fruitRepository;
    private Map<FruitOperationsSupplier.Operation, FruitUseService> fruitUseServiceMap;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        FruitOperationsSupplier.supply(fruitUseServiceMap, fruitRepository);
    }

    @Override
    public void makeOperation(FruitOperationsSupplier.Operation operation, String fruitName, int amount) {
        fruitUseServiceMap.get(operation).run(fruitName, amount);

    }
}
