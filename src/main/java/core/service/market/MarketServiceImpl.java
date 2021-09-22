package core.service.market;

import core.db.StorageServiceImpl;
import core.model.FruitRecord;
import core.service.strategy.OperationTypeStrategy;
import java.util.List;

public class MarketServiceImpl implements MarketService {
    private final OperationTypeStrategy strategy;
    private StorageServiceImpl storageService = new StorageServiceImpl();

    public MarketServiceImpl(OperationTypeStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void applyOperations(List<FruitRecord> fruitRecordList) {
        for (FruitRecord record : fruitRecordList) {
            storageService.put(record, strategy);
        }
    }
}
