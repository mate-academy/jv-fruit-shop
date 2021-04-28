package service.impl;

import java.util.List;
import model.FruitRecordDto;
import service.OperationStrategy;
import service.StoreService;

public class StoreServiceImpl implements StoreService {
    private OperationStrategy strategy;

    public StoreServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void doInstruction(List<FruitRecordDto> info) {
        for (FruitRecordDto record : info) {
            strategy.get(record.getOperationType()).apply(record);
        }
    }
}
