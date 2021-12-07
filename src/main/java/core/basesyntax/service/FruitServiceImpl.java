package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.StrategySupplier;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String WORDS_SEPARATOR = ",";
    private static final String LINES_SEPARATOR = "\n";
    private final StrategySupplier supplier;
    private final FruitDao fruitDao;

    public FruitServiceImpl(StrategySupplier supplier, FruitDao fruitDao) {
        this.supplier = supplier;
        this.fruitDao = fruitDao;
    }

    @Override
    public void processRequests(List<FruitDto> transferActions) {
        OperationStrategy operationStrategy;
        for (FruitDto transferAction : transferActions) {
            operationStrategy = supplier.getStrategy(transferAction.getOperation());
            if (operationStrategy == null) {
                throw new RuntimeException("Invalid operation" + transferAction.getOperation());
            }
            operationStrategy.process(transferAction);
        }
    }

    @Override
    public String getCurrentStorageState() {
        StringBuilder currentStorageState = new StringBuilder();
        currentStorageState.append("fruit,quantity\n");
        for (Map.Entry<Fruit, Integer> pair : fruitDao.getAll()) {
            currentStorageState.append(pair.getKey().getName())
                    .append(WORDS_SEPARATOR)
                    .append(pair.getValue())
                    .append(LINES_SEPARATOR);
        }
        return currentStorageState.toString();
    }
}

