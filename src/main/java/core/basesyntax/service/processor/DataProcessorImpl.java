package core.basesyntax.service.processor;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class DataProcessorImpl implements DataProcessor {

    private final StorageDao storageDao = new StorageDaoImpl();
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> balanceFruitMap;

    public DataProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.balanceFruitMap = new HashMap<>();
    }

    @Override
    public String calculateData() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (FruitTransaction fruit : storageDao.getAll()) {
            balanceFruitMap.put(storageDao.getBalance(fruit).getFruit(),
                    operationStrategy.get(fruit.getOperation()).getHandler(fruit));
        }
        for (Map.Entry<String, Integer> balance : balanceFruitMap.entrySet()) {
            stringBuilder.append(balance.getKey())
                    .append(",")
                    .append(balance.getValue())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

}
