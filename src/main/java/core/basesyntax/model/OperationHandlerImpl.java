package core.basesyntax.model;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.strategy.OperationStrategy;
import core.basesyntax.model.strategy.StrategySupplier;
import java.util.Map;

public class OperationHandlerImpl implements OperationHandler {
    private static final String WORDS_SEPARATOR = ",";
    private static final String LINES_SEPARATOR = "\n";
    private final StrategySupplier supplier;
    private final FruitDao fruitDao;

    public OperationHandlerImpl(StrategySupplier supplier, FruitDao fruitDao) {
        this.supplier = supplier;
        this.fruitDao = fruitDao;
    }

    @Override
    public void processRequest(String operation, String fruitName, int fruitQuantity) {
        OperationStrategy operationStrategy = supplier.getStrategy(operation);
        if (operationStrategy == null) {
            throw new RuntimeException("Invalid operation " + operation);
        }
        operationStrategy.process(fruitDao, fruitName, fruitQuantity);
    }

    @Override
    public String getCurrentStorageState() {
        StringBuilder currentStorageState = new StringBuilder();
        currentStorageState.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> pair : fruitDao.getSet()) {
            currentStorageState.append(pair.getKey())
                    .append(WORDS_SEPARATOR)
                    .append(pair.getValue())
                    .append(LINES_SEPARATOR);
        }
        return currentStorageState.toString();
    }
}

