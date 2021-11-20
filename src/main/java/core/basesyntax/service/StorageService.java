package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class StorageService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final StorageDao<Fruit, Integer> storageDao;
    private final OperationStrategy operationStrategy;

    public StorageService() {
        storageDao = new StorageDaoImpl();
        operationStrategy = new OperationStrategy();
    }

    public void updateStorage(List<String> inputData) {
        inputData.stream()
                .map(l -> l.split(SEPARATOR))
                .forEach(l -> operationStrategy.getService(l[OPERATION_TYPE_INDEX])
                        .operate(l[FRUIT_NAME_INDEX], l[QUANTITY_INDEX]));
    }

    public List<String> getStorageStatistic() {
        return storageDao.getStorageInfo().stream()
                .map(e -> e.getKey() + SEPARATOR + e.getValue())
                .collect(Collectors.toList());
    }
}
