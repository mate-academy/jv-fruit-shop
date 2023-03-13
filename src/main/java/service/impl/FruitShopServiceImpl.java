package service.impl;

import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.OperationStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> report(List<FruitTransaction> parsed) {
        if (parsed == null) {
            throw new RuntimeException("Arguments can't be null");
        }
        parsed.forEach(t -> operationStrategy.get(t.getOperation()).operation(t));
        return Storage.getMap();
    }
}
