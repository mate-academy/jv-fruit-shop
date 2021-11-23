package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class StorageServiceImpl implements StorageService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final StorageDao<Fruit> storageDao;
    private final OperationStrategy operationStrategy;

    public StorageServiceImpl(StorageDao<Fruit> storageDao, OperationStrategy operationStrategy) {
        this.storageDao = storageDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void updateStorage(List<String[]> inputData) {
        inputData
                .forEach(l -> operationStrategy.getService(l[OPERATION_TYPE_INDEX])
                        .operate(l[FRUIT_NAME_INDEX], Integer.parseInt(l[QUANTITY_INDEX])));
    }

    @Override
    public List<String> getStorageStatistic() {
        return storageDao.getAll().stream()
                .map(e -> e.getName() + SEPARATOR + e.getQuantity())
                .collect(Collectors.toList());
    }
}
