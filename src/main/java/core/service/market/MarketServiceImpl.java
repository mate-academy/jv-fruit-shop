package core.service.market;

import core.db.Storage;
import core.exception.ValidationException;
import core.model.FruitRecord;
import core.model.OperationType;
import core.service.strategy.OperationTypeStrategy;
import java.util.List;

public class MarketServiceImpl implements MarketService {
    private final OperationTypeStrategy strategy;

    public MarketServiceImpl(OperationTypeStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void applyOperations(List<FruitRecord> fruitRecordList) throws ValidationException {
        for (FruitRecord record : fruitRecordList) {
            if (Storage.stockStorage.containsValue(record)) {
                // String operationType = record.getOperationType();
                int previousAmount = Storage.stockStorage.get(record.getOperationType());
                String stringOperationType = record.getOperationType();
                int amount = strategy.getHandle(OperationType.valueOf(record.getOperationType()))
                        .getUpdateAmount(record, previousAmount);
                Storage.stockStorage.put(stringOperationType, amount);
            } else {
                Storage.stockStorage.put(record.getFruit(), record.getAmount());
            }
        }
    }
}
