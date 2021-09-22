package core.basesyntax.service.impl;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.StorageService;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private final OperationService operationService;

    public StorageServiceImpl(HandlerStorage handlerStorage) {
        this.operationService = new OperationServiceImpl(handlerStorage);
    }

    @Override
    public void updateStorage(List<FruitRecord> recordList) {
        for (FruitRecord record : recordList) {
            operationService.setBalance(record);
        }
    }
}
