package core.basesyntax.service.impl;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.OperationHandlerService;
import core.basesyntax.service.StorageInfoUpdateService;
import java.util.List;

public class StorageInfoUpdateServiceImpl implements StorageInfoUpdateService {
    private OperationHandlerService operationHandlerService;

    public StorageInfoUpdateServiceImpl(HandlerStorage handlerStorage) {
        this.operationHandlerService = new OperationHandlerServiceImpl(handlerStorage);
    }

    @Override
    public void updateStorageInfo(List<FruitRecord> recordList) {
        for (FruitRecord record : recordList) {
            operationHandlerService.changeAmount(record);
        }
    }
}
