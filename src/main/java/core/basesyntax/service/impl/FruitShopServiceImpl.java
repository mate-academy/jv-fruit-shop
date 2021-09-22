package core.basesyntax.service.impl;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.RecordService;
import core.basesyntax.service.StorageService;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final RecordService recordService;
    private final StorageService storageService;

    public FruitShopServiceImpl(HandlerStorage handlerStorage) {
        this.recordService = new RecordServiceImpl();
        this.storageService = new StorageServiceImpl(handlerStorage);
    }

    @Override
    public void addToStorage(List<String> data) {
        storageService.updateStorage(recordService.getFruitRecords(data));
    }
}
