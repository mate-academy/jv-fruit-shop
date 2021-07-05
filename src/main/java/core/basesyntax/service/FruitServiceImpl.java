package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.TransferAction;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.StrategySupplierImpl;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String WORDS_SEPARATOR = ",";
    private static final String LINES_SEPARATOR = "\n";
    private final StrategySupplierImpl supplier;
    private final FruitDao fruitDao;

    public FruitServiceImpl(StrategySupplierImpl supplier, FruitDao fruitDao) {
        this.supplier = supplier;
        this.fruitDao = fruitDao;
    }

    @Override
    public void processRequest(List<TransferAction> transferActions) {
        OperationStrategy operationStrategy;
        for (TransferAction transferAction : transferActions) {
            operationStrategy = supplier.getStrategy(transferAction.getOperation());
            if (operationStrategy == null) {
                throw new RuntimeException("Invalid operation");
            }
            operationStrategy.process(fruitDao, transferAction);
        }
    }

    @Override
    public String getCurrentStorageState() {
        StringBuilder currentStorageState = new StringBuilder();
        currentStorageState.append("fruit,quantity\n");
        for (Map.Entry<Fruit, Integer> pair : fruitDao.getSet()) {
            currentStorageState.append(pair.getKey().getName())
                    .append(WORDS_SEPARATOR)
                    .append(pair.getValue())
                    .append(LINES_SEPARATOR);
        }
        return currentStorageState.toString();
    }
}

