package core.basesyntax.service.impl;

import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.StorageUpdateStrategy;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    private final List<StorageUpdateStrategy> servicesList;

    public OperationServiceImpl(List<StorageUpdateStrategy> servicesList) {
        this.servicesList = servicesList;
    }

    @Override
    public void manageStorageCells(String operationCode, String fruitName, int amount) {
        StorageUpdateStrategy storageUpdateService = servicesList.stream()
                .filter(service -> service.isServiceApplicable(operationCode))
                .findFirst()
                .orElseThrow();
        storageUpdateService.updateStorage(fruitName, amount);
    }
}
