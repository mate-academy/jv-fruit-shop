package core.basesyntax.service.impl;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.RecordListMakerService;
import core.basesyntax.service.StorageInfoUpdateService;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private StorageInfoUpdateService storageInfoUpdateService;
    private RecordListMakerService recordListMakerService;

    public FruitShopServiceImpl(HandlerStorage handlerStorage) {
        this.recordListMakerService = new RecordListMakerServiceImpl();
        this.storageInfoUpdateService = new StorageInfoUpdateServiceImpl(handlerStorage);
    }

    @Override
    public void addInfoToStorage(List<String> rowsList) {
        storageInfoUpdateService.updateStorageInfo(
                recordListMakerService.getFruitRecordList(rowsList));
    }
}
